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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug332217TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug332217TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Plain'", "'Grouped'", "'Default'", "'Value1'", "'Value2'", "'Subtitle'", "'None'", "'Link'", "'Detail'", "'Check'", "'.'", "'('", "')'", "'replace('", "','", "'urlconform('", "'['", "']'", "'split('", "'tableview'", "'{'", "'}'", "'title:'", "'titleImage:'", "'style:'", "'section'", "'cell'", "'text:'", "'details:'", "'image:'", "'action:'", "'accessory:'", "'for'", "'in'", "':'", "'@selector'", "'[]'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
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
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBug332217TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug332217TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug332217TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g"; }


     
     	private Bug332217TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug332217TestLanguageGrammarAccess grammarAccess) {
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:69:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:73:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:74:1: ( ( rule__Model__ElementsAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:75:1: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:76:1: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==30) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:76:2: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__ElementsAssignment_in_ruleModel94);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleTypeDescription"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:90:1: entryRuleTypeDescription : ruleTypeDescription EOF ;
    public final void entryRuleTypeDescription() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:91:1: ( ruleTypeDescription EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:92:1: ruleTypeDescription EOF
            {
             before(grammarAccess.getTypeDescriptionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeDescription_in_entryRuleTypeDescription124);
            ruleTypeDescription();

            state._fsp--;

             after(grammarAccess.getTypeDescriptionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeDescription131); 

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
    // $ANTLR end "entryRuleTypeDescription"


    // $ANTLR start "ruleTypeDescription"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:99:1: ruleTypeDescription : ( ( rule__TypeDescription__Group__0 ) ) ;
    public final void ruleTypeDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:103:2: ( ( ( rule__TypeDescription__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:104:1: ( ( rule__TypeDescription__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:104:1: ( ( rule__TypeDescription__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:105:1: ( rule__TypeDescription__Group__0 )
            {
             before(grammarAccess.getTypeDescriptionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:106:1: ( rule__TypeDescription__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:106:2: rule__TypeDescription__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeDescription__Group__0_in_ruleTypeDescription157);
            rule__TypeDescription__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeDescriptionAccess().getGroup()); 

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
    // $ANTLR end "ruleTypeDescription"


    // $ANTLR start "entryRuleParameter"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:118:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:119:1: ( ruleParameter EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:120:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter184);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter191); 

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:127:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:131:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:132:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:132:1: ( ( rule__Parameter__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:133:1: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:134:1: ( rule__Parameter__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:134:2: rule__Parameter__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0_in_ruleParameter217);
            rule__Parameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getGroup()); 

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleObjectReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:146:1: entryRuleObjectReference : ruleObjectReference EOF ;
    public final void entryRuleObjectReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:147:1: ( ruleObjectReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:148:1: ruleObjectReference EOF
            {
             before(grammarAccess.getObjectReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectReference_in_entryRuleObjectReference244);
            ruleObjectReference();

            state._fsp--;

             after(grammarAccess.getObjectReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectReference251); 

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
    // $ANTLR end "entryRuleObjectReference"


    // $ANTLR start "ruleObjectReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:155:1: ruleObjectReference : ( ( rule__ObjectReference__Group__0 ) ) ;
    public final void ruleObjectReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:159:2: ( ( ( rule__ObjectReference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:160:1: ( ( rule__ObjectReference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:160:1: ( ( rule__ObjectReference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:161:1: ( rule__ObjectReference__Group__0 )
            {
             before(grammarAccess.getObjectReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:162:1: ( rule__ObjectReference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:162:2: rule__ObjectReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectReference__Group__0_in_ruleObjectReference277);
            rule__ObjectReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjectReferenceAccess().getGroup()); 

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
    // $ANTLR end "ruleObjectReference"


    // $ANTLR start "entryRuleNestedObjectReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:174:1: entryRuleNestedObjectReference : ruleNestedObjectReference EOF ;
    public final void entryRuleNestedObjectReference() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:175:1: ( ruleNestedObjectReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:176:1: ruleNestedObjectReference EOF
            {
             before(grammarAccess.getNestedObjectReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedObjectReference_in_entryRuleNestedObjectReference304);
            ruleNestedObjectReference();

            state._fsp--;

             after(grammarAccess.getNestedObjectReferenceRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedObjectReference311); 

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
    // $ANTLR end "entryRuleNestedObjectReference"


    // $ANTLR start "ruleNestedObjectReference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:183:1: ruleNestedObjectReference : ( ( rule__NestedObjectReference__Group__0 ) ) ;
    public final void ruleNestedObjectReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:187:2: ( ( ( rule__NestedObjectReference__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:188:1: ( ( rule__NestedObjectReference__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:188:1: ( ( rule__NestedObjectReference__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:189:1: ( rule__NestedObjectReference__Group__0 )
            {
             before(grammarAccess.getNestedObjectReferenceAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:190:1: ( rule__NestedObjectReference__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:190:2: rule__NestedObjectReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__Group__0_in_ruleNestedObjectReference337);
            rule__NestedObjectReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNestedObjectReferenceAccess().getGroup()); 

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
    // $ANTLR end "ruleNestedObjectReference"


    // $ANTLR start "entryRuleImageExpression"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:204:1: entryRuleImageExpression : ruleImageExpression EOF ;
    public final void entryRuleImageExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:205:1: ( ruleImageExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:206:1: ruleImageExpression EOF
            {
             before(grammarAccess.getImageExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImageExpression_in_entryRuleImageExpression366);
            ruleImageExpression();

            state._fsp--;

             after(grammarAccess.getImageExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImageExpression373); 

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
    // $ANTLR end "entryRuleImageExpression"


    // $ANTLR start "ruleImageExpression"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:213:1: ruleImageExpression : ( ruleScalarExpression ) ;
    public final void ruleImageExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:217:2: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:218:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:218:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:219:1: ruleScalarExpression
            {
             before(grammarAccess.getImageExpressionAccess().getScalarExpressionParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_ruleImageExpression399);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getImageExpressionAccess().getScalarExpressionParserRuleCall()); 

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
    // $ANTLR end "ruleImageExpression"


    // $ANTLR start "entryRuleScalarExpression"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:232:1: entryRuleScalarExpression : ruleScalarExpression EOF ;
    public final void entryRuleScalarExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:233:1: ( ruleScalarExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:234:1: ruleScalarExpression EOF
            {
             before(grammarAccess.getScalarExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_entryRuleScalarExpression425);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getScalarExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScalarExpression432); 

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
    // $ANTLR end "entryRuleScalarExpression"


    // $ANTLR start "ruleScalarExpression"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:241:1: ruleScalarExpression : ( ( rule__ScalarExpression__Alternatives ) ) ;
    public final void ruleScalarExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:245:2: ( ( ( rule__ScalarExpression__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:246:1: ( ( rule__ScalarExpression__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:246:1: ( ( rule__ScalarExpression__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:247:1: ( rule__ScalarExpression__Alternatives )
            {
             before(grammarAccess.getScalarExpressionAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:248:1: ( rule__ScalarExpression__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:248:2: rule__ScalarExpression__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ScalarExpression__Alternatives_in_ruleScalarExpression458);
            rule__ScalarExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getScalarExpressionAccess().getAlternatives()); 

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
    // $ANTLR end "ruleScalarExpression"


    // $ANTLR start "entryRuleCollectionExpression"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:260:1: entryRuleCollectionExpression : ruleCollectionExpression EOF ;
    public final void entryRuleCollectionExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:261:1: ( ruleCollectionExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:262:1: ruleCollectionExpression EOF
            {
             before(grammarAccess.getCollectionExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCollectionExpression_in_entryRuleCollectionExpression485);
            ruleCollectionExpression();

            state._fsp--;

             after(grammarAccess.getCollectionExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionExpression492); 

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
    // $ANTLR end "entryRuleCollectionExpression"


    // $ANTLR start "ruleCollectionExpression"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:269:1: ruleCollectionExpression : ( ( rule__CollectionExpression__Alternatives ) ) ;
    public final void ruleCollectionExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:273:2: ( ( ( rule__CollectionExpression__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:274:1: ( ( rule__CollectionExpression__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:274:1: ( ( rule__CollectionExpression__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:275:1: ( rule__CollectionExpression__Alternatives )
            {
             before(grammarAccess.getCollectionExpressionAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:276:1: ( rule__CollectionExpression__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:276:2: rule__CollectionExpression__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionExpression__Alternatives_in_ruleCollectionExpression518);
            rule__CollectionExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCollectionExpressionAccess().getAlternatives()); 

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
    // $ANTLR end "ruleCollectionExpression"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:288:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:289:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:290:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral545);
            ruleStringLiteral();

            state._fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral552); 

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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:297:1: ruleStringLiteral : ( ( rule__StringLiteral__ValueAssignment ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:301:2: ( ( ( rule__StringLiteral__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:302:1: ( ( rule__StringLiteral__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:302:1: ( ( rule__StringLiteral__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:303:1: ( rule__StringLiteral__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:304:1: ( rule__StringLiteral__ValueAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:304:2: rule__StringLiteral__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringLiteral__ValueAssignment_in_ruleStringLiteral578);
            rule__StringLiteral__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getValueAssignment()); 

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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleStringFunction"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:316:1: entryRuleStringFunction : ruleStringFunction EOF ;
    public final void entryRuleStringFunction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:317:1: ( ruleStringFunction EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:318:1: ruleStringFunction EOF
            {
             before(grammarAccess.getStringFunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringFunction_in_entryRuleStringFunction605);
            ruleStringFunction();

            state._fsp--;

             after(grammarAccess.getStringFunctionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringFunction612); 

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
    // $ANTLR end "entryRuleStringFunction"


    // $ANTLR start "ruleStringFunction"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:325:1: ruleStringFunction : ( ( rule__StringFunction__Alternatives ) ) ;
    public final void ruleStringFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:329:2: ( ( ( rule__StringFunction__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:330:1: ( ( rule__StringFunction__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:330:1: ( ( rule__StringFunction__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:331:1: ( rule__StringFunction__Alternatives )
            {
             before(grammarAccess.getStringFunctionAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:332:1: ( rule__StringFunction__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:332:2: rule__StringFunction__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Alternatives_in_ruleStringFunction638);
            rule__StringFunction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStringFunctionAccess().getAlternatives()); 

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
    // $ANTLR end "ruleStringFunction"


    // $ANTLR start "entryRuleCollectionLiteral"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:344:1: entryRuleCollectionLiteral : ruleCollectionLiteral EOF ;
    public final void entryRuleCollectionLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:345:1: ( ruleCollectionLiteral EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:346:1: ruleCollectionLiteral EOF
            {
             before(grammarAccess.getCollectionLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteral_in_entryRuleCollectionLiteral665);
            ruleCollectionLiteral();

            state._fsp--;

             after(grammarAccess.getCollectionLiteralRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteral672); 

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
    // $ANTLR end "entryRuleCollectionLiteral"


    // $ANTLR start "ruleCollectionLiteral"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:353:1: ruleCollectionLiteral : ( ( rule__CollectionLiteral__Group__0 ) ) ;
    public final void ruleCollectionLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:357:2: ( ( ( rule__CollectionLiteral__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:358:1: ( ( rule__CollectionLiteral__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:358:1: ( ( rule__CollectionLiteral__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:359:1: ( rule__CollectionLiteral__Group__0 )
            {
             before(grammarAccess.getCollectionLiteralAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:360:1: ( rule__CollectionLiteral__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:360:2: rule__CollectionLiteral__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__0_in_ruleCollectionLiteral698);
            rule__CollectionLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionLiteralAccess().getGroup()); 

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
    // $ANTLR end "ruleCollectionLiteral"


    // $ANTLR start "entryRuleCollectionFunction"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:372:1: entryRuleCollectionFunction : ruleCollectionFunction EOF ;
    public final void entryRuleCollectionFunction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:373:1: ( ruleCollectionFunction EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:374:1: ruleCollectionFunction EOF
            {
             before(grammarAccess.getCollectionFunctionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCollectionFunction_in_entryRuleCollectionFunction725);
            ruleCollectionFunction();

            state._fsp--;

             after(grammarAccess.getCollectionFunctionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionFunction732); 

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
    // $ANTLR end "entryRuleCollectionFunction"


    // $ANTLR start "ruleCollectionFunction"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:381:1: ruleCollectionFunction : ( ( rule__CollectionFunction__Group__0 ) ) ;
    public final void ruleCollectionFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:385:2: ( ( ( rule__CollectionFunction__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:386:1: ( ( rule__CollectionFunction__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:386:1: ( ( rule__CollectionFunction__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:387:1: ( rule__CollectionFunction__Group__0 )
            {
             before(grammarAccess.getCollectionFunctionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:388:1: ( rule__CollectionFunction__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:388:2: rule__CollectionFunction__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__0_in_ruleCollectionFunction758);
            rule__CollectionFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionFunctionAccess().getGroup()); 

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
    // $ANTLR end "ruleCollectionFunction"


    // $ANTLR start "entryRuleTableView"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:400:1: entryRuleTableView : ruleTableView EOF ;
    public final void entryRuleTableView() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:401:1: ( ruleTableView EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:402:1: ruleTableView EOF
            {
             before(grammarAccess.getTableViewRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTableView_in_entryRuleTableView785);
            ruleTableView();

            state._fsp--;

             after(grammarAccess.getTableViewRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTableView792); 

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
    // $ANTLR end "entryRuleTableView"


    // $ANTLR start "ruleTableView"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:409:1: ruleTableView : ( ( rule__TableView__Group__0 ) ) ;
    public final void ruleTableView() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:413:2: ( ( ( rule__TableView__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:414:1: ( ( rule__TableView__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:414:1: ( ( rule__TableView__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:415:1: ( rule__TableView__Group__0 )
            {
             before(grammarAccess.getTableViewAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:416:1: ( rule__TableView__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:416:2: rule__TableView__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__0_in_ruleTableView818);
            rule__TableView__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableViewAccess().getGroup()); 

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
    // $ANTLR end "ruleTableView"


    // $ANTLR start "entryRuleSection"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:430:1: entryRuleSection : ruleSection EOF ;
    public final void entryRuleSection() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:431:1: ( ruleSection EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:432:1: ruleSection EOF
            {
             before(grammarAccess.getSectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSection_in_entryRuleSection847);
            ruleSection();

            state._fsp--;

             after(grammarAccess.getSectionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSection854); 

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
    // $ANTLR end "entryRuleSection"


    // $ANTLR start "ruleSection"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:439:1: ruleSection : ( ( rule__Section__Group__0 ) ) ;
    public final void ruleSection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:443:2: ( ( ( rule__Section__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:444:1: ( ( rule__Section__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:444:1: ( ( rule__Section__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:445:1: ( rule__Section__Group__0 )
            {
             before(grammarAccess.getSectionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:446:1: ( rule__Section__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:446:2: rule__Section__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__0_in_ruleSection880);
            rule__Section__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSectionAccess().getGroup()); 

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
    // $ANTLR end "ruleSection"


    // $ANTLR start "entryRuleCell"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:458:1: entryRuleCell : ruleCell EOF ;
    public final void entryRuleCell() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:459:1: ( ruleCell EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:460:1: ruleCell EOF
            {
             before(grammarAccess.getCellRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCell_in_entryRuleCell907);
            ruleCell();

            state._fsp--;

             after(grammarAccess.getCellRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCell914); 

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
    // $ANTLR end "entryRuleCell"


    // $ANTLR start "ruleCell"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:467:1: ruleCell : ( ( rule__Cell__Group__0 ) ) ;
    public final void ruleCell() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:471:2: ( ( ( rule__Cell__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:472:1: ( ( rule__Cell__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:472:1: ( ( rule__Cell__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:473:1: ( rule__Cell__Group__0 )
            {
             before(grammarAccess.getCellAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:474:1: ( rule__Cell__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:474:2: rule__Cell__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__0_in_ruleCell940);
            rule__Cell__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getGroup()); 

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
    // $ANTLR end "ruleCell"


    // $ANTLR start "entryRuleCollectionIterator"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:486:1: entryRuleCollectionIterator : ruleCollectionIterator EOF ;
    public final void entryRuleCollectionIterator() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:487:1: ( ruleCollectionIterator EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:488:1: ruleCollectionIterator EOF
            {
             before(grammarAccess.getCollectionIteratorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCollectionIterator_in_entryRuleCollectionIterator967);
            ruleCollectionIterator();

            state._fsp--;

             after(grammarAccess.getCollectionIteratorRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionIterator974); 

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
    // $ANTLR end "entryRuleCollectionIterator"


    // $ANTLR start "ruleCollectionIterator"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:495:1: ruleCollectionIterator : ( ( rule__CollectionIterator__Group__0 ) ) ;
    public final void ruleCollectionIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:499:2: ( ( ( rule__CollectionIterator__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:500:1: ( ( rule__CollectionIterator__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:500:1: ( ( rule__CollectionIterator__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:501:1: ( rule__CollectionIterator__Group__0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:502:1: ( rule__CollectionIterator__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:502:2: rule__CollectionIterator__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__0_in_ruleCollectionIterator1000);
            rule__CollectionIterator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionIteratorAccess().getGroup()); 

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
    // $ANTLR end "ruleCollectionIterator"


    // $ANTLR start "entryRuleViewAction"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:514:1: entryRuleViewAction : ruleViewAction EOF ;
    public final void entryRuleViewAction() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:515:1: ( ruleViewAction EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:516:1: ruleViewAction EOF
            {
             before(grammarAccess.getViewActionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleViewAction_in_entryRuleViewAction1027);
            ruleViewAction();

            state._fsp--;

             after(grammarAccess.getViewActionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleViewAction1034); 

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
    // $ANTLR end "entryRuleViewAction"


    // $ANTLR start "ruleViewAction"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:523:1: ruleViewAction : ( ( rule__ViewAction__Alternatives ) ) ;
    public final void ruleViewAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:527:2: ( ( ( rule__ViewAction__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:528:1: ( ( rule__ViewAction__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:528:1: ( ( rule__ViewAction__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:529:1: ( rule__ViewAction__Alternatives )
            {
             before(grammarAccess.getViewActionAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:530:1: ( rule__ViewAction__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:530:2: rule__ViewAction__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ViewAction__Alternatives_in_ruleViewAction1060);
            rule__ViewAction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getViewActionAccess().getAlternatives()); 

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
    // $ANTLR end "ruleViewAction"


    // $ANTLR start "entryRuleSelectorName"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:542:1: entryRuleSelectorName : ruleSelectorName EOF ;
    public final void entryRuleSelectorName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:543:1: ( ruleSelectorName EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:544:1: ruleSelectorName EOF
            {
             before(grammarAccess.getSelectorNameRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectorName_in_entryRuleSelectorName1087);
            ruleSelectorName();

            state._fsp--;

             after(grammarAccess.getSelectorNameRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectorName1094); 

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
    // $ANTLR end "entryRuleSelectorName"


    // $ANTLR start "ruleSelectorName"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:551:1: ruleSelectorName : ( ( rule__SelectorName__Group__0 ) ) ;
    public final void ruleSelectorName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:555:2: ( ( ( rule__SelectorName__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:556:1: ( ( rule__SelectorName__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:556:1: ( ( rule__SelectorName__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:557:1: ( rule__SelectorName__Group__0 )
            {
             before(grammarAccess.getSelectorNameAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:558:1: ( rule__SelectorName__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:558:2: rule__SelectorName__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group__0_in_ruleSelectorName1120);
            rule__SelectorName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectorNameAccess().getGroup()); 

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
    // $ANTLR end "ruleSelectorName"


    // $ANTLR start "entryRuleSelector"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:570:1: entryRuleSelector : ruleSelector EOF ;
    public final void entryRuleSelector() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:571:1: ( ruleSelector EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:572:1: ruleSelector EOF
            {
             before(grammarAccess.getSelectorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelector_in_entryRuleSelector1147);
            ruleSelector();

            state._fsp--;

             after(grammarAccess.getSelectorRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelector1154); 

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
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:579:1: ruleSelector : ( ( rule__Selector__Group__0 ) ) ;
    public final void ruleSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:583:2: ( ( ( rule__Selector__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:584:1: ( ( rule__Selector__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:584:1: ( ( rule__Selector__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:585:1: ( rule__Selector__Group__0 )
            {
             before(grammarAccess.getSelectorAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:586:1: ( rule__Selector__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:586:2: rule__Selector__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__0_in_ruleSelector1180);
            rule__Selector__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelectorAccess().getGroup()); 

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
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleExternalOpen"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:598:1: entryRuleExternalOpen : ruleExternalOpen EOF ;
    public final void entryRuleExternalOpen() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:599:1: ( ruleExternalOpen EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:600:1: ruleExternalOpen EOF
            {
             before(grammarAccess.getExternalOpenRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExternalOpen_in_entryRuleExternalOpen1207);
            ruleExternalOpen();

            state._fsp--;

             after(grammarAccess.getExternalOpenRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExternalOpen1214); 

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
    // $ANTLR end "entryRuleExternalOpen"


    // $ANTLR start "ruleExternalOpen"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:607:1: ruleExternalOpen : ( ( rule__ExternalOpen__UrlAssignment ) ) ;
    public final void ruleExternalOpen() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:611:2: ( ( ( rule__ExternalOpen__UrlAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:612:1: ( ( rule__ExternalOpen__UrlAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:612:1: ( ( rule__ExternalOpen__UrlAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:613:1: ( rule__ExternalOpen__UrlAssignment )
            {
             before(grammarAccess.getExternalOpenAccess().getUrlAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:614:1: ( rule__ExternalOpen__UrlAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:614:2: rule__ExternalOpen__UrlAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExternalOpen__UrlAssignment_in_ruleExternalOpen1240);
            rule__ExternalOpen__UrlAssignment();

            state._fsp--;


            }

             after(grammarAccess.getExternalOpenAccess().getUrlAssignment()); 

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
    // $ANTLR end "ruleExternalOpen"


    // $ANTLR start "ruleTableViewStyle"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:627:1: ruleTableViewStyle : ( ( rule__TableViewStyle__Alternatives ) ) ;
    public final void ruleTableViewStyle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:631:1: ( ( ( rule__TableViewStyle__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:632:1: ( ( rule__TableViewStyle__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:632:1: ( ( rule__TableViewStyle__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:633:1: ( rule__TableViewStyle__Alternatives )
            {
             before(grammarAccess.getTableViewStyleAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:634:1: ( rule__TableViewStyle__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:634:2: rule__TableViewStyle__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableViewStyle__Alternatives_in_ruleTableViewStyle1277);
            rule__TableViewStyle__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTableViewStyleAccess().getAlternatives()); 

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
    // $ANTLR end "ruleTableViewStyle"


    // $ANTLR start "ruleCellType"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:646:1: ruleCellType : ( ( rule__CellType__Alternatives ) ) ;
    public final void ruleCellType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:650:1: ( ( ( rule__CellType__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:651:1: ( ( rule__CellType__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:651:1: ( ( rule__CellType__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:652:1: ( rule__CellType__Alternatives )
            {
             before(grammarAccess.getCellTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:653:1: ( rule__CellType__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:653:2: rule__CellType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CellType__Alternatives_in_ruleCellType1313);
            rule__CellType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCellTypeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleCellType"


    // $ANTLR start "ruleCellAccessory"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:665:1: ruleCellAccessory : ( ( rule__CellAccessory__Alternatives ) ) ;
    public final void ruleCellAccessory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:669:1: ( ( ( rule__CellAccessory__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:670:1: ( ( rule__CellAccessory__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:670:1: ( ( rule__CellAccessory__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:671:1: ( rule__CellAccessory__Alternatives )
            {
             before(grammarAccess.getCellAccessoryAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:672:1: ( rule__CellAccessory__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:672:2: rule__CellAccessory__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__CellAccessory__Alternatives_in_ruleCellAccessory1349);
            rule__CellAccessory__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCellAccessoryAccess().getAlternatives()); 

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
    // $ANTLR end "ruleCellAccessory"


    // $ANTLR start "rule__ScalarExpression__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:685:1: rule__ScalarExpression__Alternatives : ( ( ruleStringLiteral ) | ( ruleStringFunction ) | ( ruleObjectReference ) );
    public final void rule__ScalarExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:689:1: ( ( ruleStringLiteral ) | ( ruleStringFunction ) | ( ruleObjectReference ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt2=1;
                }
                break;
            case 22:
            case 24:
            case 26:
                {
                alt2=2;
                }
                break;
            case RULE_ID:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:690:1: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:690:1: ( ruleStringLiteral )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:691:1: ruleStringLiteral
                    {
                     before(grammarAccess.getScalarExpressionAccess().getStringLiteralParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_rule__ScalarExpression__Alternatives1386);
                    ruleStringLiteral();

                    state._fsp--;

                     after(grammarAccess.getScalarExpressionAccess().getStringLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:696:6: ( ruleStringFunction )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:696:6: ( ruleStringFunction )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:697:1: ruleStringFunction
                    {
                     before(grammarAccess.getScalarExpressionAccess().getStringFunctionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleStringFunction_in_rule__ScalarExpression__Alternatives1403);
                    ruleStringFunction();

                    state._fsp--;

                     after(grammarAccess.getScalarExpressionAccess().getStringFunctionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:702:6: ( ruleObjectReference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:702:6: ( ruleObjectReference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:703:1: ruleObjectReference
                    {
                     before(grammarAccess.getScalarExpressionAccess().getObjectReferenceParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleObjectReference_in_rule__ScalarExpression__Alternatives1420);
                    ruleObjectReference();

                    state._fsp--;

                     after(grammarAccess.getScalarExpressionAccess().getObjectReferenceParserRuleCall_2()); 

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
    // $ANTLR end "rule__ScalarExpression__Alternatives"


    // $ANTLR start "rule__CollectionExpression__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:713:1: rule__CollectionExpression__Alternatives : ( ( ruleCollectionLiteral ) | ( ruleCollectionFunction ) | ( ruleObjectReference ) );
    public final void rule__CollectionExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:717:1: ( ( ruleCollectionLiteral ) | ( ruleCollectionFunction ) | ( ruleObjectReference ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt3=1;
                }
                break;
            case 29:
                {
                alt3=2;
                }
                break;
            case RULE_ID:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:718:1: ( ruleCollectionLiteral )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:718:1: ( ruleCollectionLiteral )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:719:1: ruleCollectionLiteral
                    {
                     before(grammarAccess.getCollectionExpressionAccess().getCollectionLiteralParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteral_in_rule__CollectionExpression__Alternatives1452);
                    ruleCollectionLiteral();

                    state._fsp--;

                     after(grammarAccess.getCollectionExpressionAccess().getCollectionLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:724:6: ( ruleCollectionFunction )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:724:6: ( ruleCollectionFunction )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:725:1: ruleCollectionFunction
                    {
                     before(grammarAccess.getCollectionExpressionAccess().getCollectionFunctionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionFunction_in_rule__CollectionExpression__Alternatives1469);
                    ruleCollectionFunction();

                    state._fsp--;

                     after(grammarAccess.getCollectionExpressionAccess().getCollectionFunctionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:730:6: ( ruleObjectReference )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:730:6: ( ruleObjectReference )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:731:1: ruleObjectReference
                    {
                     before(grammarAccess.getCollectionExpressionAccess().getObjectReferenceParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleObjectReference_in_rule__CollectionExpression__Alternatives1486);
                    ruleObjectReference();

                    state._fsp--;

                     after(grammarAccess.getCollectionExpressionAccess().getObjectReferenceParserRuleCall_2()); 

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
    // $ANTLR end "rule__CollectionExpression__Alternatives"


    // $ANTLR start "rule__StringFunction__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:741:1: rule__StringFunction__Alternatives : ( ( ( rule__StringFunction__Group_0__0 ) ) | ( ( rule__StringFunction__Group_1__0 ) ) | ( ( rule__StringFunction__Group_2__0 ) ) );
    public final void rule__StringFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:745:1: ( ( ( rule__StringFunction__Group_0__0 ) ) | ( ( rule__StringFunction__Group_1__0 ) ) | ( ( rule__StringFunction__Group_2__0 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt4=1;
                }
                break;
            case 24:
                {
                alt4=2;
                }
                break;
            case 26:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:746:1: ( ( rule__StringFunction__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:746:1: ( ( rule__StringFunction__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:747:1: ( rule__StringFunction__Group_0__0 )
                    {
                     before(grammarAccess.getStringFunctionAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:748:1: ( rule__StringFunction__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:748:2: rule__StringFunction__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__0_in_rule__StringFunction__Alternatives1518);
                    rule__StringFunction__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStringFunctionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:752:6: ( ( rule__StringFunction__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:752:6: ( ( rule__StringFunction__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:753:1: ( rule__StringFunction__Group_1__0 )
                    {
                     before(grammarAccess.getStringFunctionAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:754:1: ( rule__StringFunction__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:754:2: rule__StringFunction__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__0_in_rule__StringFunction__Alternatives1536);
                    rule__StringFunction__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStringFunctionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:758:6: ( ( rule__StringFunction__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:758:6: ( ( rule__StringFunction__Group_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:759:1: ( rule__StringFunction__Group_2__0 )
                    {
                     before(grammarAccess.getStringFunctionAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:760:1: ( rule__StringFunction__Group_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:760:2: rule__StringFunction__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__0_in_rule__StringFunction__Alternatives1554);
                    rule__StringFunction__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStringFunctionAccess().getGroup_2()); 

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
    // $ANTLR end "rule__StringFunction__Alternatives"


    // $ANTLR start "rule__ViewAction__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:770:1: rule__ViewAction__Alternatives : ( ( ruleExternalOpen ) | ( ruleSelector ) );
    public final void rule__ViewAction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:774:1: ( ( ruleExternalOpen ) | ( ruleSelector ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_STRING)||LA5_0==22||LA5_0==24||LA5_0==26) ) {
                alt5=1;
            }
            else if ( (LA5_0==46) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:775:1: ( ruleExternalOpen )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:775:1: ( ruleExternalOpen )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:776:1: ruleExternalOpen
                    {
                     before(grammarAccess.getViewActionAccess().getExternalOpenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleExternalOpen_in_rule__ViewAction__Alternatives1588);
                    ruleExternalOpen();

                    state._fsp--;

                     after(grammarAccess.getViewActionAccess().getExternalOpenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:781:6: ( ruleSelector )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:781:6: ( ruleSelector )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:782:1: ruleSelector
                    {
                     before(grammarAccess.getViewActionAccess().getSelectorParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSelector_in_rule__ViewAction__Alternatives1605);
                    ruleSelector();

                    state._fsp--;

                     after(grammarAccess.getViewActionAccess().getSelectorParserRuleCall_1()); 

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
    // $ANTLR end "rule__ViewAction__Alternatives"


    // $ANTLR start "rule__TableViewStyle__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:792:1: rule__TableViewStyle__Alternatives : ( ( ( 'Plain' ) ) | ( ( 'Grouped' ) ) );
    public final void rule__TableViewStyle__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:796:1: ( ( ( 'Plain' ) ) | ( ( 'Grouped' ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            else if ( (LA6_0==12) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:797:1: ( ( 'Plain' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:797:1: ( ( 'Plain' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:798:1: ( 'Plain' )
                    {
                     before(grammarAccess.getTableViewStyleAccess().getPlainEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:799:1: ( 'Plain' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:799:3: 'Plain'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__TableViewStyle__Alternatives1638); 

                    }

                     after(grammarAccess.getTableViewStyleAccess().getPlainEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:804:6: ( ( 'Grouped' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:804:6: ( ( 'Grouped' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:805:1: ( 'Grouped' )
                    {
                     before(grammarAccess.getTableViewStyleAccess().getGroupedEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:806:1: ( 'Grouped' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:806:3: 'Grouped'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__TableViewStyle__Alternatives1659); 

                    }

                     after(grammarAccess.getTableViewStyleAccess().getGroupedEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__TableViewStyle__Alternatives"


    // $ANTLR start "rule__CellType__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:816:1: rule__CellType__Alternatives : ( ( ( 'Default' ) ) | ( ( 'Value1' ) ) | ( ( 'Value2' ) ) | ( ( 'Subtitle' ) ) );
    public final void rule__CellType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:820:1: ( ( ( 'Default' ) ) | ( ( 'Value1' ) ) | ( ( 'Value2' ) ) | ( ( 'Subtitle' ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt7=1;
                }
                break;
            case 14:
                {
                alt7=2;
                }
                break;
            case 15:
                {
                alt7=3;
                }
                break;
            case 16:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:821:1: ( ( 'Default' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:821:1: ( ( 'Default' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:822:1: ( 'Default' )
                    {
                     before(grammarAccess.getCellTypeAccess().getDefaultEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:823:1: ( 'Default' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:823:3: 'Default'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__CellType__Alternatives1695); 

                    }

                     after(grammarAccess.getCellTypeAccess().getDefaultEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:828:6: ( ( 'Value1' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:828:6: ( ( 'Value1' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:829:1: ( 'Value1' )
                    {
                     before(grammarAccess.getCellTypeAccess().getValue1EnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:830:1: ( 'Value1' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:830:3: 'Value1'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__CellType__Alternatives1716); 

                    }

                     after(grammarAccess.getCellTypeAccess().getValue1EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:835:6: ( ( 'Value2' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:835:6: ( ( 'Value2' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:836:1: ( 'Value2' )
                    {
                     before(grammarAccess.getCellTypeAccess().getValue2EnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:837:1: ( 'Value2' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:837:3: 'Value2'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__CellType__Alternatives1737); 

                    }

                     after(grammarAccess.getCellTypeAccess().getValue2EnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:842:6: ( ( 'Subtitle' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:842:6: ( ( 'Subtitle' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:843:1: ( 'Subtitle' )
                    {
                     before(grammarAccess.getCellTypeAccess().getSubtitleEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:844:1: ( 'Subtitle' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:844:3: 'Subtitle'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__CellType__Alternatives1758); 

                    }

                     after(grammarAccess.getCellTypeAccess().getSubtitleEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__CellType__Alternatives"


    // $ANTLR start "rule__CellAccessory__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:854:1: rule__CellAccessory__Alternatives : ( ( ( 'None' ) ) | ( ( 'Link' ) ) | ( ( 'Detail' ) ) | ( ( 'Check' ) ) );
    public final void rule__CellAccessory__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:858:1: ( ( ( 'None' ) ) | ( ( 'Link' ) ) | ( ( 'Detail' ) ) | ( ( 'Check' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case 19:
                {
                alt8=3;
                }
                break;
            case 20:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:859:1: ( ( 'None' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:859:1: ( ( 'None' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:860:1: ( 'None' )
                    {
                     before(grammarAccess.getCellAccessoryAccess().getNoneEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:861:1: ( 'None' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:861:3: 'None'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__CellAccessory__Alternatives1794); 

                    }

                     after(grammarAccess.getCellAccessoryAccess().getNoneEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:866:6: ( ( 'Link' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:866:6: ( ( 'Link' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:867:1: ( 'Link' )
                    {
                     before(grammarAccess.getCellAccessoryAccess().getLinkEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:868:1: ( 'Link' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:868:3: 'Link'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__CellAccessory__Alternatives1815); 

                    }

                     after(grammarAccess.getCellAccessoryAccess().getLinkEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:873:6: ( ( 'Detail' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:873:6: ( ( 'Detail' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:874:1: ( 'Detail' )
                    {
                     before(grammarAccess.getCellAccessoryAccess().getDetailEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:875:1: ( 'Detail' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:875:3: 'Detail'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__CellAccessory__Alternatives1836); 

                    }

                     after(grammarAccess.getCellAccessoryAccess().getDetailEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:880:6: ( ( 'Check' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:880:6: ( ( 'Check' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:881:1: ( 'Check' )
                    {
                     before(grammarAccess.getCellAccessoryAccess().getCheckEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:882:1: ( 'Check' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:882:3: 'Check'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__CellAccessory__Alternatives1857); 

                    }

                     after(grammarAccess.getCellAccessoryAccess().getCheckEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__CellAccessory__Alternatives"


    // $ANTLR start "rule__TypeDescription__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:894:1: rule__TypeDescription__Group__0 : rule__TypeDescription__Group__0__Impl rule__TypeDescription__Group__1 ;
    public final void rule__TypeDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:898:1: ( rule__TypeDescription__Group__0__Impl rule__TypeDescription__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:899:2: rule__TypeDescription__Group__0__Impl rule__TypeDescription__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeDescription__Group__0__Impl_in_rule__TypeDescription__Group__01890);
            rule__TypeDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TypeDescription__Group__1_in_rule__TypeDescription__Group__01893);
            rule__TypeDescription__Group__1();

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
    // $ANTLR end "rule__TypeDescription__Group__0"


    // $ANTLR start "rule__TypeDescription__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:906:1: rule__TypeDescription__Group__0__Impl : ( ( rule__TypeDescription__TypeAssignment_0 ) ) ;
    public final void rule__TypeDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:910:1: ( ( ( rule__TypeDescription__TypeAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:911:1: ( ( rule__TypeDescription__TypeAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:911:1: ( ( rule__TypeDescription__TypeAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:912:1: ( rule__TypeDescription__TypeAssignment_0 )
            {
             before(grammarAccess.getTypeDescriptionAccess().getTypeAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:913:1: ( rule__TypeDescription__TypeAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:913:2: rule__TypeDescription__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeDescription__TypeAssignment_0_in_rule__TypeDescription__Group__0__Impl1920);
            rule__TypeDescription__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeDescriptionAccess().getTypeAssignment_0()); 

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
    // $ANTLR end "rule__TypeDescription__Group__0__Impl"


    // $ANTLR start "rule__TypeDescription__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:923:1: rule__TypeDescription__Group__1 : rule__TypeDescription__Group__1__Impl ;
    public final void rule__TypeDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:927:1: ( rule__TypeDescription__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:928:2: rule__TypeDescription__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TypeDescription__Group__1__Impl_in_rule__TypeDescription__Group__11950);
            rule__TypeDescription__Group__1__Impl();

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
    // $ANTLR end "rule__TypeDescription__Group__1"


    // $ANTLR start "rule__TypeDescription__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:934:1: rule__TypeDescription__Group__1__Impl : ( ( rule__TypeDescription__ManyAssignment_1 )? ) ;
    public final void rule__TypeDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:938:1: ( ( ( rule__TypeDescription__ManyAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:939:1: ( ( rule__TypeDescription__ManyAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:939:1: ( ( rule__TypeDescription__ManyAssignment_1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:940:1: ( rule__TypeDescription__ManyAssignment_1 )?
            {
             before(grammarAccess.getTypeDescriptionAccess().getManyAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:941:1: ( rule__TypeDescription__ManyAssignment_1 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==47) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:941:2: rule__TypeDescription__ManyAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TypeDescription__ManyAssignment_1_in_rule__TypeDescription__Group__1__Impl1977);
                    rule__TypeDescription__ManyAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeDescriptionAccess().getManyAssignment_1()); 

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
    // $ANTLR end "rule__TypeDescription__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:955:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:959:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:960:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__02012);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__02015);
            rule__Parameter__Group__1();

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
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:967:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__DescriptionAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:971:1: ( ( ( rule__Parameter__DescriptionAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:972:1: ( ( rule__Parameter__DescriptionAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:972:1: ( ( rule__Parameter__DescriptionAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:973:1: ( rule__Parameter__DescriptionAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getDescriptionAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:974:1: ( rule__Parameter__DescriptionAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:974:2: rule__Parameter__DescriptionAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__DescriptionAssignment_0_in_rule__Parameter__Group__0__Impl2042);
            rule__Parameter__DescriptionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getDescriptionAssignment_0()); 

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
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:984:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:988:1: ( rule__Parameter__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:989:2: rule__Parameter__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__12072);
            rule__Parameter__Group__1__Impl();

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
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:995:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__NameAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:999:1: ( ( ( rule__Parameter__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1000:1: ( ( rule__Parameter__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1000:1: ( ( rule__Parameter__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1001:1: ( rule__Parameter__NameAssignment_1 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1002:1: ( rule__Parameter__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1002:2: rule__Parameter__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Parameter__NameAssignment_1_in_rule__Parameter__Group__1__Impl2099);
            rule__Parameter__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__ObjectReference__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1016:1: rule__ObjectReference__Group__0 : rule__ObjectReference__Group__0__Impl rule__ObjectReference__Group__1 ;
    public final void rule__ObjectReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1020:1: ( rule__ObjectReference__Group__0__Impl rule__ObjectReference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1021:2: rule__ObjectReference__Group__0__Impl rule__ObjectReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectReference__Group__0__Impl_in_rule__ObjectReference__Group__02133);
            rule__ObjectReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ObjectReference__Group__1_in_rule__ObjectReference__Group__02136);
            rule__ObjectReference__Group__1();

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
    // $ANTLR end "rule__ObjectReference__Group__0"


    // $ANTLR start "rule__ObjectReference__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1028:1: rule__ObjectReference__Group__0__Impl : ( ( rule__ObjectReference__ObjectAssignment_0 ) ) ;
    public final void rule__ObjectReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1032:1: ( ( ( rule__ObjectReference__ObjectAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1033:1: ( ( rule__ObjectReference__ObjectAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1033:1: ( ( rule__ObjectReference__ObjectAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1034:1: ( rule__ObjectReference__ObjectAssignment_0 )
            {
             before(grammarAccess.getObjectReferenceAccess().getObjectAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1035:1: ( rule__ObjectReference__ObjectAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1035:2: rule__ObjectReference__ObjectAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectReference__ObjectAssignment_0_in_rule__ObjectReference__Group__0__Impl2163);
            rule__ObjectReference__ObjectAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getObjectReferenceAccess().getObjectAssignment_0()); 

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
    // $ANTLR end "rule__ObjectReference__Group__0__Impl"


    // $ANTLR start "rule__ObjectReference__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1045:1: rule__ObjectReference__Group__1 : rule__ObjectReference__Group__1__Impl ;
    public final void rule__ObjectReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1049:1: ( rule__ObjectReference__Group__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1050:2: rule__ObjectReference__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ObjectReference__Group__1__Impl_in_rule__ObjectReference__Group__12193);
            rule__ObjectReference__Group__1__Impl();

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
    // $ANTLR end "rule__ObjectReference__Group__1"


    // $ANTLR start "rule__ObjectReference__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1056:1: rule__ObjectReference__Group__1__Impl : ( ( rule__ObjectReference__TailAssignment_1 )? ) ;
    public final void rule__ObjectReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1060:1: ( ( ( rule__ObjectReference__TailAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1061:1: ( ( rule__ObjectReference__TailAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1061:1: ( ( rule__ObjectReference__TailAssignment_1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1062:1: ( rule__ObjectReference__TailAssignment_1 )?
            {
             before(grammarAccess.getObjectReferenceAccess().getTailAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1063:1: ( rule__ObjectReference__TailAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1063:2: rule__ObjectReference__TailAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ObjectReference__TailAssignment_1_in_rule__ObjectReference__Group__1__Impl2220);
                    rule__ObjectReference__TailAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectReferenceAccess().getTailAssignment_1()); 

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
    // $ANTLR end "rule__ObjectReference__Group__1__Impl"


    // $ANTLR start "rule__NestedObjectReference__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1077:1: rule__NestedObjectReference__Group__0 : rule__NestedObjectReference__Group__0__Impl rule__NestedObjectReference__Group__1 ;
    public final void rule__NestedObjectReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1081:1: ( rule__NestedObjectReference__Group__0__Impl rule__NestedObjectReference__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1082:2: rule__NestedObjectReference__Group__0__Impl rule__NestedObjectReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__Group__0__Impl_in_rule__NestedObjectReference__Group__02255);
            rule__NestedObjectReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__Group__1_in_rule__NestedObjectReference__Group__02258);
            rule__NestedObjectReference__Group__1();

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
    // $ANTLR end "rule__NestedObjectReference__Group__0"


    // $ANTLR start "rule__NestedObjectReference__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1089:1: rule__NestedObjectReference__Group__0__Impl : ( '.' ) ;
    public final void rule__NestedObjectReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1093:1: ( ( '.' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1094:1: ( '.' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1094:1: ( '.' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1095:1: '.'
            {
             before(grammarAccess.getNestedObjectReferenceAccess().getFullStopKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__NestedObjectReference__Group__0__Impl2286); 
             after(grammarAccess.getNestedObjectReferenceAccess().getFullStopKeyword_0()); 

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
    // $ANTLR end "rule__NestedObjectReference__Group__0__Impl"


    // $ANTLR start "rule__NestedObjectReference__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1108:1: rule__NestedObjectReference__Group__1 : rule__NestedObjectReference__Group__1__Impl rule__NestedObjectReference__Group__2 ;
    public final void rule__NestedObjectReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1112:1: ( rule__NestedObjectReference__Group__1__Impl rule__NestedObjectReference__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1113:2: rule__NestedObjectReference__Group__1__Impl rule__NestedObjectReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__Group__1__Impl_in_rule__NestedObjectReference__Group__12317);
            rule__NestedObjectReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__Group__2_in_rule__NestedObjectReference__Group__12320);
            rule__NestedObjectReference__Group__2();

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
    // $ANTLR end "rule__NestedObjectReference__Group__1"


    // $ANTLR start "rule__NestedObjectReference__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1120:1: rule__NestedObjectReference__Group__1__Impl : ( ( rule__NestedObjectReference__ObjectAssignment_1 ) ) ;
    public final void rule__NestedObjectReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1124:1: ( ( ( rule__NestedObjectReference__ObjectAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1125:1: ( ( rule__NestedObjectReference__ObjectAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1125:1: ( ( rule__NestedObjectReference__ObjectAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1126:1: ( rule__NestedObjectReference__ObjectAssignment_1 )
            {
             before(grammarAccess.getNestedObjectReferenceAccess().getObjectAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1127:1: ( rule__NestedObjectReference__ObjectAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1127:2: rule__NestedObjectReference__ObjectAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__ObjectAssignment_1_in_rule__NestedObjectReference__Group__1__Impl2347);
            rule__NestedObjectReference__ObjectAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNestedObjectReferenceAccess().getObjectAssignment_1()); 

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
    // $ANTLR end "rule__NestedObjectReference__Group__1__Impl"


    // $ANTLR start "rule__NestedObjectReference__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1137:1: rule__NestedObjectReference__Group__2 : rule__NestedObjectReference__Group__2__Impl ;
    public final void rule__NestedObjectReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1141:1: ( rule__NestedObjectReference__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1142:2: rule__NestedObjectReference__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__Group__2__Impl_in_rule__NestedObjectReference__Group__22377);
            rule__NestedObjectReference__Group__2__Impl();

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
    // $ANTLR end "rule__NestedObjectReference__Group__2"


    // $ANTLR start "rule__NestedObjectReference__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1148:1: rule__NestedObjectReference__Group__2__Impl : ( ( rule__NestedObjectReference__TailAssignment_2 )? ) ;
    public final void rule__NestedObjectReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1152:1: ( ( ( rule__NestedObjectReference__TailAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1153:1: ( ( rule__NestedObjectReference__TailAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1153:1: ( ( rule__NestedObjectReference__TailAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1154:1: ( rule__NestedObjectReference__TailAssignment_2 )?
            {
             before(grammarAccess.getNestedObjectReferenceAccess().getTailAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1155:1: ( rule__NestedObjectReference__TailAssignment_2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1155:2: rule__NestedObjectReference__TailAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__NestedObjectReference__TailAssignment_2_in_rule__NestedObjectReference__Group__2__Impl2404);
                    rule__NestedObjectReference__TailAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNestedObjectReferenceAccess().getTailAssignment_2()); 

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
    // $ANTLR end "rule__NestedObjectReference__Group__2__Impl"


    // $ANTLR start "rule__StringFunction__Group_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1171:1: rule__StringFunction__Group_0__0 : rule__StringFunction__Group_0__0__Impl rule__StringFunction__Group_0__1 ;
    public final void rule__StringFunction__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1175:1: ( rule__StringFunction__Group_0__0__Impl rule__StringFunction__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1176:2: rule__StringFunction__Group_0__0__Impl rule__StringFunction__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__0__Impl_in_rule__StringFunction__Group_0__02441);
            rule__StringFunction__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__1_in_rule__StringFunction__Group_0__02444);
            rule__StringFunction__Group_0__1();

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
    // $ANTLR end "rule__StringFunction__Group_0__0"


    // $ANTLR start "rule__StringFunction__Group_0__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1183:1: rule__StringFunction__Group_0__0__Impl : ( () ) ;
    public final void rule__StringFunction__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1187:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1188:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1188:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1189:1: ()
            {
             before(grammarAccess.getStringFunctionAccess().getStringConcatAction_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1190:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1192:1: 
            {
            }

             after(grammarAccess.getStringFunctionAccess().getStringConcatAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringFunction__Group_0__0__Impl"


    // $ANTLR start "rule__StringFunction__Group_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1202:1: rule__StringFunction__Group_0__1 : rule__StringFunction__Group_0__1__Impl rule__StringFunction__Group_0__2 ;
    public final void rule__StringFunction__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1206:1: ( rule__StringFunction__Group_0__1__Impl rule__StringFunction__Group_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1207:2: rule__StringFunction__Group_0__1__Impl rule__StringFunction__Group_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__1__Impl_in_rule__StringFunction__Group_0__12502);
            rule__StringFunction__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__2_in_rule__StringFunction__Group_0__12505);
            rule__StringFunction__Group_0__2();

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
    // $ANTLR end "rule__StringFunction__Group_0__1"


    // $ANTLR start "rule__StringFunction__Group_0__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1214:1: rule__StringFunction__Group_0__1__Impl : ( '(' ) ;
    public final void rule__StringFunction__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1218:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1219:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1219:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1220:1: '('
            {
             before(grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_0_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__StringFunction__Group_0__1__Impl2533); 
             after(grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_0_1()); 

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
    // $ANTLR end "rule__StringFunction__Group_0__1__Impl"


    // $ANTLR start "rule__StringFunction__Group_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1233:1: rule__StringFunction__Group_0__2 : rule__StringFunction__Group_0__2__Impl rule__StringFunction__Group_0__3 ;
    public final void rule__StringFunction__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1237:1: ( rule__StringFunction__Group_0__2__Impl rule__StringFunction__Group_0__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1238:2: rule__StringFunction__Group_0__2__Impl rule__StringFunction__Group_0__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__2__Impl_in_rule__StringFunction__Group_0__22564);
            rule__StringFunction__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__3_in_rule__StringFunction__Group_0__22567);
            rule__StringFunction__Group_0__3();

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
    // $ANTLR end "rule__StringFunction__Group_0__2"


    // $ANTLR start "rule__StringFunction__Group_0__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1245:1: rule__StringFunction__Group_0__2__Impl : ( ( ( rule__StringFunction__ValuesAssignment_0_2 ) ) ( ( rule__StringFunction__ValuesAssignment_0_2 )* ) ) ;
    public final void rule__StringFunction__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1249:1: ( ( ( ( rule__StringFunction__ValuesAssignment_0_2 ) ) ( ( rule__StringFunction__ValuesAssignment_0_2 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1250:1: ( ( ( rule__StringFunction__ValuesAssignment_0_2 ) ) ( ( rule__StringFunction__ValuesAssignment_0_2 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1250:1: ( ( ( rule__StringFunction__ValuesAssignment_0_2 ) ) ( ( rule__StringFunction__ValuesAssignment_0_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1251:1: ( ( rule__StringFunction__ValuesAssignment_0_2 ) ) ( ( rule__StringFunction__ValuesAssignment_0_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1251:1: ( ( rule__StringFunction__ValuesAssignment_0_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1252:1: ( rule__StringFunction__ValuesAssignment_0_2 )
            {
             before(grammarAccess.getStringFunctionAccess().getValuesAssignment_0_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1253:1: ( rule__StringFunction__ValuesAssignment_0_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1253:2: rule__StringFunction__ValuesAssignment_0_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__ValuesAssignment_0_2_in_rule__StringFunction__Group_0__2__Impl2596);
            rule__StringFunction__ValuesAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getStringFunctionAccess().getValuesAssignment_0_2()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1256:1: ( ( rule__StringFunction__ValuesAssignment_0_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1257:1: ( rule__StringFunction__ValuesAssignment_0_2 )*
            {
             before(grammarAccess.getStringFunctionAccess().getValuesAssignment_0_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1258:1: ( rule__StringFunction__ValuesAssignment_0_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_STRING)||LA12_0==22||LA12_0==24||LA12_0==26) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1258:2: rule__StringFunction__ValuesAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__StringFunction__ValuesAssignment_0_2_in_rule__StringFunction__Group_0__2__Impl2608);
            	    rule__StringFunction__ValuesAssignment_0_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getStringFunctionAccess().getValuesAssignment_0_2()); 

            }


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
    // $ANTLR end "rule__StringFunction__Group_0__2__Impl"


    // $ANTLR start "rule__StringFunction__Group_0__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1269:1: rule__StringFunction__Group_0__3 : rule__StringFunction__Group_0__3__Impl ;
    public final void rule__StringFunction__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1273:1: ( rule__StringFunction__Group_0__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1274:2: rule__StringFunction__Group_0__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_0__3__Impl_in_rule__StringFunction__Group_0__32641);
            rule__StringFunction__Group_0__3__Impl();

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
    // $ANTLR end "rule__StringFunction__Group_0__3"


    // $ANTLR start "rule__StringFunction__Group_0__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1280:1: rule__StringFunction__Group_0__3__Impl : ( ')' ) ;
    public final void rule__StringFunction__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1284:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1285:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1285:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1286:1: ')'
            {
             before(grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_0_3()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__StringFunction__Group_0__3__Impl2669); 
             after(grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_0_3()); 

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
    // $ANTLR end "rule__StringFunction__Group_0__3__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1307:1: rule__StringFunction__Group_1__0 : rule__StringFunction__Group_1__0__Impl rule__StringFunction__Group_1__1 ;
    public final void rule__StringFunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1311:1: ( rule__StringFunction__Group_1__0__Impl rule__StringFunction__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1312:2: rule__StringFunction__Group_1__0__Impl rule__StringFunction__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__0__Impl_in_rule__StringFunction__Group_1__02708);
            rule__StringFunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__1_in_rule__StringFunction__Group_1__02711);
            rule__StringFunction__Group_1__1();

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
    // $ANTLR end "rule__StringFunction__Group_1__0"


    // $ANTLR start "rule__StringFunction__Group_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1319:1: rule__StringFunction__Group_1__0__Impl : ( () ) ;
    public final void rule__StringFunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1323:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1324:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1324:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1325:1: ()
            {
             before(grammarAccess.getStringFunctionAccess().getStringReplaceAction_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1326:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1328:1: 
            {
            }

             after(grammarAccess.getStringFunctionAccess().getStringReplaceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringFunction__Group_1__0__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1338:1: rule__StringFunction__Group_1__1 : rule__StringFunction__Group_1__1__Impl rule__StringFunction__Group_1__2 ;
    public final void rule__StringFunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1342:1: ( rule__StringFunction__Group_1__1__Impl rule__StringFunction__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1343:2: rule__StringFunction__Group_1__1__Impl rule__StringFunction__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__1__Impl_in_rule__StringFunction__Group_1__12769);
            rule__StringFunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__2_in_rule__StringFunction__Group_1__12772);
            rule__StringFunction__Group_1__2();

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
    // $ANTLR end "rule__StringFunction__Group_1__1"


    // $ANTLR start "rule__StringFunction__Group_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1350:1: rule__StringFunction__Group_1__1__Impl : ( 'replace(' ) ;
    public final void rule__StringFunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1354:1: ( ( 'replace(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1355:1: ( 'replace(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1355:1: ( 'replace(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1356:1: 'replace('
            {
             before(grammarAccess.getStringFunctionAccess().getReplaceKeyword_1_1()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__StringFunction__Group_1__1__Impl2800); 
             after(grammarAccess.getStringFunctionAccess().getReplaceKeyword_1_1()); 

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
    // $ANTLR end "rule__StringFunction__Group_1__1__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1369:1: rule__StringFunction__Group_1__2 : rule__StringFunction__Group_1__2__Impl rule__StringFunction__Group_1__3 ;
    public final void rule__StringFunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1373:1: ( rule__StringFunction__Group_1__2__Impl rule__StringFunction__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1374:2: rule__StringFunction__Group_1__2__Impl rule__StringFunction__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__2__Impl_in_rule__StringFunction__Group_1__22831);
            rule__StringFunction__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__3_in_rule__StringFunction__Group_1__22834);
            rule__StringFunction__Group_1__3();

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
    // $ANTLR end "rule__StringFunction__Group_1__2"


    // $ANTLR start "rule__StringFunction__Group_1__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1381:1: rule__StringFunction__Group_1__2__Impl : ( ( rule__StringFunction__ValueAssignment_1_2 ) ) ;
    public final void rule__StringFunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1385:1: ( ( ( rule__StringFunction__ValueAssignment_1_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1386:1: ( ( rule__StringFunction__ValueAssignment_1_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1386:1: ( ( rule__StringFunction__ValueAssignment_1_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1387:1: ( rule__StringFunction__ValueAssignment_1_2 )
            {
             before(grammarAccess.getStringFunctionAccess().getValueAssignment_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1388:1: ( rule__StringFunction__ValueAssignment_1_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1388:2: rule__StringFunction__ValueAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__ValueAssignment_1_2_in_rule__StringFunction__Group_1__2__Impl2861);
            rule__StringFunction__ValueAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getStringFunctionAccess().getValueAssignment_1_2()); 

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
    // $ANTLR end "rule__StringFunction__Group_1__2__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1398:1: rule__StringFunction__Group_1__3 : rule__StringFunction__Group_1__3__Impl rule__StringFunction__Group_1__4 ;
    public final void rule__StringFunction__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1402:1: ( rule__StringFunction__Group_1__3__Impl rule__StringFunction__Group_1__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1403:2: rule__StringFunction__Group_1__3__Impl rule__StringFunction__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__3__Impl_in_rule__StringFunction__Group_1__32891);
            rule__StringFunction__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__4_in_rule__StringFunction__Group_1__32894);
            rule__StringFunction__Group_1__4();

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
    // $ANTLR end "rule__StringFunction__Group_1__3"


    // $ANTLR start "rule__StringFunction__Group_1__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1410:1: rule__StringFunction__Group_1__3__Impl : ( ',' ) ;
    public final void rule__StringFunction__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1414:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1415:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1415:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1416:1: ','
            {
             before(grammarAccess.getStringFunctionAccess().getCommaKeyword_1_3()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__StringFunction__Group_1__3__Impl2922); 
             after(grammarAccess.getStringFunctionAccess().getCommaKeyword_1_3()); 

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
    // $ANTLR end "rule__StringFunction__Group_1__3__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1429:1: rule__StringFunction__Group_1__4 : rule__StringFunction__Group_1__4__Impl rule__StringFunction__Group_1__5 ;
    public final void rule__StringFunction__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1433:1: ( rule__StringFunction__Group_1__4__Impl rule__StringFunction__Group_1__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1434:2: rule__StringFunction__Group_1__4__Impl rule__StringFunction__Group_1__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__4__Impl_in_rule__StringFunction__Group_1__42953);
            rule__StringFunction__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__5_in_rule__StringFunction__Group_1__42956);
            rule__StringFunction__Group_1__5();

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
    // $ANTLR end "rule__StringFunction__Group_1__4"


    // $ANTLR start "rule__StringFunction__Group_1__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1441:1: rule__StringFunction__Group_1__4__Impl : ( ( rule__StringFunction__MatchAssignment_1_4 ) ) ;
    public final void rule__StringFunction__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1445:1: ( ( ( rule__StringFunction__MatchAssignment_1_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1446:1: ( ( rule__StringFunction__MatchAssignment_1_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1446:1: ( ( rule__StringFunction__MatchAssignment_1_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1447:1: ( rule__StringFunction__MatchAssignment_1_4 )
            {
             before(grammarAccess.getStringFunctionAccess().getMatchAssignment_1_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1448:1: ( rule__StringFunction__MatchAssignment_1_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1448:2: rule__StringFunction__MatchAssignment_1_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__MatchAssignment_1_4_in_rule__StringFunction__Group_1__4__Impl2983);
            rule__StringFunction__MatchAssignment_1_4();

            state._fsp--;


            }

             after(grammarAccess.getStringFunctionAccess().getMatchAssignment_1_4()); 

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
    // $ANTLR end "rule__StringFunction__Group_1__4__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1458:1: rule__StringFunction__Group_1__5 : rule__StringFunction__Group_1__5__Impl rule__StringFunction__Group_1__6 ;
    public final void rule__StringFunction__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1462:1: ( rule__StringFunction__Group_1__5__Impl rule__StringFunction__Group_1__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1463:2: rule__StringFunction__Group_1__5__Impl rule__StringFunction__Group_1__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__5__Impl_in_rule__StringFunction__Group_1__53013);
            rule__StringFunction__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__6_in_rule__StringFunction__Group_1__53016);
            rule__StringFunction__Group_1__6();

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
    // $ANTLR end "rule__StringFunction__Group_1__5"


    // $ANTLR start "rule__StringFunction__Group_1__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1470:1: rule__StringFunction__Group_1__5__Impl : ( ',' ) ;
    public final void rule__StringFunction__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1474:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1475:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1475:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1476:1: ','
            {
             before(grammarAccess.getStringFunctionAccess().getCommaKeyword_1_5()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__StringFunction__Group_1__5__Impl3044); 
             after(grammarAccess.getStringFunctionAccess().getCommaKeyword_1_5()); 

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
    // $ANTLR end "rule__StringFunction__Group_1__5__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1489:1: rule__StringFunction__Group_1__6 : rule__StringFunction__Group_1__6__Impl rule__StringFunction__Group_1__7 ;
    public final void rule__StringFunction__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1493:1: ( rule__StringFunction__Group_1__6__Impl rule__StringFunction__Group_1__7 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1494:2: rule__StringFunction__Group_1__6__Impl rule__StringFunction__Group_1__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__6__Impl_in_rule__StringFunction__Group_1__63075);
            rule__StringFunction__Group_1__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__7_in_rule__StringFunction__Group_1__63078);
            rule__StringFunction__Group_1__7();

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
    // $ANTLR end "rule__StringFunction__Group_1__6"


    // $ANTLR start "rule__StringFunction__Group_1__6__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1501:1: rule__StringFunction__Group_1__6__Impl : ( ( rule__StringFunction__ReplacementAssignment_1_6 ) ) ;
    public final void rule__StringFunction__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1505:1: ( ( ( rule__StringFunction__ReplacementAssignment_1_6 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1506:1: ( ( rule__StringFunction__ReplacementAssignment_1_6 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1506:1: ( ( rule__StringFunction__ReplacementAssignment_1_6 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1507:1: ( rule__StringFunction__ReplacementAssignment_1_6 )
            {
             before(grammarAccess.getStringFunctionAccess().getReplacementAssignment_1_6()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1508:1: ( rule__StringFunction__ReplacementAssignment_1_6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1508:2: rule__StringFunction__ReplacementAssignment_1_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__ReplacementAssignment_1_6_in_rule__StringFunction__Group_1__6__Impl3105);
            rule__StringFunction__ReplacementAssignment_1_6();

            state._fsp--;


            }

             after(grammarAccess.getStringFunctionAccess().getReplacementAssignment_1_6()); 

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
    // $ANTLR end "rule__StringFunction__Group_1__6__Impl"


    // $ANTLR start "rule__StringFunction__Group_1__7"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1518:1: rule__StringFunction__Group_1__7 : rule__StringFunction__Group_1__7__Impl ;
    public final void rule__StringFunction__Group_1__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1522:1: ( rule__StringFunction__Group_1__7__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1523:2: rule__StringFunction__Group_1__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_1__7__Impl_in_rule__StringFunction__Group_1__73135);
            rule__StringFunction__Group_1__7__Impl();

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
    // $ANTLR end "rule__StringFunction__Group_1__7"


    // $ANTLR start "rule__StringFunction__Group_1__7__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1529:1: rule__StringFunction__Group_1__7__Impl : ( ')' ) ;
    public final void rule__StringFunction__Group_1__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1533:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1534:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1534:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1535:1: ')'
            {
             before(grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_1_7()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__StringFunction__Group_1__7__Impl3163); 
             after(grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_1_7()); 

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
    // $ANTLR end "rule__StringFunction__Group_1__7__Impl"


    // $ANTLR start "rule__StringFunction__Group_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1564:1: rule__StringFunction__Group_2__0 : rule__StringFunction__Group_2__0__Impl rule__StringFunction__Group_2__1 ;
    public final void rule__StringFunction__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1568:1: ( rule__StringFunction__Group_2__0__Impl rule__StringFunction__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1569:2: rule__StringFunction__Group_2__0__Impl rule__StringFunction__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__0__Impl_in_rule__StringFunction__Group_2__03210);
            rule__StringFunction__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__1_in_rule__StringFunction__Group_2__03213);
            rule__StringFunction__Group_2__1();

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
    // $ANTLR end "rule__StringFunction__Group_2__0"


    // $ANTLR start "rule__StringFunction__Group_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1576:1: rule__StringFunction__Group_2__0__Impl : ( () ) ;
    public final void rule__StringFunction__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1580:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1581:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1581:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1582:1: ()
            {
             before(grammarAccess.getStringFunctionAccess().getStringUrlConformAction_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1583:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1585:1: 
            {
            }

             after(grammarAccess.getStringFunctionAccess().getStringUrlConformAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringFunction__Group_2__0__Impl"


    // $ANTLR start "rule__StringFunction__Group_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1595:1: rule__StringFunction__Group_2__1 : rule__StringFunction__Group_2__1__Impl rule__StringFunction__Group_2__2 ;
    public final void rule__StringFunction__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1599:1: ( rule__StringFunction__Group_2__1__Impl rule__StringFunction__Group_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1600:2: rule__StringFunction__Group_2__1__Impl rule__StringFunction__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__1__Impl_in_rule__StringFunction__Group_2__13271);
            rule__StringFunction__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__2_in_rule__StringFunction__Group_2__13274);
            rule__StringFunction__Group_2__2();

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
    // $ANTLR end "rule__StringFunction__Group_2__1"


    // $ANTLR start "rule__StringFunction__Group_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1607:1: rule__StringFunction__Group_2__1__Impl : ( 'urlconform(' ) ;
    public final void rule__StringFunction__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1611:1: ( ( 'urlconform(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1612:1: ( 'urlconform(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1612:1: ( 'urlconform(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1613:1: 'urlconform('
            {
             before(grammarAccess.getStringFunctionAccess().getUrlconformKeyword_2_1()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__StringFunction__Group_2__1__Impl3302); 
             after(grammarAccess.getStringFunctionAccess().getUrlconformKeyword_2_1()); 

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
    // $ANTLR end "rule__StringFunction__Group_2__1__Impl"


    // $ANTLR start "rule__StringFunction__Group_2__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1626:1: rule__StringFunction__Group_2__2 : rule__StringFunction__Group_2__2__Impl rule__StringFunction__Group_2__3 ;
    public final void rule__StringFunction__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1630:1: ( rule__StringFunction__Group_2__2__Impl rule__StringFunction__Group_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1631:2: rule__StringFunction__Group_2__2__Impl rule__StringFunction__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__2__Impl_in_rule__StringFunction__Group_2__23333);
            rule__StringFunction__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__3_in_rule__StringFunction__Group_2__23336);
            rule__StringFunction__Group_2__3();

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
    // $ANTLR end "rule__StringFunction__Group_2__2"


    // $ANTLR start "rule__StringFunction__Group_2__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1638:1: rule__StringFunction__Group_2__2__Impl : ( ( rule__StringFunction__ValueAssignment_2_2 ) ) ;
    public final void rule__StringFunction__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1642:1: ( ( ( rule__StringFunction__ValueAssignment_2_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1643:1: ( ( rule__StringFunction__ValueAssignment_2_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1643:1: ( ( rule__StringFunction__ValueAssignment_2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1644:1: ( rule__StringFunction__ValueAssignment_2_2 )
            {
             before(grammarAccess.getStringFunctionAccess().getValueAssignment_2_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1645:1: ( rule__StringFunction__ValueAssignment_2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1645:2: rule__StringFunction__ValueAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__ValueAssignment_2_2_in_rule__StringFunction__Group_2__2__Impl3363);
            rule__StringFunction__ValueAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getStringFunctionAccess().getValueAssignment_2_2()); 

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
    // $ANTLR end "rule__StringFunction__Group_2__2__Impl"


    // $ANTLR start "rule__StringFunction__Group_2__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1655:1: rule__StringFunction__Group_2__3 : rule__StringFunction__Group_2__3__Impl ;
    public final void rule__StringFunction__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1659:1: ( rule__StringFunction__Group_2__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1660:2: rule__StringFunction__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__StringFunction__Group_2__3__Impl_in_rule__StringFunction__Group_2__33393);
            rule__StringFunction__Group_2__3__Impl();

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
    // $ANTLR end "rule__StringFunction__Group_2__3"


    // $ANTLR start "rule__StringFunction__Group_2__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1666:1: rule__StringFunction__Group_2__3__Impl : ( ')' ) ;
    public final void rule__StringFunction__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1670:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1671:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1671:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1672:1: ')'
            {
             before(grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_2_3()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__StringFunction__Group_2__3__Impl3421); 
             after(grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_2_3()); 

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
    // $ANTLR end "rule__StringFunction__Group_2__3__Impl"


    // $ANTLR start "rule__CollectionLiteral__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1693:1: rule__CollectionLiteral__Group__0 : rule__CollectionLiteral__Group__0__Impl rule__CollectionLiteral__Group__1 ;
    public final void rule__CollectionLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1697:1: ( rule__CollectionLiteral__Group__0__Impl rule__CollectionLiteral__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1698:2: rule__CollectionLiteral__Group__0__Impl rule__CollectionLiteral__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__0__Impl_in_rule__CollectionLiteral__Group__03460);
            rule__CollectionLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__1_in_rule__CollectionLiteral__Group__03463);
            rule__CollectionLiteral__Group__1();

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
    // $ANTLR end "rule__CollectionLiteral__Group__0"


    // $ANTLR start "rule__CollectionLiteral__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1705:1: rule__CollectionLiteral__Group__0__Impl : ( '[' ) ;
    public final void rule__CollectionLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1709:1: ( ( '[' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1710:1: ( '[' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1710:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1711:1: '['
            {
             before(grammarAccess.getCollectionLiteralAccess().getLeftSquareBracketKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__CollectionLiteral__Group__0__Impl3491); 
             after(grammarAccess.getCollectionLiteralAccess().getLeftSquareBracketKeyword_0()); 

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
    // $ANTLR end "rule__CollectionLiteral__Group__0__Impl"


    // $ANTLR start "rule__CollectionLiteral__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1724:1: rule__CollectionLiteral__Group__1 : rule__CollectionLiteral__Group__1__Impl rule__CollectionLiteral__Group__2 ;
    public final void rule__CollectionLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1728:1: ( rule__CollectionLiteral__Group__1__Impl rule__CollectionLiteral__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1729:2: rule__CollectionLiteral__Group__1__Impl rule__CollectionLiteral__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__1__Impl_in_rule__CollectionLiteral__Group__13522);
            rule__CollectionLiteral__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__2_in_rule__CollectionLiteral__Group__13525);
            rule__CollectionLiteral__Group__2();

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
    // $ANTLR end "rule__CollectionLiteral__Group__1"


    // $ANTLR start "rule__CollectionLiteral__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1736:1: rule__CollectionLiteral__Group__1__Impl : ( ( rule__CollectionLiteral__ItemsAssignment_1 ) ) ;
    public final void rule__CollectionLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1740:1: ( ( ( rule__CollectionLiteral__ItemsAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1741:1: ( ( rule__CollectionLiteral__ItemsAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1741:1: ( ( rule__CollectionLiteral__ItemsAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1742:1: ( rule__CollectionLiteral__ItemsAssignment_1 )
            {
             before(grammarAccess.getCollectionLiteralAccess().getItemsAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1743:1: ( rule__CollectionLiteral__ItemsAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1743:2: rule__CollectionLiteral__ItemsAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__ItemsAssignment_1_in_rule__CollectionLiteral__Group__1__Impl3552);
            rule__CollectionLiteral__ItemsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionLiteralAccess().getItemsAssignment_1()); 

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
    // $ANTLR end "rule__CollectionLiteral__Group__1__Impl"


    // $ANTLR start "rule__CollectionLiteral__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1753:1: rule__CollectionLiteral__Group__2 : rule__CollectionLiteral__Group__2__Impl rule__CollectionLiteral__Group__3 ;
    public final void rule__CollectionLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1757:1: ( rule__CollectionLiteral__Group__2__Impl rule__CollectionLiteral__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1758:2: rule__CollectionLiteral__Group__2__Impl rule__CollectionLiteral__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__2__Impl_in_rule__CollectionLiteral__Group__23582);
            rule__CollectionLiteral__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__3_in_rule__CollectionLiteral__Group__23585);
            rule__CollectionLiteral__Group__3();

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
    // $ANTLR end "rule__CollectionLiteral__Group__2"


    // $ANTLR start "rule__CollectionLiteral__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1765:1: rule__CollectionLiteral__Group__2__Impl : ( ( rule__CollectionLiteral__Group_2__0 )* ) ;
    public final void rule__CollectionLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1769:1: ( ( ( rule__CollectionLiteral__Group_2__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1770:1: ( ( rule__CollectionLiteral__Group_2__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1770:1: ( ( rule__CollectionLiteral__Group_2__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1771:1: ( rule__CollectionLiteral__Group_2__0 )*
            {
             before(grammarAccess.getCollectionLiteralAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1772:1: ( rule__CollectionLiteral__Group_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1772:2: rule__CollectionLiteral__Group_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group_2__0_in_rule__CollectionLiteral__Group__2__Impl3612);
            	    rule__CollectionLiteral__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getCollectionLiteralAccess().getGroup_2()); 

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
    // $ANTLR end "rule__CollectionLiteral__Group__2__Impl"


    // $ANTLR start "rule__CollectionLiteral__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1782:1: rule__CollectionLiteral__Group__3 : rule__CollectionLiteral__Group__3__Impl ;
    public final void rule__CollectionLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1786:1: ( rule__CollectionLiteral__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1787:2: rule__CollectionLiteral__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group__3__Impl_in_rule__CollectionLiteral__Group__33643);
            rule__CollectionLiteral__Group__3__Impl();

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
    // $ANTLR end "rule__CollectionLiteral__Group__3"


    // $ANTLR start "rule__CollectionLiteral__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1793:1: rule__CollectionLiteral__Group__3__Impl : ( ']' ) ;
    public final void rule__CollectionLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1797:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1798:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1798:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1799:1: ']'
            {
             before(grammarAccess.getCollectionLiteralAccess().getRightSquareBracketKeyword_3()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__CollectionLiteral__Group__3__Impl3671); 
             after(grammarAccess.getCollectionLiteralAccess().getRightSquareBracketKeyword_3()); 

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
    // $ANTLR end "rule__CollectionLiteral__Group__3__Impl"


    // $ANTLR start "rule__CollectionLiteral__Group_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1820:1: rule__CollectionLiteral__Group_2__0 : rule__CollectionLiteral__Group_2__0__Impl rule__CollectionLiteral__Group_2__1 ;
    public final void rule__CollectionLiteral__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1824:1: ( rule__CollectionLiteral__Group_2__0__Impl rule__CollectionLiteral__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1825:2: rule__CollectionLiteral__Group_2__0__Impl rule__CollectionLiteral__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group_2__0__Impl_in_rule__CollectionLiteral__Group_2__03710);
            rule__CollectionLiteral__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group_2__1_in_rule__CollectionLiteral__Group_2__03713);
            rule__CollectionLiteral__Group_2__1();

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
    // $ANTLR end "rule__CollectionLiteral__Group_2__0"


    // $ANTLR start "rule__CollectionLiteral__Group_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1832:1: rule__CollectionLiteral__Group_2__0__Impl : ( ',' ) ;
    public final void rule__CollectionLiteral__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1836:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1837:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1837:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1838:1: ','
            {
             before(grammarAccess.getCollectionLiteralAccess().getCommaKeyword_2_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__CollectionLiteral__Group_2__0__Impl3741); 
             after(grammarAccess.getCollectionLiteralAccess().getCommaKeyword_2_0()); 

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
    // $ANTLR end "rule__CollectionLiteral__Group_2__0__Impl"


    // $ANTLR start "rule__CollectionLiteral__Group_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1851:1: rule__CollectionLiteral__Group_2__1 : rule__CollectionLiteral__Group_2__1__Impl ;
    public final void rule__CollectionLiteral__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1855:1: ( rule__CollectionLiteral__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1856:2: rule__CollectionLiteral__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__Group_2__1__Impl_in_rule__CollectionLiteral__Group_2__13772);
            rule__CollectionLiteral__Group_2__1__Impl();

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
    // $ANTLR end "rule__CollectionLiteral__Group_2__1"


    // $ANTLR start "rule__CollectionLiteral__Group_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1862:1: rule__CollectionLiteral__Group_2__1__Impl : ( ( rule__CollectionLiteral__ItemsAssignment_2_1 ) ) ;
    public final void rule__CollectionLiteral__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1866:1: ( ( ( rule__CollectionLiteral__ItemsAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1867:1: ( ( rule__CollectionLiteral__ItemsAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1867:1: ( ( rule__CollectionLiteral__ItemsAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1868:1: ( rule__CollectionLiteral__ItemsAssignment_2_1 )
            {
             before(grammarAccess.getCollectionLiteralAccess().getItemsAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1869:1: ( rule__CollectionLiteral__ItemsAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1869:2: rule__CollectionLiteral__ItemsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionLiteral__ItemsAssignment_2_1_in_rule__CollectionLiteral__Group_2__1__Impl3799);
            rule__CollectionLiteral__ItemsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionLiteralAccess().getItemsAssignment_2_1()); 

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
    // $ANTLR end "rule__CollectionLiteral__Group_2__1__Impl"


    // $ANTLR start "rule__CollectionFunction__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1883:1: rule__CollectionFunction__Group__0 : rule__CollectionFunction__Group__0__Impl rule__CollectionFunction__Group__1 ;
    public final void rule__CollectionFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1887:1: ( rule__CollectionFunction__Group__0__Impl rule__CollectionFunction__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1888:2: rule__CollectionFunction__Group__0__Impl rule__CollectionFunction__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__0__Impl_in_rule__CollectionFunction__Group__03833);
            rule__CollectionFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__1_in_rule__CollectionFunction__Group__03836);
            rule__CollectionFunction__Group__1();

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
    // $ANTLR end "rule__CollectionFunction__Group__0"


    // $ANTLR start "rule__CollectionFunction__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1895:1: rule__CollectionFunction__Group__0__Impl : ( () ) ;
    public final void rule__CollectionFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1899:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1900:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1900:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1901:1: ()
            {
             before(grammarAccess.getCollectionFunctionAccess().getStringSplitAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1902:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1904:1: 
            {
            }

             after(grammarAccess.getCollectionFunctionAccess().getStringSplitAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionFunction__Group__0__Impl"


    // $ANTLR start "rule__CollectionFunction__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1914:1: rule__CollectionFunction__Group__1 : rule__CollectionFunction__Group__1__Impl rule__CollectionFunction__Group__2 ;
    public final void rule__CollectionFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1918:1: ( rule__CollectionFunction__Group__1__Impl rule__CollectionFunction__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1919:2: rule__CollectionFunction__Group__1__Impl rule__CollectionFunction__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__1__Impl_in_rule__CollectionFunction__Group__13894);
            rule__CollectionFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__2_in_rule__CollectionFunction__Group__13897);
            rule__CollectionFunction__Group__2();

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
    // $ANTLR end "rule__CollectionFunction__Group__1"


    // $ANTLR start "rule__CollectionFunction__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1926:1: rule__CollectionFunction__Group__1__Impl : ( 'split(' ) ;
    public final void rule__CollectionFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1930:1: ( ( 'split(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1931:1: ( 'split(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1931:1: ( 'split(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1932:1: 'split('
            {
             before(grammarAccess.getCollectionFunctionAccess().getSplitKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__CollectionFunction__Group__1__Impl3925); 
             after(grammarAccess.getCollectionFunctionAccess().getSplitKeyword_1()); 

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
    // $ANTLR end "rule__CollectionFunction__Group__1__Impl"


    // $ANTLR start "rule__CollectionFunction__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1945:1: rule__CollectionFunction__Group__2 : rule__CollectionFunction__Group__2__Impl rule__CollectionFunction__Group__3 ;
    public final void rule__CollectionFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1949:1: ( rule__CollectionFunction__Group__2__Impl rule__CollectionFunction__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1950:2: rule__CollectionFunction__Group__2__Impl rule__CollectionFunction__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__2__Impl_in_rule__CollectionFunction__Group__23956);
            rule__CollectionFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__3_in_rule__CollectionFunction__Group__23959);
            rule__CollectionFunction__Group__3();

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
    // $ANTLR end "rule__CollectionFunction__Group__2"


    // $ANTLR start "rule__CollectionFunction__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1957:1: rule__CollectionFunction__Group__2__Impl : ( ( rule__CollectionFunction__ValueAssignment_2 ) ) ;
    public final void rule__CollectionFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1961:1: ( ( ( rule__CollectionFunction__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1962:1: ( ( rule__CollectionFunction__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1962:1: ( ( rule__CollectionFunction__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1963:1: ( rule__CollectionFunction__ValueAssignment_2 )
            {
             before(grammarAccess.getCollectionFunctionAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1964:1: ( rule__CollectionFunction__ValueAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1964:2: rule__CollectionFunction__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__ValueAssignment_2_in_rule__CollectionFunction__Group__2__Impl3986);
            rule__CollectionFunction__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCollectionFunctionAccess().getValueAssignment_2()); 

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
    // $ANTLR end "rule__CollectionFunction__Group__2__Impl"


    // $ANTLR start "rule__CollectionFunction__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1974:1: rule__CollectionFunction__Group__3 : rule__CollectionFunction__Group__3__Impl rule__CollectionFunction__Group__4 ;
    public final void rule__CollectionFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1978:1: ( rule__CollectionFunction__Group__3__Impl rule__CollectionFunction__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1979:2: rule__CollectionFunction__Group__3__Impl rule__CollectionFunction__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__3__Impl_in_rule__CollectionFunction__Group__34016);
            rule__CollectionFunction__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__4_in_rule__CollectionFunction__Group__34019);
            rule__CollectionFunction__Group__4();

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
    // $ANTLR end "rule__CollectionFunction__Group__3"


    // $ANTLR start "rule__CollectionFunction__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1986:1: rule__CollectionFunction__Group__3__Impl : ( ',' ) ;
    public final void rule__CollectionFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1990:1: ( ( ',' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1991:1: ( ',' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1991:1: ( ',' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:1992:1: ','
            {
             before(grammarAccess.getCollectionFunctionAccess().getCommaKeyword_3()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__CollectionFunction__Group__3__Impl4047); 
             after(grammarAccess.getCollectionFunctionAccess().getCommaKeyword_3()); 

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
    // $ANTLR end "rule__CollectionFunction__Group__3__Impl"


    // $ANTLR start "rule__CollectionFunction__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2005:1: rule__CollectionFunction__Group__4 : rule__CollectionFunction__Group__4__Impl rule__CollectionFunction__Group__5 ;
    public final void rule__CollectionFunction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2009:1: ( rule__CollectionFunction__Group__4__Impl rule__CollectionFunction__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2010:2: rule__CollectionFunction__Group__4__Impl rule__CollectionFunction__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__4__Impl_in_rule__CollectionFunction__Group__44078);
            rule__CollectionFunction__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__5_in_rule__CollectionFunction__Group__44081);
            rule__CollectionFunction__Group__5();

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
    // $ANTLR end "rule__CollectionFunction__Group__4"


    // $ANTLR start "rule__CollectionFunction__Group__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2017:1: rule__CollectionFunction__Group__4__Impl : ( ( rule__CollectionFunction__DelimiterAssignment_4 ) ) ;
    public final void rule__CollectionFunction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2021:1: ( ( ( rule__CollectionFunction__DelimiterAssignment_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2022:1: ( ( rule__CollectionFunction__DelimiterAssignment_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2022:1: ( ( rule__CollectionFunction__DelimiterAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2023:1: ( rule__CollectionFunction__DelimiterAssignment_4 )
            {
             before(grammarAccess.getCollectionFunctionAccess().getDelimiterAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2024:1: ( rule__CollectionFunction__DelimiterAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2024:2: rule__CollectionFunction__DelimiterAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__DelimiterAssignment_4_in_rule__CollectionFunction__Group__4__Impl4108);
            rule__CollectionFunction__DelimiterAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getCollectionFunctionAccess().getDelimiterAssignment_4()); 

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
    // $ANTLR end "rule__CollectionFunction__Group__4__Impl"


    // $ANTLR start "rule__CollectionFunction__Group__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2034:1: rule__CollectionFunction__Group__5 : rule__CollectionFunction__Group__5__Impl ;
    public final void rule__CollectionFunction__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2038:1: ( rule__CollectionFunction__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2039:2: rule__CollectionFunction__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionFunction__Group__5__Impl_in_rule__CollectionFunction__Group__54138);
            rule__CollectionFunction__Group__5__Impl();

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
    // $ANTLR end "rule__CollectionFunction__Group__5"


    // $ANTLR start "rule__CollectionFunction__Group__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2045:1: rule__CollectionFunction__Group__5__Impl : ( ')' ) ;
    public final void rule__CollectionFunction__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2049:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2050:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2050:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2051:1: ')'
            {
             before(grammarAccess.getCollectionFunctionAccess().getRightParenthesisKeyword_5()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__CollectionFunction__Group__5__Impl4166); 
             after(grammarAccess.getCollectionFunctionAccess().getRightParenthesisKeyword_5()); 

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
    // $ANTLR end "rule__CollectionFunction__Group__5__Impl"


    // $ANTLR start "rule__TableView__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2076:1: rule__TableView__Group__0 : rule__TableView__Group__0__Impl rule__TableView__Group__1 ;
    public final void rule__TableView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2080:1: ( rule__TableView__Group__0__Impl rule__TableView__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2081:2: rule__TableView__Group__0__Impl rule__TableView__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__0__Impl_in_rule__TableView__Group__04209);
            rule__TableView__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__1_in_rule__TableView__Group__04212);
            rule__TableView__Group__1();

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
    // $ANTLR end "rule__TableView__Group__0"


    // $ANTLR start "rule__TableView__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2088:1: rule__TableView__Group__0__Impl : ( 'tableview' ) ;
    public final void rule__TableView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2092:1: ( ( 'tableview' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2093:1: ( 'tableview' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2093:1: ( 'tableview' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2094:1: 'tableview'
            {
             before(grammarAccess.getTableViewAccess().getTableviewKeyword_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TableView__Group__0__Impl4240); 
             after(grammarAccess.getTableViewAccess().getTableviewKeyword_0()); 

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
    // $ANTLR end "rule__TableView__Group__0__Impl"


    // $ANTLR start "rule__TableView__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2107:1: rule__TableView__Group__1 : rule__TableView__Group__1__Impl rule__TableView__Group__2 ;
    public final void rule__TableView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2111:1: ( rule__TableView__Group__1__Impl rule__TableView__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2112:2: rule__TableView__Group__1__Impl rule__TableView__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__1__Impl_in_rule__TableView__Group__14271);
            rule__TableView__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__2_in_rule__TableView__Group__14274);
            rule__TableView__Group__2();

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
    // $ANTLR end "rule__TableView__Group__1"


    // $ANTLR start "rule__TableView__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2119:1: rule__TableView__Group__1__Impl : ( ( rule__TableView__NameAssignment_1 ) ) ;
    public final void rule__TableView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2123:1: ( ( ( rule__TableView__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2124:1: ( ( rule__TableView__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2124:1: ( ( rule__TableView__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2125:1: ( rule__TableView__NameAssignment_1 )
            {
             before(grammarAccess.getTableViewAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2126:1: ( rule__TableView__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2126:2: rule__TableView__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__NameAssignment_1_in_rule__TableView__Group__1__Impl4301);
            rule__TableView__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTableViewAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__TableView__Group__1__Impl"


    // $ANTLR start "rule__TableView__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2136:1: rule__TableView__Group__2 : rule__TableView__Group__2__Impl rule__TableView__Group__3 ;
    public final void rule__TableView__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2140:1: ( rule__TableView__Group__2__Impl rule__TableView__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2141:2: rule__TableView__Group__2__Impl rule__TableView__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__2__Impl_in_rule__TableView__Group__24331);
            rule__TableView__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__3_in_rule__TableView__Group__24334);
            rule__TableView__Group__3();

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
    // $ANTLR end "rule__TableView__Group__2"


    // $ANTLR start "rule__TableView__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2148:1: rule__TableView__Group__2__Impl : ( ( rule__TableView__Group_2__0 )? ) ;
    public final void rule__TableView__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2152:1: ( ( ( rule__TableView__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2153:1: ( ( rule__TableView__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2153:1: ( ( rule__TableView__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2154:1: ( rule__TableView__Group_2__0 )?
            {
             before(grammarAccess.getTableViewAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2155:1: ( rule__TableView__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2155:2: rule__TableView__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_2__0_in_rule__TableView__Group__2__Impl4361);
                    rule__TableView__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTableViewAccess().getGroup_2()); 

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
    // $ANTLR end "rule__TableView__Group__2__Impl"


    // $ANTLR start "rule__TableView__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2165:1: rule__TableView__Group__3 : rule__TableView__Group__3__Impl rule__TableView__Group__4 ;
    public final void rule__TableView__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2169:1: ( rule__TableView__Group__3__Impl rule__TableView__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2170:2: rule__TableView__Group__3__Impl rule__TableView__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__3__Impl_in_rule__TableView__Group__34392);
            rule__TableView__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__4_in_rule__TableView__Group__34395);
            rule__TableView__Group__4();

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
    // $ANTLR end "rule__TableView__Group__3"


    // $ANTLR start "rule__TableView__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2177:1: rule__TableView__Group__3__Impl : ( '{' ) ;
    public final void rule__TableView__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2181:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2182:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2182:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2183:1: '{'
            {
             before(grammarAccess.getTableViewAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__TableView__Group__3__Impl4423); 
             after(grammarAccess.getTableViewAccess().getLeftCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__TableView__Group__3__Impl"


    // $ANTLR start "rule__TableView__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2196:1: rule__TableView__Group__4 : rule__TableView__Group__4__Impl rule__TableView__Group__5 ;
    public final void rule__TableView__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2200:1: ( rule__TableView__Group__4__Impl rule__TableView__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2201:2: rule__TableView__Group__4__Impl rule__TableView__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__4__Impl_in_rule__TableView__Group__44454);
            rule__TableView__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__5_in_rule__TableView__Group__44457);
            rule__TableView__Group__5();

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
    // $ANTLR end "rule__TableView__Group__4"


    // $ANTLR start "rule__TableView__Group__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2208:1: rule__TableView__Group__4__Impl : ( ( rule__TableView__UnorderedGroup_4 ) ) ;
    public final void rule__TableView__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2212:1: ( ( ( rule__TableView__UnorderedGroup_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2213:1: ( ( rule__TableView__UnorderedGroup_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2213:1: ( ( rule__TableView__UnorderedGroup_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2214:1: ( rule__TableView__UnorderedGroup_4 )
            {
             before(grammarAccess.getTableViewAccess().getUnorderedGroup_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2215:1: ( rule__TableView__UnorderedGroup_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2215:2: rule__TableView__UnorderedGroup_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__UnorderedGroup_4_in_rule__TableView__Group__4__Impl4484);
            rule__TableView__UnorderedGroup_4();

            state._fsp--;


            }

             after(grammarAccess.getTableViewAccess().getUnorderedGroup_4()); 

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
    // $ANTLR end "rule__TableView__Group__4__Impl"


    // $ANTLR start "rule__TableView__Group__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2225:1: rule__TableView__Group__5 : rule__TableView__Group__5__Impl rule__TableView__Group__6 ;
    public final void rule__TableView__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2229:1: ( rule__TableView__Group__5__Impl rule__TableView__Group__6 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2230:2: rule__TableView__Group__5__Impl rule__TableView__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__5__Impl_in_rule__TableView__Group__54514);
            rule__TableView__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__6_in_rule__TableView__Group__54517);
            rule__TableView__Group__6();

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
    // $ANTLR end "rule__TableView__Group__5"


    // $ANTLR start "rule__TableView__Group__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2237:1: rule__TableView__Group__5__Impl : ( ( rule__TableView__SectionsAssignment_5 )* ) ;
    public final void rule__TableView__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2241:1: ( ( ( rule__TableView__SectionsAssignment_5 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2242:1: ( ( rule__TableView__SectionsAssignment_5 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2242:1: ( ( rule__TableView__SectionsAssignment_5 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2243:1: ( rule__TableView__SectionsAssignment_5 )*
            {
             before(grammarAccess.getTableViewAccess().getSectionsAssignment_5()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2244:1: ( rule__TableView__SectionsAssignment_5 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==36) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2244:2: rule__TableView__SectionsAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__TableView__SectionsAssignment_5_in_rule__TableView__Group__5__Impl4544);
            	    rule__TableView__SectionsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getTableViewAccess().getSectionsAssignment_5()); 

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
    // $ANTLR end "rule__TableView__Group__5__Impl"


    // $ANTLR start "rule__TableView__Group__6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2254:1: rule__TableView__Group__6 : rule__TableView__Group__6__Impl ;
    public final void rule__TableView__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2258:1: ( rule__TableView__Group__6__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2259:2: rule__TableView__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group__6__Impl_in_rule__TableView__Group__64575);
            rule__TableView__Group__6__Impl();

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
    // $ANTLR end "rule__TableView__Group__6"


    // $ANTLR start "rule__TableView__Group__6__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2265:1: rule__TableView__Group__6__Impl : ( '}' ) ;
    public final void rule__TableView__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2269:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2270:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2270:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2271:1: '}'
            {
             before(grammarAccess.getTableViewAccess().getRightCurlyBracketKeyword_6()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__TableView__Group__6__Impl4603); 
             after(grammarAccess.getTableViewAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__TableView__Group__6__Impl"


    // $ANTLR start "rule__TableView__Group_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2298:1: rule__TableView__Group_2__0 : rule__TableView__Group_2__0__Impl rule__TableView__Group_2__1 ;
    public final void rule__TableView__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2302:1: ( rule__TableView__Group_2__0__Impl rule__TableView__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2303:2: rule__TableView__Group_2__0__Impl rule__TableView__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_2__0__Impl_in_rule__TableView__Group_2__04648);
            rule__TableView__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_2__1_in_rule__TableView__Group_2__04651);
            rule__TableView__Group_2__1();

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
    // $ANTLR end "rule__TableView__Group_2__0"


    // $ANTLR start "rule__TableView__Group_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2310:1: rule__TableView__Group_2__0__Impl : ( '(' ) ;
    public final void rule__TableView__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2314:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2315:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2315:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2316:1: '('
            {
             before(grammarAccess.getTableViewAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__TableView__Group_2__0__Impl4679); 
             after(grammarAccess.getTableViewAccess().getLeftParenthesisKeyword_2_0()); 

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
    // $ANTLR end "rule__TableView__Group_2__0__Impl"


    // $ANTLR start "rule__TableView__Group_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2329:1: rule__TableView__Group_2__1 : rule__TableView__Group_2__1__Impl rule__TableView__Group_2__2 ;
    public final void rule__TableView__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2333:1: ( rule__TableView__Group_2__1__Impl rule__TableView__Group_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2334:2: rule__TableView__Group_2__1__Impl rule__TableView__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_2__1__Impl_in_rule__TableView__Group_2__14710);
            rule__TableView__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_2__2_in_rule__TableView__Group_2__14713);
            rule__TableView__Group_2__2();

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
    // $ANTLR end "rule__TableView__Group_2__1"


    // $ANTLR start "rule__TableView__Group_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2341:1: rule__TableView__Group_2__1__Impl : ( ( rule__TableView__ContentAssignment_2_1 ) ) ;
    public final void rule__TableView__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2345:1: ( ( ( rule__TableView__ContentAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2346:1: ( ( rule__TableView__ContentAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2346:1: ( ( rule__TableView__ContentAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2347:1: ( rule__TableView__ContentAssignment_2_1 )
            {
             before(grammarAccess.getTableViewAccess().getContentAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2348:1: ( rule__TableView__ContentAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2348:2: rule__TableView__ContentAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__ContentAssignment_2_1_in_rule__TableView__Group_2__1__Impl4740);
            rule__TableView__ContentAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTableViewAccess().getContentAssignment_2_1()); 

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
    // $ANTLR end "rule__TableView__Group_2__1__Impl"


    // $ANTLR start "rule__TableView__Group_2__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2358:1: rule__TableView__Group_2__2 : rule__TableView__Group_2__2__Impl ;
    public final void rule__TableView__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2362:1: ( rule__TableView__Group_2__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2363:2: rule__TableView__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_2__2__Impl_in_rule__TableView__Group_2__24770);
            rule__TableView__Group_2__2__Impl();

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
    // $ANTLR end "rule__TableView__Group_2__2"


    // $ANTLR start "rule__TableView__Group_2__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2369:1: rule__TableView__Group_2__2__Impl : ( ')' ) ;
    public final void rule__TableView__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2373:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2374:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2374:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2375:1: ')'
            {
             before(grammarAccess.getTableViewAccess().getRightParenthesisKeyword_2_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__TableView__Group_2__2__Impl4798); 
             after(grammarAccess.getTableViewAccess().getRightParenthesisKeyword_2_2()); 

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
    // $ANTLR end "rule__TableView__Group_2__2__Impl"


    // $ANTLR start "rule__TableView__Group_4_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2394:1: rule__TableView__Group_4_0__0 : rule__TableView__Group_4_0__0__Impl rule__TableView__Group_4_0__1 ;
    public final void rule__TableView__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2398:1: ( rule__TableView__Group_4_0__0__Impl rule__TableView__Group_4_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2399:2: rule__TableView__Group_4_0__0__Impl rule__TableView__Group_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_0__0__Impl_in_rule__TableView__Group_4_0__04835);
            rule__TableView__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_0__1_in_rule__TableView__Group_4_0__04838);
            rule__TableView__Group_4_0__1();

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
    // $ANTLR end "rule__TableView__Group_4_0__0"


    // $ANTLR start "rule__TableView__Group_4_0__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2406:1: rule__TableView__Group_4_0__0__Impl : ( 'title:' ) ;
    public final void rule__TableView__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2410:1: ( ( 'title:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2411:1: ( 'title:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2411:1: ( 'title:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2412:1: 'title:'
            {
             before(grammarAccess.getTableViewAccess().getTitleKeyword_4_0_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__TableView__Group_4_0__0__Impl4866); 
             after(grammarAccess.getTableViewAccess().getTitleKeyword_4_0_0()); 

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
    // $ANTLR end "rule__TableView__Group_4_0__0__Impl"


    // $ANTLR start "rule__TableView__Group_4_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2425:1: rule__TableView__Group_4_0__1 : rule__TableView__Group_4_0__1__Impl ;
    public final void rule__TableView__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2429:1: ( rule__TableView__Group_4_0__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2430:2: rule__TableView__Group_4_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_0__1__Impl_in_rule__TableView__Group_4_0__14897);
            rule__TableView__Group_4_0__1__Impl();

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
    // $ANTLR end "rule__TableView__Group_4_0__1"


    // $ANTLR start "rule__TableView__Group_4_0__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2436:1: rule__TableView__Group_4_0__1__Impl : ( ( rule__TableView__TitleAssignment_4_0_1 ) ) ;
    public final void rule__TableView__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2440:1: ( ( ( rule__TableView__TitleAssignment_4_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2441:1: ( ( rule__TableView__TitleAssignment_4_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2441:1: ( ( rule__TableView__TitleAssignment_4_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2442:1: ( rule__TableView__TitleAssignment_4_0_1 )
            {
             before(grammarAccess.getTableViewAccess().getTitleAssignment_4_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2443:1: ( rule__TableView__TitleAssignment_4_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2443:2: rule__TableView__TitleAssignment_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__TitleAssignment_4_0_1_in_rule__TableView__Group_4_0__1__Impl4924);
            rule__TableView__TitleAssignment_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTableViewAccess().getTitleAssignment_4_0_1()); 

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
    // $ANTLR end "rule__TableView__Group_4_0__1__Impl"


    // $ANTLR start "rule__TableView__Group_4_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2457:1: rule__TableView__Group_4_1__0 : rule__TableView__Group_4_1__0__Impl rule__TableView__Group_4_1__1 ;
    public final void rule__TableView__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2461:1: ( rule__TableView__Group_4_1__0__Impl rule__TableView__Group_4_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2462:2: rule__TableView__Group_4_1__0__Impl rule__TableView__Group_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_1__0__Impl_in_rule__TableView__Group_4_1__04958);
            rule__TableView__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_1__1_in_rule__TableView__Group_4_1__04961);
            rule__TableView__Group_4_1__1();

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
    // $ANTLR end "rule__TableView__Group_4_1__0"


    // $ANTLR start "rule__TableView__Group_4_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2469:1: rule__TableView__Group_4_1__0__Impl : ( 'titleImage:' ) ;
    public final void rule__TableView__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2473:1: ( ( 'titleImage:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2474:1: ( 'titleImage:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2474:1: ( 'titleImage:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2475:1: 'titleImage:'
            {
             before(grammarAccess.getTableViewAccess().getTitleImageKeyword_4_1_0()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__TableView__Group_4_1__0__Impl4989); 
             after(grammarAccess.getTableViewAccess().getTitleImageKeyword_4_1_0()); 

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
    // $ANTLR end "rule__TableView__Group_4_1__0__Impl"


    // $ANTLR start "rule__TableView__Group_4_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2488:1: rule__TableView__Group_4_1__1 : rule__TableView__Group_4_1__1__Impl ;
    public final void rule__TableView__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2492:1: ( rule__TableView__Group_4_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2493:2: rule__TableView__Group_4_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_1__1__Impl_in_rule__TableView__Group_4_1__15020);
            rule__TableView__Group_4_1__1__Impl();

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
    // $ANTLR end "rule__TableView__Group_4_1__1"


    // $ANTLR start "rule__TableView__Group_4_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2499:1: rule__TableView__Group_4_1__1__Impl : ( ( rule__TableView__TitleImageAssignment_4_1_1 ) ) ;
    public final void rule__TableView__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2503:1: ( ( ( rule__TableView__TitleImageAssignment_4_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2504:1: ( ( rule__TableView__TitleImageAssignment_4_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2504:1: ( ( rule__TableView__TitleImageAssignment_4_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2505:1: ( rule__TableView__TitleImageAssignment_4_1_1 )
            {
             before(grammarAccess.getTableViewAccess().getTitleImageAssignment_4_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2506:1: ( rule__TableView__TitleImageAssignment_4_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2506:2: rule__TableView__TitleImageAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__TitleImageAssignment_4_1_1_in_rule__TableView__Group_4_1__1__Impl5047);
            rule__TableView__TitleImageAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTableViewAccess().getTitleImageAssignment_4_1_1()); 

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
    // $ANTLR end "rule__TableView__Group_4_1__1__Impl"


    // $ANTLR start "rule__TableView__Group_4_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2520:1: rule__TableView__Group_4_2__0 : rule__TableView__Group_4_2__0__Impl rule__TableView__Group_4_2__1 ;
    public final void rule__TableView__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2524:1: ( rule__TableView__Group_4_2__0__Impl rule__TableView__Group_4_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2525:2: rule__TableView__Group_4_2__0__Impl rule__TableView__Group_4_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_2__0__Impl_in_rule__TableView__Group_4_2__05081);
            rule__TableView__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_2__1_in_rule__TableView__Group_4_2__05084);
            rule__TableView__Group_4_2__1();

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
    // $ANTLR end "rule__TableView__Group_4_2__0"


    // $ANTLR start "rule__TableView__Group_4_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2532:1: rule__TableView__Group_4_2__0__Impl : ( 'style:' ) ;
    public final void rule__TableView__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2536:1: ( ( 'style:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2537:1: ( 'style:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2537:1: ( 'style:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2538:1: 'style:'
            {
             before(grammarAccess.getTableViewAccess().getStyleKeyword_4_2_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__TableView__Group_4_2__0__Impl5112); 
             after(grammarAccess.getTableViewAccess().getStyleKeyword_4_2_0()); 

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
    // $ANTLR end "rule__TableView__Group_4_2__0__Impl"


    // $ANTLR start "rule__TableView__Group_4_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2551:1: rule__TableView__Group_4_2__1 : rule__TableView__Group_4_2__1__Impl ;
    public final void rule__TableView__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2555:1: ( rule__TableView__Group_4_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2556:2: rule__TableView__Group_4_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_2__1__Impl_in_rule__TableView__Group_4_2__15143);
            rule__TableView__Group_4_2__1__Impl();

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
    // $ANTLR end "rule__TableView__Group_4_2__1"


    // $ANTLR start "rule__TableView__Group_4_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2562:1: rule__TableView__Group_4_2__1__Impl : ( ( rule__TableView__StyleAssignment_4_2_1 ) ) ;
    public final void rule__TableView__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2566:1: ( ( ( rule__TableView__StyleAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2567:1: ( ( rule__TableView__StyleAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2567:1: ( ( rule__TableView__StyleAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2568:1: ( rule__TableView__StyleAssignment_4_2_1 )
            {
             before(grammarAccess.getTableViewAccess().getStyleAssignment_4_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2569:1: ( rule__TableView__StyleAssignment_4_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2569:2: rule__TableView__StyleAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__StyleAssignment_4_2_1_in_rule__TableView__Group_4_2__1__Impl5170);
            rule__TableView__StyleAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTableViewAccess().getStyleAssignment_4_2_1()); 

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
    // $ANTLR end "rule__TableView__Group_4_2__1__Impl"


    // $ANTLR start "rule__Section__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2583:1: rule__Section__Group__0 : rule__Section__Group__0__Impl rule__Section__Group__1 ;
    public final void rule__Section__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2587:1: ( rule__Section__Group__0__Impl rule__Section__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2588:2: rule__Section__Group__0__Impl rule__Section__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__0__Impl_in_rule__Section__Group__05204);
            rule__Section__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__1_in_rule__Section__Group__05207);
            rule__Section__Group__1();

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
    // $ANTLR end "rule__Section__Group__0"


    // $ANTLR start "rule__Section__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2595:1: rule__Section__Group__0__Impl : ( 'section' ) ;
    public final void rule__Section__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2599:1: ( ( 'section' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2600:1: ( 'section' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2600:1: ( 'section' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2601:1: 'section'
            {
             before(grammarAccess.getSectionAccess().getSectionKeyword_0()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__Section__Group__0__Impl5235); 
             after(grammarAccess.getSectionAccess().getSectionKeyword_0()); 

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
    // $ANTLR end "rule__Section__Group__0__Impl"


    // $ANTLR start "rule__Section__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2614:1: rule__Section__Group__1 : rule__Section__Group__1__Impl rule__Section__Group__2 ;
    public final void rule__Section__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2618:1: ( rule__Section__Group__1__Impl rule__Section__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2619:2: rule__Section__Group__1__Impl rule__Section__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__1__Impl_in_rule__Section__Group__15266);
            rule__Section__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__2_in_rule__Section__Group__15269);
            rule__Section__Group__2();

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
    // $ANTLR end "rule__Section__Group__1"


    // $ANTLR start "rule__Section__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2626:1: rule__Section__Group__1__Impl : ( ( rule__Section__IteratorAssignment_1 )? ) ;
    public final void rule__Section__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2630:1: ( ( ( rule__Section__IteratorAssignment_1 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2631:1: ( ( rule__Section__IteratorAssignment_1 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2631:1: ( ( rule__Section__IteratorAssignment_1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2632:1: ( rule__Section__IteratorAssignment_1 )?
            {
             before(grammarAccess.getSectionAccess().getIteratorAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2633:1: ( rule__Section__IteratorAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==43) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2633:2: rule__Section__IteratorAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Section__IteratorAssignment_1_in_rule__Section__Group__1__Impl5296);
                    rule__Section__IteratorAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSectionAccess().getIteratorAssignment_1()); 

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
    // $ANTLR end "rule__Section__Group__1__Impl"


    // $ANTLR start "rule__Section__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2643:1: rule__Section__Group__2 : rule__Section__Group__2__Impl rule__Section__Group__3 ;
    public final void rule__Section__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2647:1: ( rule__Section__Group__2__Impl rule__Section__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2648:2: rule__Section__Group__2__Impl rule__Section__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__2__Impl_in_rule__Section__Group__25327);
            rule__Section__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__3_in_rule__Section__Group__25330);
            rule__Section__Group__3();

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
    // $ANTLR end "rule__Section__Group__2"


    // $ANTLR start "rule__Section__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2655:1: rule__Section__Group__2__Impl : ( '{' ) ;
    public final void rule__Section__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2659:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2660:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2660:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2661:1: '{'
            {
             before(grammarAccess.getSectionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__Section__Group__2__Impl5358); 
             after(grammarAccess.getSectionAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__Section__Group__2__Impl"


    // $ANTLR start "rule__Section__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2674:1: rule__Section__Group__3 : rule__Section__Group__3__Impl rule__Section__Group__4 ;
    public final void rule__Section__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2678:1: ( rule__Section__Group__3__Impl rule__Section__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2679:2: rule__Section__Group__3__Impl rule__Section__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__3__Impl_in_rule__Section__Group__35389);
            rule__Section__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__4_in_rule__Section__Group__35392);
            rule__Section__Group__4();

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
    // $ANTLR end "rule__Section__Group__3"


    // $ANTLR start "rule__Section__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2686:1: rule__Section__Group__3__Impl : ( ( rule__Section__Group_3__0 )? ) ;
    public final void rule__Section__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2690:1: ( ( ( rule__Section__Group_3__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2691:1: ( ( rule__Section__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2691:1: ( ( rule__Section__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2692:1: ( rule__Section__Group_3__0 )?
            {
             before(grammarAccess.getSectionAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2693:1: ( rule__Section__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2693:2: rule__Section__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Section__Group_3__0_in_rule__Section__Group__3__Impl5419);
                    rule__Section__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSectionAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Section__Group__3__Impl"


    // $ANTLR start "rule__Section__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2703:1: rule__Section__Group__4 : rule__Section__Group__4__Impl rule__Section__Group__5 ;
    public final void rule__Section__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2707:1: ( rule__Section__Group__4__Impl rule__Section__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2708:2: rule__Section__Group__4__Impl rule__Section__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__4__Impl_in_rule__Section__Group__45450);
            rule__Section__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__5_in_rule__Section__Group__45453);
            rule__Section__Group__5();

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
    // $ANTLR end "rule__Section__Group__4"


    // $ANTLR start "rule__Section__Group__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2715:1: rule__Section__Group__4__Impl : ( ( ( rule__Section__CellsAssignment_4 ) ) ( ( rule__Section__CellsAssignment_4 )* ) ) ;
    public final void rule__Section__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2719:1: ( ( ( ( rule__Section__CellsAssignment_4 ) ) ( ( rule__Section__CellsAssignment_4 )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2720:1: ( ( ( rule__Section__CellsAssignment_4 ) ) ( ( rule__Section__CellsAssignment_4 )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2720:1: ( ( ( rule__Section__CellsAssignment_4 ) ) ( ( rule__Section__CellsAssignment_4 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2721:1: ( ( rule__Section__CellsAssignment_4 ) ) ( ( rule__Section__CellsAssignment_4 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2721:1: ( ( rule__Section__CellsAssignment_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2722:1: ( rule__Section__CellsAssignment_4 )
            {
             before(grammarAccess.getSectionAccess().getCellsAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2723:1: ( rule__Section__CellsAssignment_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2723:2: rule__Section__CellsAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__CellsAssignment_4_in_rule__Section__Group__4__Impl5482);
            rule__Section__CellsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSectionAccess().getCellsAssignment_4()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2726:1: ( ( rule__Section__CellsAssignment_4 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2727:1: ( rule__Section__CellsAssignment_4 )*
            {
             before(grammarAccess.getSectionAccess().getCellsAssignment_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2728:1: ( rule__Section__CellsAssignment_4 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==37) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2728:2: rule__Section__CellsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Section__CellsAssignment_4_in_rule__Section__Group__4__Impl5494);
            	    rule__Section__CellsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getSectionAccess().getCellsAssignment_4()); 

            }


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
    // $ANTLR end "rule__Section__Group__4__Impl"


    // $ANTLR start "rule__Section__Group__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2739:1: rule__Section__Group__5 : rule__Section__Group__5__Impl ;
    public final void rule__Section__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2743:1: ( rule__Section__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2744:2: rule__Section__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group__5__Impl_in_rule__Section__Group__55527);
            rule__Section__Group__5__Impl();

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
    // $ANTLR end "rule__Section__Group__5"


    // $ANTLR start "rule__Section__Group__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2750:1: rule__Section__Group__5__Impl : ( '}' ) ;
    public final void rule__Section__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2754:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2755:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2755:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2756:1: '}'
            {
             before(grammarAccess.getSectionAccess().getRightCurlyBracketKeyword_5()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Section__Group__5__Impl5555); 
             after(grammarAccess.getSectionAccess().getRightCurlyBracketKeyword_5()); 

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
    // $ANTLR end "rule__Section__Group__5__Impl"


    // $ANTLR start "rule__Section__Group_3__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2781:1: rule__Section__Group_3__0 : rule__Section__Group_3__0__Impl rule__Section__Group_3__1 ;
    public final void rule__Section__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2785:1: ( rule__Section__Group_3__0__Impl rule__Section__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2786:2: rule__Section__Group_3__0__Impl rule__Section__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group_3__0__Impl_in_rule__Section__Group_3__05598);
            rule__Section__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Section__Group_3__1_in_rule__Section__Group_3__05601);
            rule__Section__Group_3__1();

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
    // $ANTLR end "rule__Section__Group_3__0"


    // $ANTLR start "rule__Section__Group_3__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2793:1: rule__Section__Group_3__0__Impl : ( 'title:' ) ;
    public final void rule__Section__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2797:1: ( ( 'title:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2798:1: ( 'title:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2798:1: ( 'title:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2799:1: 'title:'
            {
             before(grammarAccess.getSectionAccess().getTitleKeyword_3_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Section__Group_3__0__Impl5629); 
             after(grammarAccess.getSectionAccess().getTitleKeyword_3_0()); 

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
    // $ANTLR end "rule__Section__Group_3__0__Impl"


    // $ANTLR start "rule__Section__Group_3__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2812:1: rule__Section__Group_3__1 : rule__Section__Group_3__1__Impl ;
    public final void rule__Section__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2816:1: ( rule__Section__Group_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2817:2: rule__Section__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__Group_3__1__Impl_in_rule__Section__Group_3__15660);
            rule__Section__Group_3__1__Impl();

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
    // $ANTLR end "rule__Section__Group_3__1"


    // $ANTLR start "rule__Section__Group_3__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2823:1: rule__Section__Group_3__1__Impl : ( ( rule__Section__TitleAssignment_3_1 ) ) ;
    public final void rule__Section__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2827:1: ( ( ( rule__Section__TitleAssignment_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2828:1: ( ( rule__Section__TitleAssignment_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2828:1: ( ( rule__Section__TitleAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2829:1: ( rule__Section__TitleAssignment_3_1 )
            {
             before(grammarAccess.getSectionAccess().getTitleAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2830:1: ( rule__Section__TitleAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2830:2: rule__Section__TitleAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Section__TitleAssignment_3_1_in_rule__Section__Group_3__1__Impl5687);
            rule__Section__TitleAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSectionAccess().getTitleAssignment_3_1()); 

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
    // $ANTLR end "rule__Section__Group_3__1__Impl"


    // $ANTLR start "rule__Cell__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2844:1: rule__Cell__Group__0 : rule__Cell__Group__0__Impl rule__Cell__Group__1 ;
    public final void rule__Cell__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2848:1: ( rule__Cell__Group__0__Impl rule__Cell__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2849:2: rule__Cell__Group__0__Impl rule__Cell__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__0__Impl_in_rule__Cell__Group__05721);
            rule__Cell__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__1_in_rule__Cell__Group__05724);
            rule__Cell__Group__1();

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
    // $ANTLR end "rule__Cell__Group__0"


    // $ANTLR start "rule__Cell__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2856:1: rule__Cell__Group__0__Impl : ( 'cell' ) ;
    public final void rule__Cell__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2860:1: ( ( 'cell' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2861:1: ( 'cell' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2861:1: ( 'cell' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2862:1: 'cell'
            {
             before(grammarAccess.getCellAccess().getCellKeyword_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__Cell__Group__0__Impl5752); 
             after(grammarAccess.getCellAccess().getCellKeyword_0()); 

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
    // $ANTLR end "rule__Cell__Group__0__Impl"


    // $ANTLR start "rule__Cell__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2875:1: rule__Cell__Group__1 : rule__Cell__Group__1__Impl rule__Cell__Group__2 ;
    public final void rule__Cell__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2879:1: ( rule__Cell__Group__1__Impl rule__Cell__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2880:2: rule__Cell__Group__1__Impl rule__Cell__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__1__Impl_in_rule__Cell__Group__15783);
            rule__Cell__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__2_in_rule__Cell__Group__15786);
            rule__Cell__Group__2();

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
    // $ANTLR end "rule__Cell__Group__1"


    // $ANTLR start "rule__Cell__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2887:1: rule__Cell__Group__1__Impl : ( ( rule__Cell__TypeAssignment_1 ) ) ;
    public final void rule__Cell__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2891:1: ( ( ( rule__Cell__TypeAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2892:1: ( ( rule__Cell__TypeAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2892:1: ( ( rule__Cell__TypeAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2893:1: ( rule__Cell__TypeAssignment_1 )
            {
             before(grammarAccess.getCellAccess().getTypeAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2894:1: ( rule__Cell__TypeAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2894:2: rule__Cell__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__TypeAssignment_1_in_rule__Cell__Group__1__Impl5813);
            rule__Cell__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getTypeAssignment_1()); 

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
    // $ANTLR end "rule__Cell__Group__1__Impl"


    // $ANTLR start "rule__Cell__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2904:1: rule__Cell__Group__2 : rule__Cell__Group__2__Impl rule__Cell__Group__3 ;
    public final void rule__Cell__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2908:1: ( rule__Cell__Group__2__Impl rule__Cell__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2909:2: rule__Cell__Group__2__Impl rule__Cell__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__2__Impl_in_rule__Cell__Group__25843);
            rule__Cell__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__3_in_rule__Cell__Group__25846);
            rule__Cell__Group__3();

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
    // $ANTLR end "rule__Cell__Group__2"


    // $ANTLR start "rule__Cell__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2916:1: rule__Cell__Group__2__Impl : ( ( rule__Cell__IteratorAssignment_2 )? ) ;
    public final void rule__Cell__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2920:1: ( ( ( rule__Cell__IteratorAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2921:1: ( ( rule__Cell__IteratorAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2921:1: ( ( rule__Cell__IteratorAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2922:1: ( rule__Cell__IteratorAssignment_2 )?
            {
             before(grammarAccess.getCellAccess().getIteratorAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2923:1: ( rule__Cell__IteratorAssignment_2 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==43) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2923:2: rule__Cell__IteratorAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__IteratorAssignment_2_in_rule__Cell__Group__2__Impl5873);
                    rule__Cell__IteratorAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCellAccess().getIteratorAssignment_2()); 

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
    // $ANTLR end "rule__Cell__Group__2__Impl"


    // $ANTLR start "rule__Cell__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2933:1: rule__Cell__Group__3 : rule__Cell__Group__3__Impl rule__Cell__Group__4 ;
    public final void rule__Cell__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2937:1: ( rule__Cell__Group__3__Impl rule__Cell__Group__4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2938:2: rule__Cell__Group__3__Impl rule__Cell__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__3__Impl_in_rule__Cell__Group__35904);
            rule__Cell__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__4_in_rule__Cell__Group__35907);
            rule__Cell__Group__4();

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
    // $ANTLR end "rule__Cell__Group__3"


    // $ANTLR start "rule__Cell__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2945:1: rule__Cell__Group__3__Impl : ( '{' ) ;
    public final void rule__Cell__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2949:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2950:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2950:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2951:1: '{'
            {
             before(grammarAccess.getCellAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__Cell__Group__3__Impl5935); 
             after(grammarAccess.getCellAccess().getLeftCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__Cell__Group__3__Impl"


    // $ANTLR start "rule__Cell__Group__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2964:1: rule__Cell__Group__4 : rule__Cell__Group__4__Impl rule__Cell__Group__5 ;
    public final void rule__Cell__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2968:1: ( rule__Cell__Group__4__Impl rule__Cell__Group__5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2969:2: rule__Cell__Group__4__Impl rule__Cell__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__4__Impl_in_rule__Cell__Group__45966);
            rule__Cell__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__5_in_rule__Cell__Group__45969);
            rule__Cell__Group__5();

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
    // $ANTLR end "rule__Cell__Group__4"


    // $ANTLR start "rule__Cell__Group__4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2976:1: rule__Cell__Group__4__Impl : ( ( rule__Cell__UnorderedGroup_4 ) ) ;
    public final void rule__Cell__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2980:1: ( ( ( rule__Cell__UnorderedGroup_4 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2981:1: ( ( rule__Cell__UnorderedGroup_4 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2981:1: ( ( rule__Cell__UnorderedGroup_4 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2982:1: ( rule__Cell__UnorderedGroup_4 )
            {
             before(grammarAccess.getCellAccess().getUnorderedGroup_4()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2983:1: ( rule__Cell__UnorderedGroup_4 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2983:2: rule__Cell__UnorderedGroup_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4_in_rule__Cell__Group__4__Impl5996);
            rule__Cell__UnorderedGroup_4();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getUnorderedGroup_4()); 

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
    // $ANTLR end "rule__Cell__Group__4__Impl"


    // $ANTLR start "rule__Cell__Group__5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2993:1: rule__Cell__Group__5 : rule__Cell__Group__5__Impl ;
    public final void rule__Cell__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2997:1: ( rule__Cell__Group__5__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:2998:2: rule__Cell__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group__5__Impl_in_rule__Cell__Group__56026);
            rule__Cell__Group__5__Impl();

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
    // $ANTLR end "rule__Cell__Group__5"


    // $ANTLR start "rule__Cell__Group__5__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3004:1: rule__Cell__Group__5__Impl : ( '}' ) ;
    public final void rule__Cell__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3008:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3009:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3009:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3010:1: '}'
            {
             before(grammarAccess.getCellAccess().getRightCurlyBracketKeyword_5()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__Cell__Group__5__Impl6054); 
             after(grammarAccess.getCellAccess().getRightCurlyBracketKeyword_5()); 

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
    // $ANTLR end "rule__Cell__Group__5__Impl"


    // $ANTLR start "rule__Cell__Group_4_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3035:1: rule__Cell__Group_4_0__0 : rule__Cell__Group_4_0__0__Impl rule__Cell__Group_4_0__1 ;
    public final void rule__Cell__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3039:1: ( rule__Cell__Group_4_0__0__Impl rule__Cell__Group_4_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3040:2: rule__Cell__Group_4_0__0__Impl rule__Cell__Group_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_0__0__Impl_in_rule__Cell__Group_4_0__06097);
            rule__Cell__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_0__1_in_rule__Cell__Group_4_0__06100);
            rule__Cell__Group_4_0__1();

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
    // $ANTLR end "rule__Cell__Group_4_0__0"


    // $ANTLR start "rule__Cell__Group_4_0__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3047:1: rule__Cell__Group_4_0__0__Impl : ( 'text:' ) ;
    public final void rule__Cell__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3051:1: ( ( 'text:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3052:1: ( 'text:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3052:1: ( 'text:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3053:1: 'text:'
            {
             before(grammarAccess.getCellAccess().getTextKeyword_4_0_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__Cell__Group_4_0__0__Impl6128); 
             after(grammarAccess.getCellAccess().getTextKeyword_4_0_0()); 

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
    // $ANTLR end "rule__Cell__Group_4_0__0__Impl"


    // $ANTLR start "rule__Cell__Group_4_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3066:1: rule__Cell__Group_4_0__1 : rule__Cell__Group_4_0__1__Impl ;
    public final void rule__Cell__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3070:1: ( rule__Cell__Group_4_0__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3071:2: rule__Cell__Group_4_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_0__1__Impl_in_rule__Cell__Group_4_0__16159);
            rule__Cell__Group_4_0__1__Impl();

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
    // $ANTLR end "rule__Cell__Group_4_0__1"


    // $ANTLR start "rule__Cell__Group_4_0__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3077:1: rule__Cell__Group_4_0__1__Impl : ( ( rule__Cell__TextAssignment_4_0_1 ) ) ;
    public final void rule__Cell__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3081:1: ( ( ( rule__Cell__TextAssignment_4_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3082:1: ( ( rule__Cell__TextAssignment_4_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3082:1: ( ( rule__Cell__TextAssignment_4_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3083:1: ( rule__Cell__TextAssignment_4_0_1 )
            {
             before(grammarAccess.getCellAccess().getTextAssignment_4_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3084:1: ( rule__Cell__TextAssignment_4_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3084:2: rule__Cell__TextAssignment_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__TextAssignment_4_0_1_in_rule__Cell__Group_4_0__1__Impl6186);
            rule__Cell__TextAssignment_4_0_1();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getTextAssignment_4_0_1()); 

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
    // $ANTLR end "rule__Cell__Group_4_0__1__Impl"


    // $ANTLR start "rule__Cell__Group_4_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3098:1: rule__Cell__Group_4_1__0 : rule__Cell__Group_4_1__0__Impl rule__Cell__Group_4_1__1 ;
    public final void rule__Cell__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3102:1: ( rule__Cell__Group_4_1__0__Impl rule__Cell__Group_4_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3103:2: rule__Cell__Group_4_1__0__Impl rule__Cell__Group_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_1__0__Impl_in_rule__Cell__Group_4_1__06220);
            rule__Cell__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_1__1_in_rule__Cell__Group_4_1__06223);
            rule__Cell__Group_4_1__1();

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
    // $ANTLR end "rule__Cell__Group_4_1__0"


    // $ANTLR start "rule__Cell__Group_4_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3110:1: rule__Cell__Group_4_1__0__Impl : ( 'details:' ) ;
    public final void rule__Cell__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3114:1: ( ( 'details:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3115:1: ( 'details:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3115:1: ( 'details:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3116:1: 'details:'
            {
             before(grammarAccess.getCellAccess().getDetailsKeyword_4_1_0()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__Cell__Group_4_1__0__Impl6251); 
             after(grammarAccess.getCellAccess().getDetailsKeyword_4_1_0()); 

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
    // $ANTLR end "rule__Cell__Group_4_1__0__Impl"


    // $ANTLR start "rule__Cell__Group_4_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3129:1: rule__Cell__Group_4_1__1 : rule__Cell__Group_4_1__1__Impl ;
    public final void rule__Cell__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3133:1: ( rule__Cell__Group_4_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3134:2: rule__Cell__Group_4_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_1__1__Impl_in_rule__Cell__Group_4_1__16282);
            rule__Cell__Group_4_1__1__Impl();

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
    // $ANTLR end "rule__Cell__Group_4_1__1"


    // $ANTLR start "rule__Cell__Group_4_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3140:1: rule__Cell__Group_4_1__1__Impl : ( ( rule__Cell__DetailsAssignment_4_1_1 ) ) ;
    public final void rule__Cell__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3144:1: ( ( ( rule__Cell__DetailsAssignment_4_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3145:1: ( ( rule__Cell__DetailsAssignment_4_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3145:1: ( ( rule__Cell__DetailsAssignment_4_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3146:1: ( rule__Cell__DetailsAssignment_4_1_1 )
            {
             before(grammarAccess.getCellAccess().getDetailsAssignment_4_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3147:1: ( rule__Cell__DetailsAssignment_4_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3147:2: rule__Cell__DetailsAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__DetailsAssignment_4_1_1_in_rule__Cell__Group_4_1__1__Impl6309);
            rule__Cell__DetailsAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getDetailsAssignment_4_1_1()); 

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
    // $ANTLR end "rule__Cell__Group_4_1__1__Impl"


    // $ANTLR start "rule__Cell__Group_4_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3161:1: rule__Cell__Group_4_2__0 : rule__Cell__Group_4_2__0__Impl rule__Cell__Group_4_2__1 ;
    public final void rule__Cell__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3165:1: ( rule__Cell__Group_4_2__0__Impl rule__Cell__Group_4_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3166:2: rule__Cell__Group_4_2__0__Impl rule__Cell__Group_4_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_2__0__Impl_in_rule__Cell__Group_4_2__06343);
            rule__Cell__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_2__1_in_rule__Cell__Group_4_2__06346);
            rule__Cell__Group_4_2__1();

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
    // $ANTLR end "rule__Cell__Group_4_2__0"


    // $ANTLR start "rule__Cell__Group_4_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3173:1: rule__Cell__Group_4_2__0__Impl : ( 'image:' ) ;
    public final void rule__Cell__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3177:1: ( ( 'image:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3178:1: ( 'image:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3178:1: ( 'image:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3179:1: 'image:'
            {
             before(grammarAccess.getCellAccess().getImageKeyword_4_2_0()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__Cell__Group_4_2__0__Impl6374); 
             after(grammarAccess.getCellAccess().getImageKeyword_4_2_0()); 

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
    // $ANTLR end "rule__Cell__Group_4_2__0__Impl"


    // $ANTLR start "rule__Cell__Group_4_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3192:1: rule__Cell__Group_4_2__1 : rule__Cell__Group_4_2__1__Impl ;
    public final void rule__Cell__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3196:1: ( rule__Cell__Group_4_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3197:2: rule__Cell__Group_4_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_2__1__Impl_in_rule__Cell__Group_4_2__16405);
            rule__Cell__Group_4_2__1__Impl();

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
    // $ANTLR end "rule__Cell__Group_4_2__1"


    // $ANTLR start "rule__Cell__Group_4_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3203:1: rule__Cell__Group_4_2__1__Impl : ( ( rule__Cell__ImageAssignment_4_2_1 ) ) ;
    public final void rule__Cell__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3207:1: ( ( ( rule__Cell__ImageAssignment_4_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3208:1: ( ( rule__Cell__ImageAssignment_4_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3208:1: ( ( rule__Cell__ImageAssignment_4_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3209:1: ( rule__Cell__ImageAssignment_4_2_1 )
            {
             before(grammarAccess.getCellAccess().getImageAssignment_4_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3210:1: ( rule__Cell__ImageAssignment_4_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3210:2: rule__Cell__ImageAssignment_4_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__ImageAssignment_4_2_1_in_rule__Cell__Group_4_2__1__Impl6432);
            rule__Cell__ImageAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getImageAssignment_4_2_1()); 

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
    // $ANTLR end "rule__Cell__Group_4_2__1__Impl"


    // $ANTLR start "rule__Cell__Group_4_3__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3224:1: rule__Cell__Group_4_3__0 : rule__Cell__Group_4_3__0__Impl rule__Cell__Group_4_3__1 ;
    public final void rule__Cell__Group_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3228:1: ( rule__Cell__Group_4_3__0__Impl rule__Cell__Group_4_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3229:2: rule__Cell__Group_4_3__0__Impl rule__Cell__Group_4_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_3__0__Impl_in_rule__Cell__Group_4_3__06466);
            rule__Cell__Group_4_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_3__1_in_rule__Cell__Group_4_3__06469);
            rule__Cell__Group_4_3__1();

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
    // $ANTLR end "rule__Cell__Group_4_3__0"


    // $ANTLR start "rule__Cell__Group_4_3__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3236:1: rule__Cell__Group_4_3__0__Impl : ( 'action:' ) ;
    public final void rule__Cell__Group_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3240:1: ( ( 'action:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3241:1: ( 'action:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3241:1: ( 'action:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3242:1: 'action:'
            {
             before(grammarAccess.getCellAccess().getActionKeyword_4_3_0()); 
            match(input,41,FollowSets000.FOLLOW_41_in_rule__Cell__Group_4_3__0__Impl6497); 
             after(grammarAccess.getCellAccess().getActionKeyword_4_3_0()); 

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
    // $ANTLR end "rule__Cell__Group_4_3__0__Impl"


    // $ANTLR start "rule__Cell__Group_4_3__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3255:1: rule__Cell__Group_4_3__1 : rule__Cell__Group_4_3__1__Impl ;
    public final void rule__Cell__Group_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3259:1: ( rule__Cell__Group_4_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3260:2: rule__Cell__Group_4_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_3__1__Impl_in_rule__Cell__Group_4_3__16528);
            rule__Cell__Group_4_3__1__Impl();

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
    // $ANTLR end "rule__Cell__Group_4_3__1"


    // $ANTLR start "rule__Cell__Group_4_3__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3266:1: rule__Cell__Group_4_3__1__Impl : ( ( rule__Cell__ActionAssignment_4_3_1 ) ) ;
    public final void rule__Cell__Group_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3270:1: ( ( ( rule__Cell__ActionAssignment_4_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3271:1: ( ( rule__Cell__ActionAssignment_4_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3271:1: ( ( rule__Cell__ActionAssignment_4_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3272:1: ( rule__Cell__ActionAssignment_4_3_1 )
            {
             before(grammarAccess.getCellAccess().getActionAssignment_4_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3273:1: ( rule__Cell__ActionAssignment_4_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3273:2: rule__Cell__ActionAssignment_4_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__ActionAssignment_4_3_1_in_rule__Cell__Group_4_3__1__Impl6555);
            rule__Cell__ActionAssignment_4_3_1();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getActionAssignment_4_3_1()); 

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
    // $ANTLR end "rule__Cell__Group_4_3__1__Impl"


    // $ANTLR start "rule__Cell__Group_4_4__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3287:1: rule__Cell__Group_4_4__0 : rule__Cell__Group_4_4__0__Impl rule__Cell__Group_4_4__1 ;
    public final void rule__Cell__Group_4_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3291:1: ( rule__Cell__Group_4_4__0__Impl rule__Cell__Group_4_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3292:2: rule__Cell__Group_4_4__0__Impl rule__Cell__Group_4_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_4__0__Impl_in_rule__Cell__Group_4_4__06589);
            rule__Cell__Group_4_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_4__1_in_rule__Cell__Group_4_4__06592);
            rule__Cell__Group_4_4__1();

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
    // $ANTLR end "rule__Cell__Group_4_4__0"


    // $ANTLR start "rule__Cell__Group_4_4__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3299:1: rule__Cell__Group_4_4__0__Impl : ( 'accessory:' ) ;
    public final void rule__Cell__Group_4_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3303:1: ( ( 'accessory:' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3304:1: ( 'accessory:' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3304:1: ( 'accessory:' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3305:1: 'accessory:'
            {
             before(grammarAccess.getCellAccess().getAccessoryKeyword_4_4_0()); 
            match(input,42,FollowSets000.FOLLOW_42_in_rule__Cell__Group_4_4__0__Impl6620); 
             after(grammarAccess.getCellAccess().getAccessoryKeyword_4_4_0()); 

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
    // $ANTLR end "rule__Cell__Group_4_4__0__Impl"


    // $ANTLR start "rule__Cell__Group_4_4__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3318:1: rule__Cell__Group_4_4__1 : rule__Cell__Group_4_4__1__Impl ;
    public final void rule__Cell__Group_4_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3322:1: ( rule__Cell__Group_4_4__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3323:2: rule__Cell__Group_4_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_4__1__Impl_in_rule__Cell__Group_4_4__16651);
            rule__Cell__Group_4_4__1__Impl();

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
    // $ANTLR end "rule__Cell__Group_4_4__1"


    // $ANTLR start "rule__Cell__Group_4_4__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3329:1: rule__Cell__Group_4_4__1__Impl : ( ( rule__Cell__AccessoryAssignment_4_4_1 ) ) ;
    public final void rule__Cell__Group_4_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3333:1: ( ( ( rule__Cell__AccessoryAssignment_4_4_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3334:1: ( ( rule__Cell__AccessoryAssignment_4_4_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3334:1: ( ( rule__Cell__AccessoryAssignment_4_4_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3335:1: ( rule__Cell__AccessoryAssignment_4_4_1 )
            {
             before(grammarAccess.getCellAccess().getAccessoryAssignment_4_4_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3336:1: ( rule__Cell__AccessoryAssignment_4_4_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3336:2: rule__Cell__AccessoryAssignment_4_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__AccessoryAssignment_4_4_1_in_rule__Cell__Group_4_4__1__Impl6678);
            rule__Cell__AccessoryAssignment_4_4_1();

            state._fsp--;


            }

             after(grammarAccess.getCellAccess().getAccessoryAssignment_4_4_1()); 

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
    // $ANTLR end "rule__Cell__Group_4_4__1__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3350:1: rule__CollectionIterator__Group__0 : rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 ;
    public final void rule__CollectionIterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3354:1: ( rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3355:2: rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__0__Impl_in_rule__CollectionIterator__Group__06712);
            rule__CollectionIterator__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__1_in_rule__CollectionIterator__Group__06715);
            rule__CollectionIterator__Group__1();

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
    // $ANTLR end "rule__CollectionIterator__Group__0"


    // $ANTLR start "rule__CollectionIterator__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3362:1: rule__CollectionIterator__Group__0__Impl : ( 'for' ) ;
    public final void rule__CollectionIterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3366:1: ( ( 'for' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3367:1: ( 'for' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3367:1: ( 'for' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3368:1: 'for'
            {
             before(grammarAccess.getCollectionIteratorAccess().getForKeyword_0()); 
            match(input,43,FollowSets000.FOLLOW_43_in_rule__CollectionIterator__Group__0__Impl6743); 
             after(grammarAccess.getCollectionIteratorAccess().getForKeyword_0()); 

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
    // $ANTLR end "rule__CollectionIterator__Group__0__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3381:1: rule__CollectionIterator__Group__1 : rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 ;
    public final void rule__CollectionIterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3385:1: ( rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3386:2: rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__1__Impl_in_rule__CollectionIterator__Group__16774);
            rule__CollectionIterator__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__2_in_rule__CollectionIterator__Group__16777);
            rule__CollectionIterator__Group__2();

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
    // $ANTLR end "rule__CollectionIterator__Group__1"


    // $ANTLR start "rule__CollectionIterator__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3393:1: rule__CollectionIterator__Group__1__Impl : ( ( rule__CollectionIterator__NameAssignment_1 ) ) ;
    public final void rule__CollectionIterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3397:1: ( ( ( rule__CollectionIterator__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3398:1: ( ( rule__CollectionIterator__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3398:1: ( ( rule__CollectionIterator__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3399:1: ( rule__CollectionIterator__NameAssignment_1 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3400:1: ( rule__CollectionIterator__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3400:2: rule__CollectionIterator__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__NameAssignment_1_in_rule__CollectionIterator__Group__1__Impl6804);
            rule__CollectionIterator__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionIteratorAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__CollectionIterator__Group__1__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3410:1: rule__CollectionIterator__Group__2 : rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 ;
    public final void rule__CollectionIterator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3414:1: ( rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3415:2: rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__2__Impl_in_rule__CollectionIterator__Group__26834);
            rule__CollectionIterator__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__3_in_rule__CollectionIterator__Group__26837);
            rule__CollectionIterator__Group__3();

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
    // $ANTLR end "rule__CollectionIterator__Group__2"


    // $ANTLR start "rule__CollectionIterator__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3422:1: rule__CollectionIterator__Group__2__Impl : ( 'in' ) ;
    public final void rule__CollectionIterator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3426:1: ( ( 'in' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3427:1: ( 'in' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3427:1: ( 'in' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3428:1: 'in'
            {
             before(grammarAccess.getCollectionIteratorAccess().getInKeyword_2()); 
            match(input,44,FollowSets000.FOLLOW_44_in_rule__CollectionIterator__Group__2__Impl6865); 
             after(grammarAccess.getCollectionIteratorAccess().getInKeyword_2()); 

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
    // $ANTLR end "rule__CollectionIterator__Group__2__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3441:1: rule__CollectionIterator__Group__3 : rule__CollectionIterator__Group__3__Impl ;
    public final void rule__CollectionIterator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3445:1: ( rule__CollectionIterator__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3446:2: rule__CollectionIterator__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__Group__3__Impl_in_rule__CollectionIterator__Group__36896);
            rule__CollectionIterator__Group__3__Impl();

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
    // $ANTLR end "rule__CollectionIterator__Group__3"


    // $ANTLR start "rule__CollectionIterator__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3452:1: rule__CollectionIterator__Group__3__Impl : ( ( rule__CollectionIterator__CollectionAssignment_3 ) ) ;
    public final void rule__CollectionIterator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3456:1: ( ( ( rule__CollectionIterator__CollectionAssignment_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3457:1: ( ( rule__CollectionIterator__CollectionAssignment_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3457:1: ( ( rule__CollectionIterator__CollectionAssignment_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3458:1: ( rule__CollectionIterator__CollectionAssignment_3 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getCollectionAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3459:1: ( rule__CollectionIterator__CollectionAssignment_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3459:2: rule__CollectionIterator__CollectionAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CollectionIterator__CollectionAssignment_3_in_rule__CollectionIterator__Group__3__Impl6923);
            rule__CollectionIterator__CollectionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCollectionIteratorAccess().getCollectionAssignment_3()); 

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
    // $ANTLR end "rule__CollectionIterator__Group__3__Impl"


    // $ANTLR start "rule__SelectorName__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3477:1: rule__SelectorName__Group__0 : rule__SelectorName__Group__0__Impl rule__SelectorName__Group__1 ;
    public final void rule__SelectorName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3481:1: ( rule__SelectorName__Group__0__Impl rule__SelectorName__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3482:2: rule__SelectorName__Group__0__Impl rule__SelectorName__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group__0__Impl_in_rule__SelectorName__Group__06961);
            rule__SelectorName__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group__1_in_rule__SelectorName__Group__06964);
            rule__SelectorName__Group__1();

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
    // $ANTLR end "rule__SelectorName__Group__0"


    // $ANTLR start "rule__SelectorName__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3489:1: rule__SelectorName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__SelectorName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3493:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3494:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3494:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3495:1: RULE_ID
            {
             before(grammarAccess.getSelectorNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SelectorName__Group__0__Impl6991); 
             after(grammarAccess.getSelectorNameAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__SelectorName__Group__0__Impl"


    // $ANTLR start "rule__SelectorName__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3506:1: rule__SelectorName__Group__1 : rule__SelectorName__Group__1__Impl rule__SelectorName__Group__2 ;
    public final void rule__SelectorName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3510:1: ( rule__SelectorName__Group__1__Impl rule__SelectorName__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3511:2: rule__SelectorName__Group__1__Impl rule__SelectorName__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group__1__Impl_in_rule__SelectorName__Group__17020);
            rule__SelectorName__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group__2_in_rule__SelectorName__Group__17023);
            rule__SelectorName__Group__2();

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
    // $ANTLR end "rule__SelectorName__Group__1"


    // $ANTLR start "rule__SelectorName__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3518:1: rule__SelectorName__Group__1__Impl : ( ( rule__SelectorName__Group_1__0 )* ) ;
    public final void rule__SelectorName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3522:1: ( ( ( rule__SelectorName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3523:1: ( ( rule__SelectorName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3523:1: ( ( rule__SelectorName__Group_1__0 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3524:1: ( rule__SelectorName__Group_1__0 )*
            {
             before(grammarAccess.getSelectorNameAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3525:1: ( rule__SelectorName__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==45) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==RULE_ID) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3525:2: rule__SelectorName__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group_1__0_in_rule__SelectorName__Group__1__Impl7050);
            	    rule__SelectorName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getSelectorNameAccess().getGroup_1()); 

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
    // $ANTLR end "rule__SelectorName__Group__1__Impl"


    // $ANTLR start "rule__SelectorName__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3535:1: rule__SelectorName__Group__2 : rule__SelectorName__Group__2__Impl ;
    public final void rule__SelectorName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3539:1: ( rule__SelectorName__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3540:2: rule__SelectorName__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group__2__Impl_in_rule__SelectorName__Group__27081);
            rule__SelectorName__Group__2__Impl();

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
    // $ANTLR end "rule__SelectorName__Group__2"


    // $ANTLR start "rule__SelectorName__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3546:1: rule__SelectorName__Group__2__Impl : ( ( ':' )? ) ;
    public final void rule__SelectorName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3550:1: ( ( ( ':' )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3551:1: ( ( ':' )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3551:1: ( ( ':' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3552:1: ( ':' )?
            {
             before(grammarAccess.getSelectorNameAccess().getColonKeyword_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3553:1: ( ':' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==45) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3554:2: ':'
                    {
                    match(input,45,FollowSets000.FOLLOW_45_in_rule__SelectorName__Group__2__Impl7110); 

                    }
                    break;

            }

             after(grammarAccess.getSelectorNameAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__SelectorName__Group__2__Impl"


    // $ANTLR start "rule__SelectorName__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3571:1: rule__SelectorName__Group_1__0 : rule__SelectorName__Group_1__0__Impl rule__SelectorName__Group_1__1 ;
    public final void rule__SelectorName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3575:1: ( rule__SelectorName__Group_1__0__Impl rule__SelectorName__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3576:2: rule__SelectorName__Group_1__0__Impl rule__SelectorName__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group_1__0__Impl_in_rule__SelectorName__Group_1__07149);
            rule__SelectorName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group_1__1_in_rule__SelectorName__Group_1__07152);
            rule__SelectorName__Group_1__1();

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
    // $ANTLR end "rule__SelectorName__Group_1__0"


    // $ANTLR start "rule__SelectorName__Group_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3583:1: rule__SelectorName__Group_1__0__Impl : ( ':' ) ;
    public final void rule__SelectorName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3587:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3588:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3588:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3589:1: ':'
            {
             before(grammarAccess.getSelectorNameAccess().getColonKeyword_1_0()); 
            match(input,45,FollowSets000.FOLLOW_45_in_rule__SelectorName__Group_1__0__Impl7180); 
             after(grammarAccess.getSelectorNameAccess().getColonKeyword_1_0()); 

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
    // $ANTLR end "rule__SelectorName__Group_1__0__Impl"


    // $ANTLR start "rule__SelectorName__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3602:1: rule__SelectorName__Group_1__1 : rule__SelectorName__Group_1__1__Impl ;
    public final void rule__SelectorName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3606:1: ( rule__SelectorName__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3607:2: rule__SelectorName__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__SelectorName__Group_1__1__Impl_in_rule__SelectorName__Group_1__17211);
            rule__SelectorName__Group_1__1__Impl();

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
    // $ANTLR end "rule__SelectorName__Group_1__1"


    // $ANTLR start "rule__SelectorName__Group_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3613:1: rule__SelectorName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__SelectorName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3617:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3618:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3618:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3619:1: RULE_ID
            {
             before(grammarAccess.getSelectorNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__SelectorName__Group_1__1__Impl7238); 
             after(grammarAccess.getSelectorNameAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__SelectorName__Group_1__1__Impl"


    // $ANTLR start "rule__Selector__Group__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3634:1: rule__Selector__Group__0 : rule__Selector__Group__0__Impl rule__Selector__Group__1 ;
    public final void rule__Selector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3638:1: ( rule__Selector__Group__0__Impl rule__Selector__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3639:2: rule__Selector__Group__0__Impl rule__Selector__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__0__Impl_in_rule__Selector__Group__07271);
            rule__Selector__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__1_in_rule__Selector__Group__07274);
            rule__Selector__Group__1();

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
    // $ANTLR end "rule__Selector__Group__0"


    // $ANTLR start "rule__Selector__Group__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3646:1: rule__Selector__Group__0__Impl : ( '@selector' ) ;
    public final void rule__Selector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3650:1: ( ( '@selector' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3651:1: ( '@selector' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3651:1: ( '@selector' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3652:1: '@selector'
            {
             before(grammarAccess.getSelectorAccess().getSelectorKeyword_0()); 
            match(input,46,FollowSets000.FOLLOW_46_in_rule__Selector__Group__0__Impl7302); 
             after(grammarAccess.getSelectorAccess().getSelectorKeyword_0()); 

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
    // $ANTLR end "rule__Selector__Group__0__Impl"


    // $ANTLR start "rule__Selector__Group__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3665:1: rule__Selector__Group__1 : rule__Selector__Group__1__Impl rule__Selector__Group__2 ;
    public final void rule__Selector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3669:1: ( rule__Selector__Group__1__Impl rule__Selector__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3670:2: rule__Selector__Group__1__Impl rule__Selector__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__1__Impl_in_rule__Selector__Group__17333);
            rule__Selector__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__2_in_rule__Selector__Group__17336);
            rule__Selector__Group__2();

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
    // $ANTLR end "rule__Selector__Group__1"


    // $ANTLR start "rule__Selector__Group__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3677:1: rule__Selector__Group__1__Impl : ( '(' ) ;
    public final void rule__Selector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3681:1: ( ( '(' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3682:1: ( '(' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3682:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3683:1: '('
            {
             before(grammarAccess.getSelectorAccess().getLeftParenthesisKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Selector__Group__1__Impl7364); 
             after(grammarAccess.getSelectorAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end "rule__Selector__Group__1__Impl"


    // $ANTLR start "rule__Selector__Group__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3696:1: rule__Selector__Group__2 : rule__Selector__Group__2__Impl rule__Selector__Group__3 ;
    public final void rule__Selector__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3700:1: ( rule__Selector__Group__2__Impl rule__Selector__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3701:2: rule__Selector__Group__2__Impl rule__Selector__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__2__Impl_in_rule__Selector__Group__27395);
            rule__Selector__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__3_in_rule__Selector__Group__27398);
            rule__Selector__Group__3();

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
    // $ANTLR end "rule__Selector__Group__2"


    // $ANTLR start "rule__Selector__Group__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3708:1: rule__Selector__Group__2__Impl : ( ( rule__Selector__NameAssignment_2 ) ) ;
    public final void rule__Selector__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3712:1: ( ( ( rule__Selector__NameAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3713:1: ( ( rule__Selector__NameAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3713:1: ( ( rule__Selector__NameAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3714:1: ( rule__Selector__NameAssignment_2 )
            {
             before(grammarAccess.getSelectorAccess().getNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3715:1: ( rule__Selector__NameAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3715:2: rule__Selector__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Selector__NameAssignment_2_in_rule__Selector__Group__2__Impl7425);
            rule__Selector__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSelectorAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Selector__Group__2__Impl"


    // $ANTLR start "rule__Selector__Group__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3725:1: rule__Selector__Group__3 : rule__Selector__Group__3__Impl ;
    public final void rule__Selector__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3729:1: ( rule__Selector__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3730:2: rule__Selector__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Selector__Group__3__Impl_in_rule__Selector__Group__37455);
            rule__Selector__Group__3__Impl();

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
    // $ANTLR end "rule__Selector__Group__3"


    // $ANTLR start "rule__Selector__Group__3__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3736:1: rule__Selector__Group__3__Impl : ( ')' ) ;
    public final void rule__Selector__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3740:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3741:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3741:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3742:1: ')'
            {
             before(grammarAccess.getSelectorAccess().getRightParenthesisKeyword_3()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Selector__Group__3__Impl7483); 
             after(grammarAccess.getSelectorAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__Selector__Group__3__Impl"


    // $ANTLR start "rule__TableView__UnorderedGroup_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3764:1: rule__TableView__UnorderedGroup_4 : ( rule__TableView__UnorderedGroup_4__0 )? ;
    public final void rule__TableView__UnorderedGroup_4() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3769:1: ( ( rule__TableView__UnorderedGroup_4__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3770:2: ( rule__TableView__UnorderedGroup_4__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3770:2: ( rule__TableView__UnorderedGroup_4__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( LA22_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0) ) {
                alt22=1;
            }
            else if ( LA22_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1) ) {
                alt22=1;
            }
            else if ( LA22_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3770:2: rule__TableView__UnorderedGroup_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TableView__UnorderedGroup_4__0_in_rule__TableView__UnorderedGroup_47523);
                    rule__TableView__UnorderedGroup_4__0();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableView__UnorderedGroup_4"


    // $ANTLR start "rule__TableView__UnorderedGroup_4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3780:1: rule__TableView__UnorderedGroup_4__Impl : ( ({...}? => ( ( ( rule__TableView__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_2__0 ) ) ) ) ) ;
    public final void rule__TableView__UnorderedGroup_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3785:1: ( ( ({...}? => ( ( ( rule__TableView__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_2__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3786:3: ( ({...}? => ( ( ( rule__TableView__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_2__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3786:3: ( ({...}? => ( ( ( rule__TableView__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__TableView__Group_4_2__0 ) ) ) ) )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( LA23_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0) ) {
                alt23=1;
            }
            else if ( LA23_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1) ) {
                alt23=2;
            }
            else if ( LA23_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2) ) {
                alt23=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3788:4: ({...}? => ( ( ( rule__TableView__Group_4_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3788:4: ({...}? => ( ( ( rule__TableView__Group_4_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3789:5: {...}? => ( ( ( rule__TableView__Group_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__TableView__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3789:106: ( ( ( rule__TableView__Group_4_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3790:6: ( ( rule__TableView__Group_4_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3796:6: ( ( rule__TableView__Group_4_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3798:7: ( rule__TableView__Group_4_0__0 )
                    {
                     before(grammarAccess.getTableViewAccess().getGroup_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3799:7: ( rule__TableView__Group_4_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3799:8: rule__TableView__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_0__0_in_rule__TableView__UnorderedGroup_4__Impl7610);
                    rule__TableView__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableViewAccess().getGroup_4_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3805:4: ({...}? => ( ( ( rule__TableView__Group_4_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3805:4: ({...}? => ( ( ( rule__TableView__Group_4_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3806:5: {...}? => ( ( ( rule__TableView__Group_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__TableView__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3806:106: ( ( ( rule__TableView__Group_4_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3807:6: ( ( rule__TableView__Group_4_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3813:6: ( ( rule__TableView__Group_4_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3815:7: ( rule__TableView__Group_4_1__0 )
                    {
                     before(grammarAccess.getTableViewAccess().getGroup_4_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3816:7: ( rule__TableView__Group_4_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3816:8: rule__TableView__Group_4_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_1__0_in_rule__TableView__UnorderedGroup_4__Impl7701);
                    rule__TableView__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableViewAccess().getGroup_4_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3822:4: ({...}? => ( ( ( rule__TableView__Group_4_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3822:4: ({...}? => ( ( ( rule__TableView__Group_4_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3823:5: {...}? => ( ( ( rule__TableView__Group_4_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2) ) {
                        throw new FailedPredicateException(input, "rule__TableView__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3823:106: ( ( ( rule__TableView__Group_4_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3824:6: ( ( rule__TableView__Group_4_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3830:6: ( ( rule__TableView__Group_4_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3832:7: ( rule__TableView__Group_4_2__0 )
                    {
                     before(grammarAccess.getTableViewAccess().getGroup_4_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3833:7: ( rule__TableView__Group_4_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3833:8: rule__TableView__Group_4_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TableView__Group_4_2__0_in_rule__TableView__UnorderedGroup_4__Impl7792);
                    rule__TableView__Group_4_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableViewAccess().getGroup_4_2()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTableViewAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableView__UnorderedGroup_4__Impl"


    // $ANTLR start "rule__TableView__UnorderedGroup_4__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3848:1: rule__TableView__UnorderedGroup_4__0 : rule__TableView__UnorderedGroup_4__Impl ( rule__TableView__UnorderedGroup_4__1 )? ;
    public final void rule__TableView__UnorderedGroup_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3852:1: ( rule__TableView__UnorderedGroup_4__Impl ( rule__TableView__UnorderedGroup_4__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3853:2: rule__TableView__UnorderedGroup_4__Impl ( rule__TableView__UnorderedGroup_4__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__UnorderedGroup_4__Impl_in_rule__TableView__UnorderedGroup_4__07851);
            rule__TableView__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3854:2: ( rule__TableView__UnorderedGroup_4__1 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( LA24_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0) ) {
                alt24=1;
            }
            else if ( LA24_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1) ) {
                alt24=1;
            }
            else if ( LA24_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3854:2: rule__TableView__UnorderedGroup_4__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TableView__UnorderedGroup_4__1_in_rule__TableView__UnorderedGroup_4__07854);
                    rule__TableView__UnorderedGroup_4__1();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__TableView__UnorderedGroup_4__0"


    // $ANTLR start "rule__TableView__UnorderedGroup_4__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3861:1: rule__TableView__UnorderedGroup_4__1 : rule__TableView__UnorderedGroup_4__Impl ( rule__TableView__UnorderedGroup_4__2 )? ;
    public final void rule__TableView__UnorderedGroup_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3865:1: ( rule__TableView__UnorderedGroup_4__Impl ( rule__TableView__UnorderedGroup_4__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3866:2: rule__TableView__UnorderedGroup_4__Impl ( rule__TableView__UnorderedGroup_4__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__UnorderedGroup_4__Impl_in_rule__TableView__UnorderedGroup_4__17879);
            rule__TableView__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3867:2: ( rule__TableView__UnorderedGroup_4__2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( LA25_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 0) ) {
                alt25=1;
            }
            else if ( LA25_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 1) ) {
                alt25=1;
            }
            else if ( LA25_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), 2) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3867:2: rule__TableView__UnorderedGroup_4__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__TableView__UnorderedGroup_4__2_in_rule__TableView__UnorderedGroup_4__17882);
                    rule__TableView__UnorderedGroup_4__2();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__TableView__UnorderedGroup_4__1"


    // $ANTLR start "rule__TableView__UnorderedGroup_4__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3874:1: rule__TableView__UnorderedGroup_4__2 : rule__TableView__UnorderedGroup_4__Impl ;
    public final void rule__TableView__UnorderedGroup_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3878:1: ( rule__TableView__UnorderedGroup_4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3879:2: rule__TableView__UnorderedGroup_4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TableView__UnorderedGroup_4__Impl_in_rule__TableView__UnorderedGroup_4__27907);
            rule__TableView__UnorderedGroup_4__Impl();

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
    // $ANTLR end "rule__TableView__UnorderedGroup_4__2"


    // $ANTLR start "rule__Cell__UnorderedGroup_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3892:1: rule__Cell__UnorderedGroup_4 : ( rule__Cell__UnorderedGroup_4__0 )? ;
    public final void rule__Cell__UnorderedGroup_4() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getCellAccess().getUnorderedGroup_4());
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3897:1: ( ( rule__Cell__UnorderedGroup_4__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3898:2: ( rule__Cell__UnorderedGroup_4__0 )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3898:2: ( rule__Cell__UnorderedGroup_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( LA26_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                alt26=1;
            }
            else if ( LA26_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                alt26=1;
            }
            else if ( LA26_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                alt26=1;
            }
            else if ( LA26_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                alt26=1;
            }
            else if ( LA26_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3898:2: rule__Cell__UnorderedGroup_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__0_in_rule__Cell__UnorderedGroup_47937);
                    rule__Cell__UnorderedGroup_4__0();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cell__UnorderedGroup_4"


    // $ANTLR start "rule__Cell__UnorderedGroup_4__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3908:1: rule__Cell__UnorderedGroup_4__Impl : ( ({...}? => ( ( ( rule__Cell__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_4__0 ) ) ) ) ) ;
    public final void rule__Cell__UnorderedGroup_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3913:1: ( ( ({...}? => ( ( ( rule__Cell__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_4__0 ) ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3914:3: ( ({...}? => ( ( ( rule__Cell__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_4__0 ) ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3914:3: ( ({...}? => ( ( ( rule__Cell__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Cell__Group_4_4__0 ) ) ) ) )
            int alt27=5;
            int LA27_0 = input.LA(1);

            if ( LA27_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                alt27=1;
            }
            else if ( LA27_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                alt27=2;
            }
            else if ( LA27_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                alt27=3;
            }
            else if ( LA27_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                alt27=4;
            }
            else if ( LA27_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                alt27=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3916:4: ({...}? => ( ( ( rule__Cell__Group_4_0__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3916:4: ({...}? => ( ( ( rule__Cell__Group_4_0__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3917:5: {...}? => ( ( ( rule__Cell__Group_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Cell__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3917:101: ( ( ( rule__Cell__Group_4_0__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3918:6: ( ( rule__Cell__Group_4_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3924:6: ( ( rule__Cell__Group_4_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3926:7: ( rule__Cell__Group_4_0__0 )
                    {
                     before(grammarAccess.getCellAccess().getGroup_4_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3927:7: ( rule__Cell__Group_4_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3927:8: rule__Cell__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_0__0_in_rule__Cell__UnorderedGroup_4__Impl8024);
                    rule__Cell__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCellAccess().getGroup_4_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3933:4: ({...}? => ( ( ( rule__Cell__Group_4_1__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3933:4: ({...}? => ( ( ( rule__Cell__Group_4_1__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3934:5: {...}? => ( ( ( rule__Cell__Group_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Cell__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3934:101: ( ( ( rule__Cell__Group_4_1__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3935:6: ( ( rule__Cell__Group_4_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3941:6: ( ( rule__Cell__Group_4_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3943:7: ( rule__Cell__Group_4_1__0 )
                    {
                     before(grammarAccess.getCellAccess().getGroup_4_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3944:7: ( rule__Cell__Group_4_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3944:8: rule__Cell__Group_4_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_1__0_in_rule__Cell__UnorderedGroup_4__Impl8115);
                    rule__Cell__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCellAccess().getGroup_4_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3950:4: ({...}? => ( ( ( rule__Cell__Group_4_2__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3950:4: ({...}? => ( ( ( rule__Cell__Group_4_2__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3951:5: {...}? => ( ( ( rule__Cell__Group_4_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Cell__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3951:101: ( ( ( rule__Cell__Group_4_2__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3952:6: ( ( rule__Cell__Group_4_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3958:6: ( ( rule__Cell__Group_4_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3960:7: ( rule__Cell__Group_4_2__0 )
                    {
                     before(grammarAccess.getCellAccess().getGroup_4_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3961:7: ( rule__Cell__Group_4_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3961:8: rule__Cell__Group_4_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_2__0_in_rule__Cell__UnorderedGroup_4__Impl8206);
                    rule__Cell__Group_4_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCellAccess().getGroup_4_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3967:4: ({...}? => ( ( ( rule__Cell__Group_4_3__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3967:4: ({...}? => ( ( ( rule__Cell__Group_4_3__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3968:5: {...}? => ( ( ( rule__Cell__Group_4_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Cell__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3968:101: ( ( ( rule__Cell__Group_4_3__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3969:6: ( ( rule__Cell__Group_4_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3975:6: ( ( rule__Cell__Group_4_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3977:7: ( rule__Cell__Group_4_3__0 )
                    {
                     before(grammarAccess.getCellAccess().getGroup_4_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3978:7: ( rule__Cell__Group_4_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3978:8: rule__Cell__Group_4_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_3__0_in_rule__Cell__UnorderedGroup_4__Impl8297);
                    rule__Cell__Group_4_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCellAccess().getGroup_4_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3984:4: ({...}? => ( ( ( rule__Cell__Group_4_4__0 ) ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3984:4: ({...}? => ( ( ( rule__Cell__Group_4_4__0 ) ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3985:5: {...}? => ( ( ( rule__Cell__Group_4_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Cell__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4)");
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3985:101: ( ( ( rule__Cell__Group_4_4__0 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3986:6: ( ( rule__Cell__Group_4_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3992:6: ( ( rule__Cell__Group_4_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3994:7: ( rule__Cell__Group_4_4__0 )
                    {
                     before(grammarAccess.getCellAccess().getGroup_4_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3995:7: ( rule__Cell__Group_4_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:3995:8: rule__Cell__Group_4_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__Group_4_4__0_in_rule__Cell__UnorderedGroup_4__Impl8388);
                    rule__Cell__Group_4_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCellAccess().getGroup_4_4()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCellAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cell__UnorderedGroup_4__Impl"


    // $ANTLR start "rule__Cell__UnorderedGroup_4__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4010:1: rule__Cell__UnorderedGroup_4__0 : rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__1 )? ;
    public final void rule__Cell__UnorderedGroup_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4014:1: ( rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__1 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4015:2: rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__08447);
            rule__Cell__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4016:2: ( rule__Cell__UnorderedGroup_4__1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( LA28_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                alt28=1;
            }
            else if ( LA28_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                alt28=1;
            }
            else if ( LA28_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                alt28=1;
            }
            else if ( LA28_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                alt28=1;
            }
            else if ( LA28_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4016:2: rule__Cell__UnorderedGroup_4__1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__1_in_rule__Cell__UnorderedGroup_4__08450);
                    rule__Cell__UnorderedGroup_4__1();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__Cell__UnorderedGroup_4__0"


    // $ANTLR start "rule__Cell__UnorderedGroup_4__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4023:1: rule__Cell__UnorderedGroup_4__1 : rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__2 )? ;
    public final void rule__Cell__UnorderedGroup_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4027:1: ( rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4028:2: rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__18475);
            rule__Cell__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4029:2: ( rule__Cell__UnorderedGroup_4__2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( LA29_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                alt29=1;
            }
            else if ( LA29_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                alt29=1;
            }
            else if ( LA29_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                alt29=1;
            }
            else if ( LA29_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                alt29=1;
            }
            else if ( LA29_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4029:2: rule__Cell__UnorderedGroup_4__2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__2_in_rule__Cell__UnorderedGroup_4__18478);
                    rule__Cell__UnorderedGroup_4__2();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__Cell__UnorderedGroup_4__1"


    // $ANTLR start "rule__Cell__UnorderedGroup_4__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4036:1: rule__Cell__UnorderedGroup_4__2 : rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__3 )? ;
    public final void rule__Cell__UnorderedGroup_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4040:1: ( rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4041:2: rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__28503);
            rule__Cell__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4042:2: ( rule__Cell__UnorderedGroup_4__3 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( LA30_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                alt30=1;
            }
            else if ( LA30_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                alt30=1;
            }
            else if ( LA30_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                alt30=1;
            }
            else if ( LA30_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                alt30=1;
            }
            else if ( LA30_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4042:2: rule__Cell__UnorderedGroup_4__3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__3_in_rule__Cell__UnorderedGroup_4__28506);
                    rule__Cell__UnorderedGroup_4__3();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__Cell__UnorderedGroup_4__2"


    // $ANTLR start "rule__Cell__UnorderedGroup_4__3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4049:1: rule__Cell__UnorderedGroup_4__3 : rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__4 )? ;
    public final void rule__Cell__UnorderedGroup_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4053:1: ( rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__4 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4054:2: rule__Cell__UnorderedGroup_4__Impl ( rule__Cell__UnorderedGroup_4__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__38531);
            rule__Cell__UnorderedGroup_4__Impl();

            state._fsp--;

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4055:2: ( rule__Cell__UnorderedGroup_4__4 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( LA31_0 == 38 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 0) ) {
                alt31=1;
            }
            else if ( LA31_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 1) ) {
                alt31=1;
            }
            else if ( LA31_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 2) ) {
                alt31=1;
            }
            else if ( LA31_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 3) ) {
                alt31=1;
            }
            else if ( LA31_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getCellAccess().getUnorderedGroup_4(), 4) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4055:2: rule__Cell__UnorderedGroup_4__4
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__4_in_rule__Cell__UnorderedGroup_4__38534);
                    rule__Cell__UnorderedGroup_4__4();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "rule__Cell__UnorderedGroup_4__3"


    // $ANTLR start "rule__Cell__UnorderedGroup_4__4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4062:1: rule__Cell__UnorderedGroup_4__4 : rule__Cell__UnorderedGroup_4__Impl ;
    public final void rule__Cell__UnorderedGroup_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4066:1: ( rule__Cell__UnorderedGroup_4__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4067:2: rule__Cell__UnorderedGroup_4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__48559);
            rule__Cell__UnorderedGroup_4__Impl();

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
    // $ANTLR end "rule__Cell__UnorderedGroup_4__4"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4084:1: rule__Model__ElementsAssignment : ( ruleTableView ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4088:1: ( ( ruleTableView ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4089:1: ( ruleTableView )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4089:1: ( ruleTableView )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4090:1: ruleTableView
            {
             before(grammarAccess.getModelAccess().getElementsTableViewParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTableView_in_rule__Model__ElementsAssignment8597);
            ruleTableView();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsTableViewParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__TypeDescription__TypeAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4099:1: rule__TypeDescription__TypeAssignment_0 : ( RULE_ID ) ;
    public final void rule__TypeDescription__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4103:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4104:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4104:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4105:1: RULE_ID
            {
             before(grammarAccess.getTypeDescriptionAccess().getTypeIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TypeDescription__TypeAssignment_08628); 
             after(grammarAccess.getTypeDescriptionAccess().getTypeIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__TypeDescription__TypeAssignment_0"


    // $ANTLR start "rule__TypeDescription__ManyAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4114:1: rule__TypeDescription__ManyAssignment_1 : ( ( '[]' ) ) ;
    public final void rule__TypeDescription__ManyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4118:1: ( ( ( '[]' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4119:1: ( ( '[]' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4119:1: ( ( '[]' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4120:1: ( '[]' )
            {
             before(grammarAccess.getTypeDescriptionAccess().getManyLeftSquareBracketRightSquareBracketKeyword_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4121:1: ( '[]' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4122:1: '[]'
            {
             before(grammarAccess.getTypeDescriptionAccess().getManyLeftSquareBracketRightSquareBracketKeyword_1_0()); 
            match(input,47,FollowSets000.FOLLOW_47_in_rule__TypeDescription__ManyAssignment_18664); 
             after(grammarAccess.getTypeDescriptionAccess().getManyLeftSquareBracketRightSquareBracketKeyword_1_0()); 

            }

             after(grammarAccess.getTypeDescriptionAccess().getManyLeftSquareBracketRightSquareBracketKeyword_1_0()); 

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
    // $ANTLR end "rule__TypeDescription__ManyAssignment_1"


    // $ANTLR start "rule__Parameter__DescriptionAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4137:1: rule__Parameter__DescriptionAssignment_0 : ( ruleTypeDescription ) ;
    public final void rule__Parameter__DescriptionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4141:1: ( ( ruleTypeDescription ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4142:1: ( ruleTypeDescription )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4142:1: ( ruleTypeDescription )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4143:1: ruleTypeDescription
            {
             before(grammarAccess.getParameterAccess().getDescriptionTypeDescriptionParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeDescription_in_rule__Parameter__DescriptionAssignment_08703);
            ruleTypeDescription();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getDescriptionTypeDescriptionParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Parameter__DescriptionAssignment_0"


    // $ANTLR start "rule__Parameter__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4152:1: rule__Parameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4156:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4157:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4157:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4158:1: RULE_ID
            {
             before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_18734); 
             after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Parameter__NameAssignment_1"


    // $ANTLR start "rule__ObjectReference__ObjectAssignment_0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4167:1: rule__ObjectReference__ObjectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ObjectReference__ObjectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4171:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4172:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4172:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4173:1: ( RULE_ID )
            {
             before(grammarAccess.getObjectReferenceAccess().getObjectPropertyPathPartCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4174:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4175:1: RULE_ID
            {
             before(grammarAccess.getObjectReferenceAccess().getObjectPropertyPathPartIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ObjectReference__ObjectAssignment_08769); 
             after(grammarAccess.getObjectReferenceAccess().getObjectPropertyPathPartIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getObjectReferenceAccess().getObjectPropertyPathPartCrossReference_0_0()); 

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
    // $ANTLR end "rule__ObjectReference__ObjectAssignment_0"


    // $ANTLR start "rule__ObjectReference__TailAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4186:1: rule__ObjectReference__TailAssignment_1 : ( ruleNestedObjectReference ) ;
    public final void rule__ObjectReference__TailAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4190:1: ( ( ruleNestedObjectReference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4191:1: ( ruleNestedObjectReference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4191:1: ( ruleNestedObjectReference )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4192:1: ruleNestedObjectReference
            {
             before(grammarAccess.getObjectReferenceAccess().getTailNestedObjectReferenceParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedObjectReference_in_rule__ObjectReference__TailAssignment_18804);
            ruleNestedObjectReference();

            state._fsp--;

             after(grammarAccess.getObjectReferenceAccess().getTailNestedObjectReferenceParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__ObjectReference__TailAssignment_1"


    // $ANTLR start "rule__NestedObjectReference__ObjectAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4201:1: rule__NestedObjectReference__ObjectAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NestedObjectReference__ObjectAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4205:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4206:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4206:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4207:1: ( RULE_ID )
            {
             before(grammarAccess.getNestedObjectReferenceAccess().getObjectPropertyPathPartCrossReference_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4208:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4209:1: RULE_ID
            {
             before(grammarAccess.getNestedObjectReferenceAccess().getObjectPropertyPathPartIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__NestedObjectReference__ObjectAssignment_18839); 
             after(grammarAccess.getNestedObjectReferenceAccess().getObjectPropertyPathPartIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getNestedObjectReferenceAccess().getObjectPropertyPathPartCrossReference_1_0()); 

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
    // $ANTLR end "rule__NestedObjectReference__ObjectAssignment_1"


    // $ANTLR start "rule__NestedObjectReference__TailAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4220:1: rule__NestedObjectReference__TailAssignment_2 : ( ruleNestedObjectReference ) ;
    public final void rule__NestedObjectReference__TailAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4224:1: ( ( ruleNestedObjectReference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4225:1: ( ruleNestedObjectReference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4225:1: ( ruleNestedObjectReference )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4226:1: ruleNestedObjectReference
            {
             before(grammarAccess.getNestedObjectReferenceAccess().getTailNestedObjectReferenceParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedObjectReference_in_rule__NestedObjectReference__TailAssignment_28874);
            ruleNestedObjectReference();

            state._fsp--;

             after(grammarAccess.getNestedObjectReferenceAccess().getTailNestedObjectReferenceParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__NestedObjectReference__TailAssignment_2"


    // $ANTLR start "rule__StringLiteral__ValueAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4235:1: rule__StringLiteral__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4239:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4240:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4240:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4241:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment8905); 
             after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__StringLiteral__ValueAssignment"


    // $ANTLR start "rule__StringFunction__ValuesAssignment_0_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4250:1: rule__StringFunction__ValuesAssignment_0_2 : ( ruleScalarExpression ) ;
    public final void rule__StringFunction__ValuesAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4254:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4255:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4255:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4256:1: ruleScalarExpression
            {
             before(grammarAccess.getStringFunctionAccess().getValuesScalarExpressionParserRuleCall_0_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__StringFunction__ValuesAssignment_0_28936);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getStringFunctionAccess().getValuesScalarExpressionParserRuleCall_0_2_0()); 

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
    // $ANTLR end "rule__StringFunction__ValuesAssignment_0_2"


    // $ANTLR start "rule__StringFunction__ValueAssignment_1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4265:1: rule__StringFunction__ValueAssignment_1_2 : ( ruleScalarExpression ) ;
    public final void rule__StringFunction__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4269:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4270:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4270:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4271:1: ruleScalarExpression
            {
             before(grammarAccess.getStringFunctionAccess().getValueScalarExpressionParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__StringFunction__ValueAssignment_1_28967);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getStringFunctionAccess().getValueScalarExpressionParserRuleCall_1_2_0()); 

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
    // $ANTLR end "rule__StringFunction__ValueAssignment_1_2"


    // $ANTLR start "rule__StringFunction__MatchAssignment_1_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4280:1: rule__StringFunction__MatchAssignment_1_4 : ( ruleScalarExpression ) ;
    public final void rule__StringFunction__MatchAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4284:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4285:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4285:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4286:1: ruleScalarExpression
            {
             before(grammarAccess.getStringFunctionAccess().getMatchScalarExpressionParserRuleCall_1_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__StringFunction__MatchAssignment_1_48998);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getStringFunctionAccess().getMatchScalarExpressionParserRuleCall_1_4_0()); 

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
    // $ANTLR end "rule__StringFunction__MatchAssignment_1_4"


    // $ANTLR start "rule__StringFunction__ReplacementAssignment_1_6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4295:1: rule__StringFunction__ReplacementAssignment_1_6 : ( ruleScalarExpression ) ;
    public final void rule__StringFunction__ReplacementAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4299:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4300:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4300:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4301:1: ruleScalarExpression
            {
             before(grammarAccess.getStringFunctionAccess().getReplacementScalarExpressionParserRuleCall_1_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__StringFunction__ReplacementAssignment_1_69029);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getStringFunctionAccess().getReplacementScalarExpressionParserRuleCall_1_6_0()); 

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
    // $ANTLR end "rule__StringFunction__ReplacementAssignment_1_6"


    // $ANTLR start "rule__StringFunction__ValueAssignment_2_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4310:1: rule__StringFunction__ValueAssignment_2_2 : ( ruleScalarExpression ) ;
    public final void rule__StringFunction__ValueAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4314:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4315:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4315:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4316:1: ruleScalarExpression
            {
             before(grammarAccess.getStringFunctionAccess().getValueScalarExpressionParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__StringFunction__ValueAssignment_2_29060);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getStringFunctionAccess().getValueScalarExpressionParserRuleCall_2_2_0()); 

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
    // $ANTLR end "rule__StringFunction__ValueAssignment_2_2"


    // $ANTLR start "rule__CollectionLiteral__ItemsAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4325:1: rule__CollectionLiteral__ItemsAssignment_1 : ( ruleScalarExpression ) ;
    public final void rule__CollectionLiteral__ItemsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4329:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4330:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4330:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4331:1: ruleScalarExpression
            {
             before(grammarAccess.getCollectionLiteralAccess().getItemsScalarExpressionParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__CollectionLiteral__ItemsAssignment_19091);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getCollectionLiteralAccess().getItemsScalarExpressionParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__CollectionLiteral__ItemsAssignment_1"


    // $ANTLR start "rule__CollectionLiteral__ItemsAssignment_2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4340:1: rule__CollectionLiteral__ItemsAssignment_2_1 : ( ruleScalarExpression ) ;
    public final void rule__CollectionLiteral__ItemsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4344:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4345:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4345:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4346:1: ruleScalarExpression
            {
             before(grammarAccess.getCollectionLiteralAccess().getItemsScalarExpressionParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__CollectionLiteral__ItemsAssignment_2_19122);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getCollectionLiteralAccess().getItemsScalarExpressionParserRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__CollectionLiteral__ItemsAssignment_2_1"


    // $ANTLR start "rule__CollectionFunction__ValueAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4355:1: rule__CollectionFunction__ValueAssignment_2 : ( ruleScalarExpression ) ;
    public final void rule__CollectionFunction__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4359:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4360:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4360:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4361:1: ruleScalarExpression
            {
             before(grammarAccess.getCollectionFunctionAccess().getValueScalarExpressionParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__CollectionFunction__ValueAssignment_29153);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getCollectionFunctionAccess().getValueScalarExpressionParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__CollectionFunction__ValueAssignment_2"


    // $ANTLR start "rule__CollectionFunction__DelimiterAssignment_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4370:1: rule__CollectionFunction__DelimiterAssignment_4 : ( ruleScalarExpression ) ;
    public final void rule__CollectionFunction__DelimiterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4374:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4375:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4375:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4376:1: ruleScalarExpression
            {
             before(grammarAccess.getCollectionFunctionAccess().getDelimiterScalarExpressionParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__CollectionFunction__DelimiterAssignment_49184);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getCollectionFunctionAccess().getDelimiterScalarExpressionParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__CollectionFunction__DelimiterAssignment_4"


    // $ANTLR start "rule__TableView__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4385:1: rule__TableView__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TableView__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4389:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4390:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4390:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4391:1: RULE_ID
            {
             before(grammarAccess.getTableViewAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TableView__NameAssignment_19215); 
             after(grammarAccess.getTableViewAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__TableView__NameAssignment_1"


    // $ANTLR start "rule__TableView__ContentAssignment_2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4400:1: rule__TableView__ContentAssignment_2_1 : ( ruleParameter ) ;
    public final void rule__TableView__ContentAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4404:1: ( ( ruleParameter ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4405:1: ( ruleParameter )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4405:1: ( ruleParameter )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4406:1: ruleParameter
            {
             before(grammarAccess.getTableViewAccess().getContentParameterParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_rule__TableView__ContentAssignment_2_19246);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getTableViewAccess().getContentParameterParserRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__TableView__ContentAssignment_2_1"


    // $ANTLR start "rule__TableView__TitleAssignment_4_0_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4415:1: rule__TableView__TitleAssignment_4_0_1 : ( ruleScalarExpression ) ;
    public final void rule__TableView__TitleAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4419:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4420:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4420:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4421:1: ruleScalarExpression
            {
             before(grammarAccess.getTableViewAccess().getTitleScalarExpressionParserRuleCall_4_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__TableView__TitleAssignment_4_0_19277);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getTableViewAccess().getTitleScalarExpressionParserRuleCall_4_0_1_0()); 

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
    // $ANTLR end "rule__TableView__TitleAssignment_4_0_1"


    // $ANTLR start "rule__TableView__TitleImageAssignment_4_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4430:1: rule__TableView__TitleImageAssignment_4_1_1 : ( ruleImageExpression ) ;
    public final void rule__TableView__TitleImageAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4434:1: ( ( ruleImageExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4435:1: ( ruleImageExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4435:1: ( ruleImageExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4436:1: ruleImageExpression
            {
             before(grammarAccess.getTableViewAccess().getTitleImageImageExpressionParserRuleCall_4_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleImageExpression_in_rule__TableView__TitleImageAssignment_4_1_19308);
            ruleImageExpression();

            state._fsp--;

             after(grammarAccess.getTableViewAccess().getTitleImageImageExpressionParserRuleCall_4_1_1_0()); 

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
    // $ANTLR end "rule__TableView__TitleImageAssignment_4_1_1"


    // $ANTLR start "rule__TableView__StyleAssignment_4_2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4445:1: rule__TableView__StyleAssignment_4_2_1 : ( ruleTableViewStyle ) ;
    public final void rule__TableView__StyleAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4449:1: ( ( ruleTableViewStyle ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4450:1: ( ruleTableViewStyle )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4450:1: ( ruleTableViewStyle )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4451:1: ruleTableViewStyle
            {
             before(grammarAccess.getTableViewAccess().getStyleTableViewStyleEnumRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTableViewStyle_in_rule__TableView__StyleAssignment_4_2_19339);
            ruleTableViewStyle();

            state._fsp--;

             after(grammarAccess.getTableViewAccess().getStyleTableViewStyleEnumRuleCall_4_2_1_0()); 

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
    // $ANTLR end "rule__TableView__StyleAssignment_4_2_1"


    // $ANTLR start "rule__TableView__SectionsAssignment_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4460:1: rule__TableView__SectionsAssignment_5 : ( ruleSection ) ;
    public final void rule__TableView__SectionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4464:1: ( ( ruleSection ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4465:1: ( ruleSection )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4465:1: ( ruleSection )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4466:1: ruleSection
            {
             before(grammarAccess.getTableViewAccess().getSectionsSectionParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSection_in_rule__TableView__SectionsAssignment_59370);
            ruleSection();

            state._fsp--;

             after(grammarAccess.getTableViewAccess().getSectionsSectionParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__TableView__SectionsAssignment_5"


    // $ANTLR start "rule__Section__IteratorAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4475:1: rule__Section__IteratorAssignment_1 : ( ruleCollectionIterator ) ;
    public final void rule__Section__IteratorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4479:1: ( ( ruleCollectionIterator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4480:1: ( ruleCollectionIterator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4480:1: ( ruleCollectionIterator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4481:1: ruleCollectionIterator
            {
             before(grammarAccess.getSectionAccess().getIteratorCollectionIteratorParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCollectionIterator_in_rule__Section__IteratorAssignment_19401);
            ruleCollectionIterator();

            state._fsp--;

             after(grammarAccess.getSectionAccess().getIteratorCollectionIteratorParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Section__IteratorAssignment_1"


    // $ANTLR start "rule__Section__TitleAssignment_3_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4490:1: rule__Section__TitleAssignment_3_1 : ( ruleScalarExpression ) ;
    public final void rule__Section__TitleAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4494:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4495:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4495:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4496:1: ruleScalarExpression
            {
             before(grammarAccess.getSectionAccess().getTitleScalarExpressionParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__Section__TitleAssignment_3_19432);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getSectionAccess().getTitleScalarExpressionParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__Section__TitleAssignment_3_1"


    // $ANTLR start "rule__Section__CellsAssignment_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4505:1: rule__Section__CellsAssignment_4 : ( ruleCell ) ;
    public final void rule__Section__CellsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4509:1: ( ( ruleCell ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4510:1: ( ruleCell )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4510:1: ( ruleCell )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4511:1: ruleCell
            {
             before(grammarAccess.getSectionAccess().getCellsCellParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCell_in_rule__Section__CellsAssignment_49463);
            ruleCell();

            state._fsp--;

             after(grammarAccess.getSectionAccess().getCellsCellParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__Section__CellsAssignment_4"


    // $ANTLR start "rule__Cell__TypeAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4520:1: rule__Cell__TypeAssignment_1 : ( ruleCellType ) ;
    public final void rule__Cell__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4524:1: ( ( ruleCellType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4525:1: ( ruleCellType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4525:1: ( ruleCellType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4526:1: ruleCellType
            {
             before(grammarAccess.getCellAccess().getTypeCellTypeEnumRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCellType_in_rule__Cell__TypeAssignment_19494);
            ruleCellType();

            state._fsp--;

             after(grammarAccess.getCellAccess().getTypeCellTypeEnumRuleCall_1_0()); 

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
    // $ANTLR end "rule__Cell__TypeAssignment_1"


    // $ANTLR start "rule__Cell__IteratorAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4535:1: rule__Cell__IteratorAssignment_2 : ( ruleCollectionIterator ) ;
    public final void rule__Cell__IteratorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4539:1: ( ( ruleCollectionIterator ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4540:1: ( ruleCollectionIterator )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4540:1: ( ruleCollectionIterator )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4541:1: ruleCollectionIterator
            {
             before(grammarAccess.getCellAccess().getIteratorCollectionIteratorParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCollectionIterator_in_rule__Cell__IteratorAssignment_29525);
            ruleCollectionIterator();

            state._fsp--;

             after(grammarAccess.getCellAccess().getIteratorCollectionIteratorParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Cell__IteratorAssignment_2"


    // $ANTLR start "rule__Cell__TextAssignment_4_0_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4550:1: rule__Cell__TextAssignment_4_0_1 : ( ruleScalarExpression ) ;
    public final void rule__Cell__TextAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4554:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4555:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4555:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4556:1: ruleScalarExpression
            {
             before(grammarAccess.getCellAccess().getTextScalarExpressionParserRuleCall_4_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__Cell__TextAssignment_4_0_19556);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getCellAccess().getTextScalarExpressionParserRuleCall_4_0_1_0()); 

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
    // $ANTLR end "rule__Cell__TextAssignment_4_0_1"


    // $ANTLR start "rule__Cell__DetailsAssignment_4_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4565:1: rule__Cell__DetailsAssignment_4_1_1 : ( ruleScalarExpression ) ;
    public final void rule__Cell__DetailsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4569:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4570:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4570:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4571:1: ruleScalarExpression
            {
             before(grammarAccess.getCellAccess().getDetailsScalarExpressionParserRuleCall_4_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__Cell__DetailsAssignment_4_1_19587);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getCellAccess().getDetailsScalarExpressionParserRuleCall_4_1_1_0()); 

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
    // $ANTLR end "rule__Cell__DetailsAssignment_4_1_1"


    // $ANTLR start "rule__Cell__ImageAssignment_4_2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4580:1: rule__Cell__ImageAssignment_4_2_1 : ( ruleScalarExpression ) ;
    public final void rule__Cell__ImageAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4584:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4585:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4585:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4586:1: ruleScalarExpression
            {
             before(grammarAccess.getCellAccess().getImageScalarExpressionParserRuleCall_4_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__Cell__ImageAssignment_4_2_19618);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getCellAccess().getImageScalarExpressionParserRuleCall_4_2_1_0()); 

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
    // $ANTLR end "rule__Cell__ImageAssignment_4_2_1"


    // $ANTLR start "rule__Cell__ActionAssignment_4_3_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4595:1: rule__Cell__ActionAssignment_4_3_1 : ( ruleViewAction ) ;
    public final void rule__Cell__ActionAssignment_4_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4599:1: ( ( ruleViewAction ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4600:1: ( ruleViewAction )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4600:1: ( ruleViewAction )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4601:1: ruleViewAction
            {
             before(grammarAccess.getCellAccess().getActionViewActionParserRuleCall_4_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleViewAction_in_rule__Cell__ActionAssignment_4_3_19649);
            ruleViewAction();

            state._fsp--;

             after(grammarAccess.getCellAccess().getActionViewActionParserRuleCall_4_3_1_0()); 

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
    // $ANTLR end "rule__Cell__ActionAssignment_4_3_1"


    // $ANTLR start "rule__Cell__AccessoryAssignment_4_4_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4610:1: rule__Cell__AccessoryAssignment_4_4_1 : ( ruleCellAccessory ) ;
    public final void rule__Cell__AccessoryAssignment_4_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4614:1: ( ( ruleCellAccessory ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4615:1: ( ruleCellAccessory )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4615:1: ( ruleCellAccessory )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4616:1: ruleCellAccessory
            {
             before(grammarAccess.getCellAccess().getAccessoryCellAccessoryEnumRuleCall_4_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCellAccessory_in_rule__Cell__AccessoryAssignment_4_4_19680);
            ruleCellAccessory();

            state._fsp--;

             after(grammarAccess.getCellAccess().getAccessoryCellAccessoryEnumRuleCall_4_4_1_0()); 

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
    // $ANTLR end "rule__Cell__AccessoryAssignment_4_4_1"


    // $ANTLR start "rule__CollectionIterator__NameAssignment_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4625:1: rule__CollectionIterator__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CollectionIterator__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4629:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4630:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4630:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4631:1: RULE_ID
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__CollectionIterator__NameAssignment_19711); 
             after(grammarAccess.getCollectionIteratorAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__CollectionIterator__NameAssignment_1"


    // $ANTLR start "rule__CollectionIterator__CollectionAssignment_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4640:1: rule__CollectionIterator__CollectionAssignment_3 : ( ruleCollectionExpression ) ;
    public final void rule__CollectionIterator__CollectionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4644:1: ( ( ruleCollectionExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4645:1: ( ruleCollectionExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4645:1: ( ruleCollectionExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4646:1: ruleCollectionExpression
            {
             before(grammarAccess.getCollectionIteratorAccess().getCollectionCollectionExpressionParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCollectionExpression_in_rule__CollectionIterator__CollectionAssignment_39742);
            ruleCollectionExpression();

            state._fsp--;

             after(grammarAccess.getCollectionIteratorAccess().getCollectionCollectionExpressionParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__CollectionIterator__CollectionAssignment_3"


    // $ANTLR start "rule__Selector__NameAssignment_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4655:1: rule__Selector__NameAssignment_2 : ( ruleSelectorName ) ;
    public final void rule__Selector__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4659:1: ( ( ruleSelectorName ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4660:1: ( ruleSelectorName )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4660:1: ( ruleSelectorName )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4661:1: ruleSelectorName
            {
             before(grammarAccess.getSelectorAccess().getNameSelectorNameParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectorName_in_rule__Selector__NameAssignment_29773);
            ruleSelectorName();

            state._fsp--;

             after(grammarAccess.getSelectorAccess().getNameSelectorNameParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Selector__NameAssignment_2"


    // $ANTLR start "rule__ExternalOpen__UrlAssignment"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4670:1: rule__ExternalOpen__UrlAssignment : ( ruleScalarExpression ) ;
    public final void rule__ExternalOpen__UrlAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4674:1: ( ( ruleScalarExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4675:1: ( ruleScalarExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4675:1: ( ruleScalarExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug332217TestLanguage.g:4676:1: ruleScalarExpression
            {
             before(grammarAccess.getExternalOpenAccess().getUrlScalarExpressionParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleScalarExpression_in_rule__ExternalOpen__UrlAssignment9804);
            ruleScalarExpression();

            state._fsp--;

             after(grammarAccess.getExternalOpenAccess().getUrlScalarExpressionParserRuleCall_0()); 

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
    // $ANTLR end "rule__ExternalOpen__UrlAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ElementsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleTypeDescription_in_entryRuleTypeDescription124 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeDescription131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeDescription__Group__0_in_ruleTypeDescription157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectReference_in_entryRuleObjectReference244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectReference251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectReference__Group__0_in_ruleObjectReference277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedObjectReference_in_entryRuleNestedObjectReference304 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedObjectReference311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__Group__0_in_ruleNestedObjectReference337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImageExpression_in_entryRuleImageExpression366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImageExpression373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_ruleImageExpression399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_entryRuleScalarExpression425 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScalarExpression432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ScalarExpression__Alternatives_in_ruleScalarExpression458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionExpression_in_entryRuleCollectionExpression485 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionExpression492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionExpression__Alternatives_in_ruleCollectionExpression518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral545 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_in_ruleStringLiteral578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringFunction_in_entryRuleStringFunction605 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringFunction612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Alternatives_in_ruleStringFunction638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteral_in_entryRuleCollectionLiteral665 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteral672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__0_in_ruleCollectionLiteral698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionFunction_in_entryRuleCollectionFunction725 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionFunction732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__0_in_ruleCollectionFunction758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTableView_in_entryRuleTableView785 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTableView792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__0_in_ruleTableView818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSection_in_entryRuleSection847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSection854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group__0_in_ruleSection880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCell_in_entryRuleCell907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCell914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group__0_in_ruleCell940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionIterator_in_entryRuleCollectionIterator967 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionIterator974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__0_in_ruleCollectionIterator1000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleViewAction_in_entryRuleViewAction1027 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleViewAction1034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ViewAction__Alternatives_in_ruleViewAction1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectorName_in_entryRuleSelectorName1087 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectorName1094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectorName__Group__0_in_ruleSelectorName1120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelector_in_entryRuleSelector1147 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelector1154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Selector__Group__0_in_ruleSelector1180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExternalOpen_in_entryRuleExternalOpen1207 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExternalOpen1214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ExternalOpen__UrlAssignment_in_ruleExternalOpen1240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableViewStyle__Alternatives_in_ruleTableViewStyle1277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CellType__Alternatives_in_ruleCellType1313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CellAccessory__Alternatives_in_ruleCellAccessory1349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_rule__ScalarExpression__Alternatives1386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringFunction_in_rule__ScalarExpression__Alternatives1403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectReference_in_rule__ScalarExpression__Alternatives1420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteral_in_rule__CollectionExpression__Alternatives1452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionFunction_in_rule__CollectionExpression__Alternatives1469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectReference_in_rule__CollectionExpression__Alternatives1486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__0_in_rule__StringFunction__Alternatives1518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__0_in_rule__StringFunction__Alternatives1536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__0_in_rule__StringFunction__Alternatives1554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExternalOpen_in_rule__ViewAction__Alternatives1588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelector_in_rule__ViewAction__Alternatives1605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TableViewStyle__Alternatives1638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TableViewStyle__Alternatives1659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CellType__Alternatives1695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__CellType__Alternatives1716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__CellType__Alternatives1737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__CellType__Alternatives1758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__CellAccessory__Alternatives1794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__CellAccessory__Alternatives1815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__CellAccessory__Alternatives1836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__CellAccessory__Alternatives1857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeDescription__Group__0__Impl_in_rule__TypeDescription__Group__01890 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_rule__TypeDescription__Group__1_in_rule__TypeDescription__Group__01893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeDescription__TypeAssignment_0_in_rule__TypeDescription__Group__0__Impl1920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeDescription__Group__1__Impl_in_rule__TypeDescription__Group__11950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TypeDescription__ManyAssignment_1_in_rule__TypeDescription__Group__1__Impl1977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__02012 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__02015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__DescriptionAssignment_0_in_rule__Parameter__Group__0__Impl2042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__12072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Parameter__NameAssignment_1_in_rule__Parameter__Group__1__Impl2099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectReference__Group__0__Impl_in_rule__ObjectReference__Group__02133 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__ObjectReference__Group__1_in_rule__ObjectReference__Group__02136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectReference__ObjectAssignment_0_in_rule__ObjectReference__Group__0__Impl2163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectReference__Group__1__Impl_in_rule__ObjectReference__Group__12193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ObjectReference__TailAssignment_1_in_rule__ObjectReference__Group__1__Impl2220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__Group__0__Impl_in_rule__NestedObjectReference__Group__02255 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__Group__1_in_rule__NestedObjectReference__Group__02258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__NestedObjectReference__Group__0__Impl2286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__Group__1__Impl_in_rule__NestedObjectReference__Group__12317 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__Group__2_in_rule__NestedObjectReference__Group__12320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__ObjectAssignment_1_in_rule__NestedObjectReference__Group__1__Impl2347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__Group__2__Impl_in_rule__NestedObjectReference__Group__22377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NestedObjectReference__TailAssignment_2_in_rule__NestedObjectReference__Group__2__Impl2404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__0__Impl_in_rule__StringFunction__Group_0__02441 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__1_in_rule__StringFunction__Group_0__02444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__1__Impl_in_rule__StringFunction__Group_0__12502 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__2_in_rule__StringFunction__Group_0__12505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__StringFunction__Group_0__1__Impl2533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__2__Impl_in_rule__StringFunction__Group_0__22564 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__3_in_rule__StringFunction__Group_0__22567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__ValuesAssignment_0_2_in_rule__StringFunction__Group_0__2__Impl2596 = new BitSet(new long[]{0x0000000005400032L});
        public static final BitSet FOLLOW_rule__StringFunction__ValuesAssignment_0_2_in_rule__StringFunction__Group_0__2__Impl2608 = new BitSet(new long[]{0x0000000005400032L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_0__3__Impl_in_rule__StringFunction__Group_0__32641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__StringFunction__Group_0__3__Impl2669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__0__Impl_in_rule__StringFunction__Group_1__02708 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__1_in_rule__StringFunction__Group_1__02711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__1__Impl_in_rule__StringFunction__Group_1__12769 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__2_in_rule__StringFunction__Group_1__12772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__StringFunction__Group_1__1__Impl2800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__2__Impl_in_rule__StringFunction__Group_1__22831 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__3_in_rule__StringFunction__Group_1__22834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__ValueAssignment_1_2_in_rule__StringFunction__Group_1__2__Impl2861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__3__Impl_in_rule__StringFunction__Group_1__32891 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__4_in_rule__StringFunction__Group_1__32894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__StringFunction__Group_1__3__Impl2922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__4__Impl_in_rule__StringFunction__Group_1__42953 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__5_in_rule__StringFunction__Group_1__42956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__MatchAssignment_1_4_in_rule__StringFunction__Group_1__4__Impl2983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__5__Impl_in_rule__StringFunction__Group_1__53013 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__6_in_rule__StringFunction__Group_1__53016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__StringFunction__Group_1__5__Impl3044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__6__Impl_in_rule__StringFunction__Group_1__63075 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__7_in_rule__StringFunction__Group_1__63078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__ReplacementAssignment_1_6_in_rule__StringFunction__Group_1__6__Impl3105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_1__7__Impl_in_rule__StringFunction__Group_1__73135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__StringFunction__Group_1__7__Impl3163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__0__Impl_in_rule__StringFunction__Group_2__03210 = new BitSet(new long[]{0x0000000005400000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__1_in_rule__StringFunction__Group_2__03213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__1__Impl_in_rule__StringFunction__Group_2__13271 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__2_in_rule__StringFunction__Group_2__13274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__StringFunction__Group_2__1__Impl3302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__2__Impl_in_rule__StringFunction__Group_2__23333 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__3_in_rule__StringFunction__Group_2__23336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__ValueAssignment_2_2_in_rule__StringFunction__Group_2__2__Impl3363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StringFunction__Group_2__3__Impl_in_rule__StringFunction__Group_2__33393 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__StringFunction__Group_2__3__Impl3421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__0__Impl_in_rule__CollectionLiteral__Group__03460 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__1_in_rule__CollectionLiteral__Group__03463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__CollectionLiteral__Group__0__Impl3491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__1__Impl_in_rule__CollectionLiteral__Group__13522 = new BitSet(new long[]{0x0000000012000000L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__2_in_rule__CollectionLiteral__Group__13525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__ItemsAssignment_1_in_rule__CollectionLiteral__Group__1__Impl3552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__2__Impl_in_rule__CollectionLiteral__Group__23582 = new BitSet(new long[]{0x0000000012000000L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__3_in_rule__CollectionLiteral__Group__23585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group_2__0_in_rule__CollectionLiteral__Group__2__Impl3612 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group__3__Impl_in_rule__CollectionLiteral__Group__33643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__CollectionLiteral__Group__3__Impl3671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group_2__0__Impl_in_rule__CollectionLiteral__Group_2__03710 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group_2__1_in_rule__CollectionLiteral__Group_2__03713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__CollectionLiteral__Group_2__0__Impl3741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__Group_2__1__Impl_in_rule__CollectionLiteral__Group_2__13772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionLiteral__ItemsAssignment_2_1_in_rule__CollectionLiteral__Group_2__1__Impl3799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__0__Impl_in_rule__CollectionFunction__Group__03833 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__1_in_rule__CollectionFunction__Group__03836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__1__Impl_in_rule__CollectionFunction__Group__13894 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__2_in_rule__CollectionFunction__Group__13897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__CollectionFunction__Group__1__Impl3925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__2__Impl_in_rule__CollectionFunction__Group__23956 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__3_in_rule__CollectionFunction__Group__23959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__ValueAssignment_2_in_rule__CollectionFunction__Group__2__Impl3986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__3__Impl_in_rule__CollectionFunction__Group__34016 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__4_in_rule__CollectionFunction__Group__34019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__CollectionFunction__Group__3__Impl4047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__4__Impl_in_rule__CollectionFunction__Group__44078 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__5_in_rule__CollectionFunction__Group__44081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__DelimiterAssignment_4_in_rule__CollectionFunction__Group__4__Impl4108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionFunction__Group__5__Impl_in_rule__CollectionFunction__Group__54138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__CollectionFunction__Group__5__Impl4166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__0__Impl_in_rule__TableView__Group__04209 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TableView__Group__1_in_rule__TableView__Group__04212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__TableView__Group__0__Impl4240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__1__Impl_in_rule__TableView__Group__14271 = new BitSet(new long[]{0x0000000080400000L});
        public static final BitSet FOLLOW_rule__TableView__Group__2_in_rule__TableView__Group__14274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__NameAssignment_1_in_rule__TableView__Group__1__Impl4301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__2__Impl_in_rule__TableView__Group__24331 = new BitSet(new long[]{0x0000000080400000L});
        public static final BitSet FOLLOW_rule__TableView__Group__3_in_rule__TableView__Group__24334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_2__0_in_rule__TableView__Group__2__Impl4361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__3__Impl_in_rule__TableView__Group__34392 = new BitSet(new long[]{0x0000000E00000000L});
        public static final BitSet FOLLOW_rule__TableView__Group__4_in_rule__TableView__Group__34395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__TableView__Group__3__Impl4423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__4__Impl_in_rule__TableView__Group__44454 = new BitSet(new long[]{0x0000001100000000L});
        public static final BitSet FOLLOW_rule__TableView__Group__5_in_rule__TableView__Group__44457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__UnorderedGroup_4_in_rule__TableView__Group__4__Impl4484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__5__Impl_in_rule__TableView__Group__54514 = new BitSet(new long[]{0x0000001100000000L});
        public static final BitSet FOLLOW_rule__TableView__Group__6_in_rule__TableView__Group__54517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__SectionsAssignment_5_in_rule__TableView__Group__5__Impl4544 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group__6__Impl_in_rule__TableView__Group__64575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__TableView__Group__6__Impl4603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_2__0__Impl_in_rule__TableView__Group_2__04648 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TableView__Group_2__1_in_rule__TableView__Group_2__04651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__TableView__Group_2__0__Impl4679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_2__1__Impl_in_rule__TableView__Group_2__14710 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__TableView__Group_2__2_in_rule__TableView__Group_2__14713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__ContentAssignment_2_1_in_rule__TableView__Group_2__1__Impl4740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_2__2__Impl_in_rule__TableView__Group_2__24770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__TableView__Group_2__2__Impl4798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_0__0__Impl_in_rule__TableView__Group_4_0__04835 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_0__1_in_rule__TableView__Group_4_0__04838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__TableView__Group_4_0__0__Impl4866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_0__1__Impl_in_rule__TableView__Group_4_0__14897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__TitleAssignment_4_0_1_in_rule__TableView__Group_4_0__1__Impl4924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_1__0__Impl_in_rule__TableView__Group_4_1__04958 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_1__1_in_rule__TableView__Group_4_1__04961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__TableView__Group_4_1__0__Impl4989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_1__1__Impl_in_rule__TableView__Group_4_1__15020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__TitleImageAssignment_4_1_1_in_rule__TableView__Group_4_1__1__Impl5047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_2__0__Impl_in_rule__TableView__Group_4_2__05081 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_2__1_in_rule__TableView__Group_4_2__05084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__TableView__Group_4_2__0__Impl5112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_2__1__Impl_in_rule__TableView__Group_4_2__15143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__StyleAssignment_4_2_1_in_rule__TableView__Group_4_2__1__Impl5170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group__0__Impl_in_rule__Section__Group__05204 = new BitSet(new long[]{0x0000080080000000L});
        public static final BitSet FOLLOW_rule__Section__Group__1_in_rule__Section__Group__05207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__Section__Group__0__Impl5235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group__1__Impl_in_rule__Section__Group__15266 = new BitSet(new long[]{0x0000080080000000L});
        public static final BitSet FOLLOW_rule__Section__Group__2_in_rule__Section__Group__15269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__IteratorAssignment_1_in_rule__Section__Group__1__Impl5296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group__2__Impl_in_rule__Section__Group__25327 = new BitSet(new long[]{0x0000002200000000L});
        public static final BitSet FOLLOW_rule__Section__Group__3_in_rule__Section__Group__25330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__Section__Group__2__Impl5358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group__3__Impl_in_rule__Section__Group__35389 = new BitSet(new long[]{0x0000002200000000L});
        public static final BitSet FOLLOW_rule__Section__Group__4_in_rule__Section__Group__35392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group_3__0_in_rule__Section__Group__3__Impl5419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group__4__Impl_in_rule__Section__Group__45450 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__Section__Group__5_in_rule__Section__Group__45453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__CellsAssignment_4_in_rule__Section__Group__4__Impl5482 = new BitSet(new long[]{0x0000002200000002L});
        public static final BitSet FOLLOW_rule__Section__CellsAssignment_4_in_rule__Section__Group__4__Impl5494 = new BitSet(new long[]{0x0000002200000002L});
        public static final BitSet FOLLOW_rule__Section__Group__5__Impl_in_rule__Section__Group__55527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Section__Group__5__Impl5555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group_3__0__Impl_in_rule__Section__Group_3__05598 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__Section__Group_3__1_in_rule__Section__Group_3__05601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Section__Group_3__0__Impl5629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__Group_3__1__Impl_in_rule__Section__Group_3__15660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Section__TitleAssignment_3_1_in_rule__Section__Group_3__1__Impl5687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group__0__Impl_in_rule__Cell__Group__05721 = new BitSet(new long[]{0x000000000001E000L});
        public static final BitSet FOLLOW_rule__Cell__Group__1_in_rule__Cell__Group__05724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__Cell__Group__0__Impl5752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group__1__Impl_in_rule__Cell__Group__15783 = new BitSet(new long[]{0x0000080080000000L});
        public static final BitSet FOLLOW_rule__Cell__Group__2_in_rule__Cell__Group__15786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__TypeAssignment_1_in_rule__Cell__Group__1__Impl5813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group__2__Impl_in_rule__Cell__Group__25843 = new BitSet(new long[]{0x0000080080000000L});
        public static final BitSet FOLLOW_rule__Cell__Group__3_in_rule__Cell__Group__25846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__IteratorAssignment_2_in_rule__Cell__Group__2__Impl5873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group__3__Impl_in_rule__Cell__Group__35904 = new BitSet(new long[]{0x000007C000000000L});
        public static final BitSet FOLLOW_rule__Cell__Group__4_in_rule__Cell__Group__35907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__Cell__Group__3__Impl5935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group__4__Impl_in_rule__Cell__Group__45966 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__Cell__Group__5_in_rule__Cell__Group__45969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4_in_rule__Cell__Group__4__Impl5996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group__5__Impl_in_rule__Cell__Group__56026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__Cell__Group__5__Impl6054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_0__0__Impl_in_rule__Cell__Group_4_0__06097 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_0__1_in_rule__Cell__Group_4_0__06100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__Cell__Group_4_0__0__Impl6128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_0__1__Impl_in_rule__Cell__Group_4_0__16159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__TextAssignment_4_0_1_in_rule__Cell__Group_4_0__1__Impl6186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_1__0__Impl_in_rule__Cell__Group_4_1__06220 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_1__1_in_rule__Cell__Group_4_1__06223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__Cell__Group_4_1__0__Impl6251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_1__1__Impl_in_rule__Cell__Group_4_1__16282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__DetailsAssignment_4_1_1_in_rule__Cell__Group_4_1__1__Impl6309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_2__0__Impl_in_rule__Cell__Group_4_2__06343 = new BitSet(new long[]{0x0000000005400030L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_2__1_in_rule__Cell__Group_4_2__06346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__Cell__Group_4_2__0__Impl6374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_2__1__Impl_in_rule__Cell__Group_4_2__16405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__ImageAssignment_4_2_1_in_rule__Cell__Group_4_2__1__Impl6432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_3__0__Impl_in_rule__Cell__Group_4_3__06466 = new BitSet(new long[]{0x0000400005400030L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_3__1_in_rule__Cell__Group_4_3__06469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_rule__Cell__Group_4_3__0__Impl6497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_3__1__Impl_in_rule__Cell__Group_4_3__16528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__ActionAssignment_4_3_1_in_rule__Cell__Group_4_3__1__Impl6555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_4__0__Impl_in_rule__Cell__Group_4_4__06589 = new BitSet(new long[]{0x00000000001E0000L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_4__1_in_rule__Cell__Group_4_4__06592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rule__Cell__Group_4_4__0__Impl6620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_4__1__Impl_in_rule__Cell__Group_4_4__16651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__AccessoryAssignment_4_4_1_in_rule__Cell__Group_4_4__1__Impl6678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__0__Impl_in_rule__CollectionIterator__Group__06712 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__1_in_rule__CollectionIterator__Group__06715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_rule__CollectionIterator__Group__0__Impl6743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__1__Impl_in_rule__CollectionIterator__Group__16774 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__2_in_rule__CollectionIterator__Group__16777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionIterator__NameAssignment_1_in_rule__CollectionIterator__Group__1__Impl6804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__2__Impl_in_rule__CollectionIterator__Group__26834 = new BitSet(new long[]{0x000000002D400030L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__3_in_rule__CollectionIterator__Group__26837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_rule__CollectionIterator__Group__2__Impl6865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionIterator__Group__3__Impl_in_rule__CollectionIterator__Group__36896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CollectionIterator__CollectionAssignment_3_in_rule__CollectionIterator__Group__3__Impl6923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectorName__Group__0__Impl_in_rule__SelectorName__Group__06961 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_rule__SelectorName__Group__1_in_rule__SelectorName__Group__06964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SelectorName__Group__0__Impl6991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectorName__Group__1__Impl_in_rule__SelectorName__Group__17020 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_rule__SelectorName__Group__2_in_rule__SelectorName__Group__17023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectorName__Group_1__0_in_rule__SelectorName__Group__1__Impl7050 = new BitSet(new long[]{0x0000200000000002L});
        public static final BitSet FOLLOW_rule__SelectorName__Group__2__Impl_in_rule__SelectorName__Group__27081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__SelectorName__Group__2__Impl7110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectorName__Group_1__0__Impl_in_rule__SelectorName__Group_1__07149 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__SelectorName__Group_1__1_in_rule__SelectorName__Group_1__07152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_rule__SelectorName__Group_1__0__Impl7180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SelectorName__Group_1__1__Impl_in_rule__SelectorName__Group_1__17211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__SelectorName__Group_1__1__Impl7238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Selector__Group__0__Impl_in_rule__Selector__Group__07271 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Selector__Group__1_in_rule__Selector__Group__07274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_rule__Selector__Group__0__Impl7302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Selector__Group__1__Impl_in_rule__Selector__Group__17333 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Selector__Group__2_in_rule__Selector__Group__17336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Selector__Group__1__Impl7364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Selector__Group__2__Impl_in_rule__Selector__Group__27395 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Selector__Group__3_in_rule__Selector__Group__27398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Selector__NameAssignment_2_in_rule__Selector__Group__2__Impl7425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Selector__Group__3__Impl_in_rule__Selector__Group__37455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Selector__Group__3__Impl7483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__UnorderedGroup_4__0_in_rule__TableView__UnorderedGroup_47523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_0__0_in_rule__TableView__UnorderedGroup_4__Impl7610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_1__0_in_rule__TableView__UnorderedGroup_4__Impl7701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__Group_4_2__0_in_rule__TableView__UnorderedGroup_4__Impl7792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__UnorderedGroup_4__Impl_in_rule__TableView__UnorderedGroup_4__07851 = new BitSet(new long[]{0x0000000E00000002L});
        public static final BitSet FOLLOW_rule__TableView__UnorderedGroup_4__1_in_rule__TableView__UnorderedGroup_4__07854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__UnorderedGroup_4__Impl_in_rule__TableView__UnorderedGroup_4__17879 = new BitSet(new long[]{0x0000000E00000002L});
        public static final BitSet FOLLOW_rule__TableView__UnorderedGroup_4__2_in_rule__TableView__UnorderedGroup_4__17882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TableView__UnorderedGroup_4__Impl_in_rule__TableView__UnorderedGroup_4__27907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__0_in_rule__Cell__UnorderedGroup_47937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_0__0_in_rule__Cell__UnorderedGroup_4__Impl8024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_1__0_in_rule__Cell__UnorderedGroup_4__Impl8115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_2__0_in_rule__Cell__UnorderedGroup_4__Impl8206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_3__0_in_rule__Cell__UnorderedGroup_4__Impl8297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__Group_4_4__0_in_rule__Cell__UnorderedGroup_4__Impl8388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__08447 = new BitSet(new long[]{0x000007C000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__1_in_rule__Cell__UnorderedGroup_4__08450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__18475 = new BitSet(new long[]{0x000007C000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__2_in_rule__Cell__UnorderedGroup_4__18478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__28503 = new BitSet(new long[]{0x000007C000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__3_in_rule__Cell__UnorderedGroup_4__28506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__38531 = new BitSet(new long[]{0x000007C000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__4_in_rule__Cell__UnorderedGroup_4__38534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cell__UnorderedGroup_4__Impl_in_rule__Cell__UnorderedGroup_4__48559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTableView_in_rule__Model__ElementsAssignment8597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TypeDescription__TypeAssignment_08628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_rule__TypeDescription__ManyAssignment_18664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeDescription_in_rule__Parameter__DescriptionAssignment_08703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_18734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ObjectReference__ObjectAssignment_08769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedObjectReference_in_rule__ObjectReference__TailAssignment_18804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__NestedObjectReference__ObjectAssignment_18839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedObjectReference_in_rule__NestedObjectReference__TailAssignment_28874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment8905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__StringFunction__ValuesAssignment_0_28936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__StringFunction__ValueAssignment_1_28967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__StringFunction__MatchAssignment_1_48998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__StringFunction__ReplacementAssignment_1_69029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__StringFunction__ValueAssignment_2_29060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__CollectionLiteral__ItemsAssignment_19091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__CollectionLiteral__ItemsAssignment_2_19122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__CollectionFunction__ValueAssignment_29153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__CollectionFunction__DelimiterAssignment_49184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TableView__NameAssignment_19215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_rule__TableView__ContentAssignment_2_19246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__TableView__TitleAssignment_4_0_19277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImageExpression_in_rule__TableView__TitleImageAssignment_4_1_19308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTableViewStyle_in_rule__TableView__StyleAssignment_4_2_19339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSection_in_rule__TableView__SectionsAssignment_59370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionIterator_in_rule__Section__IteratorAssignment_19401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__Section__TitleAssignment_3_19432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCell_in_rule__Section__CellsAssignment_49463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCellType_in_rule__Cell__TypeAssignment_19494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionIterator_in_rule__Cell__IteratorAssignment_29525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__Cell__TextAssignment_4_0_19556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__Cell__DetailsAssignment_4_1_19587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__Cell__ImageAssignment_4_2_19618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleViewAction_in_rule__Cell__ActionAssignment_4_3_19649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCellAccessory_in_rule__Cell__AccessoryAssignment_4_4_19680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__CollectionIterator__NameAssignment_19711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionExpression_in_rule__CollectionIterator__CollectionAssignment_39742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectorName_in_rule__Selector__NameAssignment_29773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScalarExpression_in_rule__ExternalOpen__UrlAssignment9804 = new BitSet(new long[]{0x0000000000000002L});
    }


}