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

    // delegates
    // delegators


        public InternalBug288760TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug288760TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug288760TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug288760TestLanguage.g"; }


     
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




    // $ANTLR start "entryRuleWorkflowElement"
    // InternalBug288760TestLanguage.g:60:1: entryRuleWorkflowElement : ruleWorkflowElement EOF ;
    public final void entryRuleWorkflowElement() throws RecognitionException {
        try {
            // InternalBug288760TestLanguage.g:61:1: ( ruleWorkflowElement EOF )
            // InternalBug288760TestLanguage.g:62:1: ruleWorkflowElement EOF
            {
             before(grammarAccess.getWorkflowElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWorkflowElement();

            state._fsp--;

             after(grammarAccess.getWorkflowElementRule()); 
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
    // $ANTLR end "entryRuleWorkflowElement"


    // $ANTLR start "ruleWorkflowElement"
    // InternalBug288760TestLanguage.g:69:1: ruleWorkflowElement : ( ( rule__WorkflowElement__Alternatives ) ) ;
    public final void ruleWorkflowElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:73:2: ( ( ( rule__WorkflowElement__Alternatives ) ) )
            // InternalBug288760TestLanguage.g:74:1: ( ( rule__WorkflowElement__Alternatives ) )
            {
            // InternalBug288760TestLanguage.g:74:1: ( ( rule__WorkflowElement__Alternatives ) )
            // InternalBug288760TestLanguage.g:75:1: ( rule__WorkflowElement__Alternatives )
            {
             before(grammarAccess.getWorkflowElementAccess().getAlternatives()); 
            // InternalBug288760TestLanguage.g:76:1: ( rule__WorkflowElement__Alternatives )
            // InternalBug288760TestLanguage.g:76:2: rule__WorkflowElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleWorkflowElement"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug288760TestLanguage.g:88:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalBug288760TestLanguage.g:89:1: ( ruleAttribute EOF )
            // InternalBug288760TestLanguage.g:90:1: ruleAttribute EOF
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
    // InternalBug288760TestLanguage.g:97:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:101:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalBug288760TestLanguage.g:102:1: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalBug288760TestLanguage.g:102:1: ( ( rule__Attribute__Group__0 ) )
            // InternalBug288760TestLanguage.g:103:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalBug288760TestLanguage.g:104:1: ( rule__Attribute__Group__0 )
            // InternalBug288760TestLanguage.g:104:2: rule__Attribute__Group__0
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


    // $ANTLR start "rule__WorkflowElement__Alternatives"
    // InternalBug288760TestLanguage.g:116:1: rule__WorkflowElement__Alternatives : ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) );
    public final void rule__WorkflowElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:120:1: ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalBug288760TestLanguage.g:121:1: ( ( rule__WorkflowElement__Group_0__0 ) )
                    {
                    // InternalBug288760TestLanguage.g:121:1: ( ( rule__WorkflowElement__Group_0__0 ) )
                    // InternalBug288760TestLanguage.g:122:1: ( rule__WorkflowElement__Group_0__0 )
                    {
                     before(grammarAccess.getWorkflowElementAccess().getGroup_0()); 
                    // InternalBug288760TestLanguage.g:123:1: ( rule__WorkflowElement__Group_0__0 )
                    // InternalBug288760TestLanguage.g:123:2: rule__WorkflowElement__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__WorkflowElement__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getWorkflowElementAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug288760TestLanguage.g:127:6: ( ( rule__WorkflowElement__Group_1__0 ) )
                    {
                    // InternalBug288760TestLanguage.g:127:6: ( ( rule__WorkflowElement__Group_1__0 ) )
                    // InternalBug288760TestLanguage.g:128:1: ( rule__WorkflowElement__Group_1__0 )
                    {
                     before(grammarAccess.getWorkflowElementAccess().getGroup_1()); 
                    // InternalBug288760TestLanguage.g:129:1: ( rule__WorkflowElement__Group_1__0 )
                    // InternalBug288760TestLanguage.g:129:2: rule__WorkflowElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__WorkflowElement__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__WorkflowElement__Alternatives"


    // $ANTLR start "rule__WorkflowElement__Group_0__0"
    // InternalBug288760TestLanguage.g:140:1: rule__WorkflowElement__Group_0__0 : rule__WorkflowElement__Group_0__0__Impl rule__WorkflowElement__Group_0__1 ;
    public final void rule__WorkflowElement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:144:1: ( rule__WorkflowElement__Group_0__0__Impl rule__WorkflowElement__Group_0__1 )
            // InternalBug288760TestLanguage.g:145:2: rule__WorkflowElement__Group_0__0__Impl rule__WorkflowElement__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__WorkflowElement__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_0__1();

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
    // $ANTLR end "rule__WorkflowElement__Group_0__0"


    // $ANTLR start "rule__WorkflowElement__Group_0__0__Impl"
    // InternalBug288760TestLanguage.g:152:1: rule__WorkflowElement__Group_0__0__Impl : ( ( rule__WorkflowElement__NameAssignment_0_0 ) ) ;
    public final void rule__WorkflowElement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:156:1: ( ( ( rule__WorkflowElement__NameAssignment_0_0 ) ) )
            // InternalBug288760TestLanguage.g:157:1: ( ( rule__WorkflowElement__NameAssignment_0_0 ) )
            {
            // InternalBug288760TestLanguage.g:157:1: ( ( rule__WorkflowElement__NameAssignment_0_0 ) )
            // InternalBug288760TestLanguage.g:158:1: ( rule__WorkflowElement__NameAssignment_0_0 )
            {
             before(grammarAccess.getWorkflowElementAccess().getNameAssignment_0_0()); 
            // InternalBug288760TestLanguage.g:159:1: ( rule__WorkflowElement__NameAssignment_0_0 )
            // InternalBug288760TestLanguage.g:159:2: rule__WorkflowElement__NameAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__NameAssignment_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__WorkflowElement__Group_0__0__Impl"


    // $ANTLR start "rule__WorkflowElement__Group_0__1"
    // InternalBug288760TestLanguage.g:169:1: rule__WorkflowElement__Group_0__1 : rule__WorkflowElement__Group_0__1__Impl rule__WorkflowElement__Group_0__2 ;
    public final void rule__WorkflowElement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:173:1: ( rule__WorkflowElement__Group_0__1__Impl rule__WorkflowElement__Group_0__2 )
            // InternalBug288760TestLanguage.g:174:2: rule__WorkflowElement__Group_0__1__Impl rule__WorkflowElement__Group_0__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__WorkflowElement__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_0__2();

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
    // $ANTLR end "rule__WorkflowElement__Group_0__1"


    // $ANTLR start "rule__WorkflowElement__Group_0__1__Impl"
    // InternalBug288760TestLanguage.g:181:1: rule__WorkflowElement__Group_0__1__Impl : ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* ) ;
    public final void rule__WorkflowElement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:185:1: ( ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* ) )
            // InternalBug288760TestLanguage.g:186:1: ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* )
            {
            // InternalBug288760TestLanguage.g:186:1: ( ( rule__WorkflowElement__AttributesAssignment_0_1 )* )
            // InternalBug288760TestLanguage.g:187:1: ( rule__WorkflowElement__AttributesAssignment_0_1 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_0_1()); 
            // InternalBug288760TestLanguage.g:188:1: ( rule__WorkflowElement__AttributesAssignment_0_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug288760TestLanguage.g:188:2: rule__WorkflowElement__AttributesAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__WorkflowElement__AttributesAssignment_0_1();

            	    state._fsp--;


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
    // $ANTLR end "rule__WorkflowElement__Group_0__1__Impl"


    // $ANTLR start "rule__WorkflowElement__Group_0__2"
    // InternalBug288760TestLanguage.g:198:1: rule__WorkflowElement__Group_0__2 : rule__WorkflowElement__Group_0__2__Impl ;
    public final void rule__WorkflowElement__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:202:1: ( rule__WorkflowElement__Group_0__2__Impl )
            // InternalBug288760TestLanguage.g:203:2: rule__WorkflowElement__Group_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_0__2__Impl();

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
    // $ANTLR end "rule__WorkflowElement__Group_0__2"


    // $ANTLR start "rule__WorkflowElement__Group_0__2__Impl"
    // InternalBug288760TestLanguage.g:209:1: rule__WorkflowElement__Group_0__2__Impl : ( RULE_END_TAG_SHORT ) ;
    public final void rule__WorkflowElement__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:213:1: ( ( RULE_END_TAG_SHORT ) )
            // InternalBug288760TestLanguage.g:214:1: ( RULE_END_TAG_SHORT )
            {
            // InternalBug288760TestLanguage.g:214:1: ( RULE_END_TAG_SHORT )
            // InternalBug288760TestLanguage.g:215:1: RULE_END_TAG_SHORT
            {
             before(grammarAccess.getWorkflowElementAccess().getEND_TAG_SHORTTerminalRuleCall_0_2()); 
            match(input,RULE_END_TAG_SHORT,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__WorkflowElement__Group_0__2__Impl"


    // $ANTLR start "rule__WorkflowElement__Group_1__0"
    // InternalBug288760TestLanguage.g:232:1: rule__WorkflowElement__Group_1__0 : rule__WorkflowElement__Group_1__0__Impl rule__WorkflowElement__Group_1__1 ;
    public final void rule__WorkflowElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:236:1: ( rule__WorkflowElement__Group_1__0__Impl rule__WorkflowElement__Group_1__1 )
            // InternalBug288760TestLanguage.g:237:2: rule__WorkflowElement__Group_1__0__Impl rule__WorkflowElement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__WorkflowElement__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_1__1();

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
    // $ANTLR end "rule__WorkflowElement__Group_1__0"


    // $ANTLR start "rule__WorkflowElement__Group_1__0__Impl"
    // InternalBug288760TestLanguage.g:244:1: rule__WorkflowElement__Group_1__0__Impl : ( ( rule__WorkflowElement__NameAssignment_1_0 ) ) ;
    public final void rule__WorkflowElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:248:1: ( ( ( rule__WorkflowElement__NameAssignment_1_0 ) ) )
            // InternalBug288760TestLanguage.g:249:1: ( ( rule__WorkflowElement__NameAssignment_1_0 ) )
            {
            // InternalBug288760TestLanguage.g:249:1: ( ( rule__WorkflowElement__NameAssignment_1_0 ) )
            // InternalBug288760TestLanguage.g:250:1: ( rule__WorkflowElement__NameAssignment_1_0 )
            {
             before(grammarAccess.getWorkflowElementAccess().getNameAssignment_1_0()); 
            // InternalBug288760TestLanguage.g:251:1: ( rule__WorkflowElement__NameAssignment_1_0 )
            // InternalBug288760TestLanguage.g:251:2: rule__WorkflowElement__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__NameAssignment_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__WorkflowElement__Group_1__0__Impl"


    // $ANTLR start "rule__WorkflowElement__Group_1__1"
    // InternalBug288760TestLanguage.g:261:1: rule__WorkflowElement__Group_1__1 : rule__WorkflowElement__Group_1__1__Impl rule__WorkflowElement__Group_1__2 ;
    public final void rule__WorkflowElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:265:1: ( rule__WorkflowElement__Group_1__1__Impl rule__WorkflowElement__Group_1__2 )
            // InternalBug288760TestLanguage.g:266:2: rule__WorkflowElement__Group_1__1__Impl rule__WorkflowElement__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__WorkflowElement__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_1__2();

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
    // $ANTLR end "rule__WorkflowElement__Group_1__1"


    // $ANTLR start "rule__WorkflowElement__Group_1__1__Impl"
    // InternalBug288760TestLanguage.g:273:1: rule__WorkflowElement__Group_1__1__Impl : ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* ) ;
    public final void rule__WorkflowElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:277:1: ( ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* ) )
            // InternalBug288760TestLanguage.g:278:1: ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* )
            {
            // InternalBug288760TestLanguage.g:278:1: ( ( rule__WorkflowElement__AttributesAssignment_1_1 )* )
            // InternalBug288760TestLanguage.g:279:1: ( rule__WorkflowElement__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_1_1()); 
            // InternalBug288760TestLanguage.g:280:1: ( rule__WorkflowElement__AttributesAssignment_1_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug288760TestLanguage.g:280:2: rule__WorkflowElement__AttributesAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__WorkflowElement__AttributesAssignment_1_1();

            	    state._fsp--;


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
    // $ANTLR end "rule__WorkflowElement__Group_1__1__Impl"


    // $ANTLR start "rule__WorkflowElement__Group_1__2"
    // InternalBug288760TestLanguage.g:290:1: rule__WorkflowElement__Group_1__2 : rule__WorkflowElement__Group_1__2__Impl rule__WorkflowElement__Group_1__3 ;
    public final void rule__WorkflowElement__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:294:1: ( rule__WorkflowElement__Group_1__2__Impl rule__WorkflowElement__Group_1__3 )
            // InternalBug288760TestLanguage.g:295:2: rule__WorkflowElement__Group_1__2__Impl rule__WorkflowElement__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__WorkflowElement__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_1__3();

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
    // $ANTLR end "rule__WorkflowElement__Group_1__2"


    // $ANTLR start "rule__WorkflowElement__Group_1__2__Impl"
    // InternalBug288760TestLanguage.g:302:1: rule__WorkflowElement__Group_1__2__Impl : ( RULE_GT ) ;
    public final void rule__WorkflowElement__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:306:1: ( ( RULE_GT ) )
            // InternalBug288760TestLanguage.g:307:1: ( RULE_GT )
            {
            // InternalBug288760TestLanguage.g:307:1: ( RULE_GT )
            // InternalBug288760TestLanguage.g:308:1: RULE_GT
            {
             before(grammarAccess.getWorkflowElementAccess().getGTTerminalRuleCall_1_2()); 
            match(input,RULE_GT,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__WorkflowElement__Group_1__2__Impl"


    // $ANTLR start "rule__WorkflowElement__Group_1__3"
    // InternalBug288760TestLanguage.g:319:1: rule__WorkflowElement__Group_1__3 : rule__WorkflowElement__Group_1__3__Impl rule__WorkflowElement__Group_1__4 ;
    public final void rule__WorkflowElement__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:323:1: ( rule__WorkflowElement__Group_1__3__Impl rule__WorkflowElement__Group_1__4 )
            // InternalBug288760TestLanguage.g:324:2: rule__WorkflowElement__Group_1__3__Impl rule__WorkflowElement__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__WorkflowElement__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_1__4();

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
    // $ANTLR end "rule__WorkflowElement__Group_1__3"


    // $ANTLR start "rule__WorkflowElement__Group_1__3__Impl"
    // InternalBug288760TestLanguage.g:331:1: rule__WorkflowElement__Group_1__3__Impl : ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* ) ;
    public final void rule__WorkflowElement__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:335:1: ( ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* ) )
            // InternalBug288760TestLanguage.g:336:1: ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* )
            {
            // InternalBug288760TestLanguage.g:336:1: ( ( rule__WorkflowElement__ChildrenAssignment_1_3 )* )
            // InternalBug288760TestLanguage.g:337:1: ( rule__WorkflowElement__ChildrenAssignment_1_3 )*
            {
             before(grammarAccess.getWorkflowElementAccess().getChildrenAssignment_1_3()); 
            // InternalBug288760TestLanguage.g:338:1: ( rule__WorkflowElement__ChildrenAssignment_1_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_START_TAG) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug288760TestLanguage.g:338:2: rule__WorkflowElement__ChildrenAssignment_1_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__WorkflowElement__ChildrenAssignment_1_3();

            	    state._fsp--;


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
    // $ANTLR end "rule__WorkflowElement__Group_1__3__Impl"


    // $ANTLR start "rule__WorkflowElement__Group_1__4"
    // InternalBug288760TestLanguage.g:348:1: rule__WorkflowElement__Group_1__4 : rule__WorkflowElement__Group_1__4__Impl ;
    public final void rule__WorkflowElement__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:352:1: ( rule__WorkflowElement__Group_1__4__Impl )
            // InternalBug288760TestLanguage.g:353:2: rule__WorkflowElement__Group_1__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__Group_1__4__Impl();

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
    // $ANTLR end "rule__WorkflowElement__Group_1__4"


    // $ANTLR start "rule__WorkflowElement__Group_1__4__Impl"
    // InternalBug288760TestLanguage.g:359:1: rule__WorkflowElement__Group_1__4__Impl : ( ( rule__WorkflowElement__EndAssignment_1_4 ) ) ;
    public final void rule__WorkflowElement__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:363:1: ( ( ( rule__WorkflowElement__EndAssignment_1_4 ) ) )
            // InternalBug288760TestLanguage.g:364:1: ( ( rule__WorkflowElement__EndAssignment_1_4 ) )
            {
            // InternalBug288760TestLanguage.g:364:1: ( ( rule__WorkflowElement__EndAssignment_1_4 ) )
            // InternalBug288760TestLanguage.g:365:1: ( rule__WorkflowElement__EndAssignment_1_4 )
            {
             before(grammarAccess.getWorkflowElementAccess().getEndAssignment_1_4()); 
            // InternalBug288760TestLanguage.g:366:1: ( rule__WorkflowElement__EndAssignment_1_4 )
            // InternalBug288760TestLanguage.g:366:2: rule__WorkflowElement__EndAssignment_1_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__WorkflowElement__EndAssignment_1_4();

            state._fsp--;


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
    // $ANTLR end "rule__WorkflowElement__Group_1__4__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalBug288760TestLanguage.g:386:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:390:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalBug288760TestLanguage.g:391:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
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
    // InternalBug288760TestLanguage.g:398:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:402:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // InternalBug288760TestLanguage.g:403:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // InternalBug288760TestLanguage.g:403:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // InternalBug288760TestLanguage.g:404:1: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // InternalBug288760TestLanguage.g:405:1: ( rule__Attribute__NameAssignment_0 )
            // InternalBug288760TestLanguage.g:405:2: rule__Attribute__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__NameAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalBug288760TestLanguage.g:415:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:419:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalBug288760TestLanguage.g:420:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_9);
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
    // InternalBug288760TestLanguage.g:427:1: rule__Attribute__Group__1__Impl : ( RULE_EQ ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:431:1: ( ( RULE_EQ ) )
            // InternalBug288760TestLanguage.g:432:1: ( RULE_EQ )
            {
            // InternalBug288760TestLanguage.g:432:1: ( RULE_EQ )
            // InternalBug288760TestLanguage.g:433:1: RULE_EQ
            {
             before(grammarAccess.getAttributeAccess().getEQTerminalRuleCall_1()); 
            match(input,RULE_EQ,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalBug288760TestLanguage.g:444:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:448:1: ( rule__Attribute__Group__2__Impl )
            // InternalBug288760TestLanguage.g:449:2: rule__Attribute__Group__2__Impl
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
    // InternalBug288760TestLanguage.g:455:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:459:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // InternalBug288760TestLanguage.g:460:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // InternalBug288760TestLanguage.g:460:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // InternalBug288760TestLanguage.g:461:1: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // InternalBug288760TestLanguage.g:462:1: ( rule__Attribute__ValueAssignment_2 )
            // InternalBug288760TestLanguage.g:462:2: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__ValueAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__WorkflowElement__NameAssignment_0_0"
    // InternalBug288760TestLanguage.g:479:1: rule__WorkflowElement__NameAssignment_0_0 : ( RULE_START_TAG ) ;
    public final void rule__WorkflowElement__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:483:1: ( ( RULE_START_TAG ) )
            // InternalBug288760TestLanguage.g:484:1: ( RULE_START_TAG )
            {
            // InternalBug288760TestLanguage.g:484:1: ( RULE_START_TAG )
            // InternalBug288760TestLanguage.g:485:1: RULE_START_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_0_0_0()); 
            match(input,RULE_START_TAG,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__WorkflowElement__NameAssignment_0_0"


    // $ANTLR start "rule__WorkflowElement__AttributesAssignment_0_1"
    // InternalBug288760TestLanguage.g:494:1: rule__WorkflowElement__AttributesAssignment_0_1 : ( ruleAttribute ) ;
    public final void rule__WorkflowElement__AttributesAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:498:1: ( ( ruleAttribute ) )
            // InternalBug288760TestLanguage.g:499:1: ( ruleAttribute )
            {
            // InternalBug288760TestLanguage.g:499:1: ( ruleAttribute )
            // InternalBug288760TestLanguage.g:500:1: ruleAttribute
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAttribute();

            state._fsp--;

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
    // $ANTLR end "rule__WorkflowElement__AttributesAssignment_0_1"


    // $ANTLR start "rule__WorkflowElement__NameAssignment_1_0"
    // InternalBug288760TestLanguage.g:509:1: rule__WorkflowElement__NameAssignment_1_0 : ( RULE_START_TAG ) ;
    public final void rule__WorkflowElement__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:513:1: ( ( RULE_START_TAG ) )
            // InternalBug288760TestLanguage.g:514:1: ( RULE_START_TAG )
            {
            // InternalBug288760TestLanguage.g:514:1: ( RULE_START_TAG )
            // InternalBug288760TestLanguage.g:515:1: RULE_START_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_1_0_0()); 
            match(input,RULE_START_TAG,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__WorkflowElement__NameAssignment_1_0"


    // $ANTLR start "rule__WorkflowElement__AttributesAssignment_1_1"
    // InternalBug288760TestLanguage.g:524:1: rule__WorkflowElement__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__WorkflowElement__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:528:1: ( ( ruleAttribute ) )
            // InternalBug288760TestLanguage.g:529:1: ( ruleAttribute )
            {
            // InternalBug288760TestLanguage.g:529:1: ( ruleAttribute )
            // InternalBug288760TestLanguage.g:530:1: ruleAttribute
            {
             before(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAttribute();

            state._fsp--;

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
    // $ANTLR end "rule__WorkflowElement__AttributesAssignment_1_1"


    // $ANTLR start "rule__WorkflowElement__ChildrenAssignment_1_3"
    // InternalBug288760TestLanguage.g:539:1: rule__WorkflowElement__ChildrenAssignment_1_3 : ( ruleWorkflowElement ) ;
    public final void rule__WorkflowElement__ChildrenAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:543:1: ( ( ruleWorkflowElement ) )
            // InternalBug288760TestLanguage.g:544:1: ( ruleWorkflowElement )
            {
            // InternalBug288760TestLanguage.g:544:1: ( ruleWorkflowElement )
            // InternalBug288760TestLanguage.g:545:1: ruleWorkflowElement
            {
             before(grammarAccess.getWorkflowElementAccess().getChildrenWorkflowElementParserRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleWorkflowElement();

            state._fsp--;

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
    // $ANTLR end "rule__WorkflowElement__ChildrenAssignment_1_3"


    // $ANTLR start "rule__WorkflowElement__EndAssignment_1_4"
    // InternalBug288760TestLanguage.g:554:1: rule__WorkflowElement__EndAssignment_1_4 : ( RULE_END_TAG ) ;
    public final void rule__WorkflowElement__EndAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:558:1: ( ( RULE_END_TAG ) )
            // InternalBug288760TestLanguage.g:559:1: ( RULE_END_TAG )
            {
            // InternalBug288760TestLanguage.g:559:1: ( RULE_END_TAG )
            // InternalBug288760TestLanguage.g:560:1: RULE_END_TAG
            {
             before(grammarAccess.getWorkflowElementAccess().getEndEND_TAGTerminalRuleCall_1_4_0()); 
            match(input,RULE_END_TAG,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__WorkflowElement__EndAssignment_1_4"


    // $ANTLR start "rule__Attribute__NameAssignment_0"
    // InternalBug288760TestLanguage.g:569:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:573:1: ( ( RULE_ID ) )
            // InternalBug288760TestLanguage.g:574:1: ( RULE_ID )
            {
            // InternalBug288760TestLanguage.g:574:1: ( RULE_ID )
            // InternalBug288760TestLanguage.g:575:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__Attribute__NameAssignment_0"


    // $ANTLR start "rule__Attribute__ValueAssignment_2"
    // InternalBug288760TestLanguage.g:584:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288760TestLanguage.g:588:1: ( ( RULE_STRING ) )
            // InternalBug288760TestLanguage.g:589:1: ( RULE_STRING )
            {
            // InternalBug288760TestLanguage.g:589:1: ( RULE_STRING )
            // InternalBug288760TestLanguage.g:590:1: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
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
    // $ANTLR end "rule__Attribute__ValueAssignment_2"

    // Delegated rules


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
            return "116:1: rule__WorkflowElement__Alternatives : ( ( ( rule__WorkflowElement__Group_0__0 ) ) | ( ( rule__WorkflowElement__Group_1__0 ) ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000210L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000202L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000220L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000400L});
    }


}