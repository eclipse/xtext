package org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReferringTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ref'", "'='", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalReferringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReferringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReferringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReferringTestLanguage.g"; }


    	private ReferringTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(ReferringTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleMain"
    // InternalReferringTestLanguage.g:53:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:54:1: ( ruleMain EOF )
            // InternalReferringTestLanguage.g:55:1: ruleMain EOF
            {
             before(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMain();

            state._fsp--;

             after(grammarAccess.getMainRule()); 
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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // InternalReferringTestLanguage.g:62:1: ruleMain : ( ( rule__Main__ReferencedAssignment )* ) ;
    public final void ruleMain() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:66:2: ( ( ( rule__Main__ReferencedAssignment )* ) )
            // InternalReferringTestLanguage.g:67:2: ( ( rule__Main__ReferencedAssignment )* )
            {
            // InternalReferringTestLanguage.g:67:2: ( ( rule__Main__ReferencedAssignment )* )
            // InternalReferringTestLanguage.g:68:3: ( rule__Main__ReferencedAssignment )*
            {
             before(grammarAccess.getMainAccess().getReferencedAssignment()); 
            // InternalReferringTestLanguage.g:69:3: ( rule__Main__ReferencedAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalReferringTestLanguage.g:69:4: rule__Main__ReferencedAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Main__ReferencedAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getMainAccess().getReferencedAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleAbstractReference"
    // InternalReferringTestLanguage.g:78:1: entryRuleAbstractReference : ruleAbstractReference EOF ;
    public final void entryRuleAbstractReference() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:79:1: ( ruleAbstractReference EOF )
            // InternalReferringTestLanguage.g:80:1: ruleAbstractReference EOF
            {
             before(grammarAccess.getAbstractReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractReference();

            state._fsp--;

             after(grammarAccess.getAbstractReferenceRule()); 
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
    // $ANTLR end "entryRuleAbstractReference"


    // $ANTLR start "ruleAbstractReference"
    // InternalReferringTestLanguage.g:87:1: ruleAbstractReference : ( ( rule__AbstractReference__Alternatives ) ) ;
    public final void ruleAbstractReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:91:2: ( ( ( rule__AbstractReference__Alternatives ) ) )
            // InternalReferringTestLanguage.g:92:2: ( ( rule__AbstractReference__Alternatives ) )
            {
            // InternalReferringTestLanguage.g:92:2: ( ( rule__AbstractReference__Alternatives ) )
            // InternalReferringTestLanguage.g:93:3: ( rule__AbstractReference__Alternatives )
            {
             before(grammarAccess.getAbstractReferenceAccess().getAlternatives()); 
            // InternalReferringTestLanguage.g:94:3: ( rule__AbstractReference__Alternatives )
            // InternalReferringTestLanguage.g:94:4: rule__AbstractReference__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractReference__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractReferenceAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractReference"


    // $ANTLR start "entryRuleReference"
    // InternalReferringTestLanguage.g:103:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:104:1: ( ruleReference EOF )
            // InternalReferringTestLanguage.g:105:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalReferringTestLanguage.g:112:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:116:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalReferringTestLanguage.g:117:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalReferringTestLanguage.g:117:2: ( ( rule__Reference__Group__0 ) )
            // InternalReferringTestLanguage.g:118:3: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // InternalReferringTestLanguage.g:119:3: ( rule__Reference__Group__0 )
            // InternalReferringTestLanguage.g:119:4: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleReference2"
    // InternalReferringTestLanguage.g:128:1: entryRuleReference2 : ruleReference2 EOF ;
    public final void entryRuleReference2() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:129:1: ( ruleReference2 EOF )
            // InternalReferringTestLanguage.g:130:1: ruleReference2 EOF
            {
             before(grammarAccess.getReference2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference2();

            state._fsp--;

             after(grammarAccess.getReference2Rule()); 
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
    // $ANTLR end "entryRuleReference2"


    // $ANTLR start "ruleReference2"
    // InternalReferringTestLanguage.g:137:1: ruleReference2 : ( ( rule__Reference2__Group__0 ) ) ;
    public final void ruleReference2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:141:2: ( ( ( rule__Reference2__Group__0 ) ) )
            // InternalReferringTestLanguage.g:142:2: ( ( rule__Reference2__Group__0 ) )
            {
            // InternalReferringTestLanguage.g:142:2: ( ( rule__Reference2__Group__0 ) )
            // InternalReferringTestLanguage.g:143:3: ( rule__Reference2__Group__0 )
            {
             before(grammarAccess.getReference2Access().getGroup()); 
            // InternalReferringTestLanguage.g:144:3: ( rule__Reference2__Group__0 )
            // InternalReferringTestLanguage.g:144:4: rule__Reference2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReference2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference2"


    // $ANTLR start "entryRuleNamed"
    // InternalReferringTestLanguage.g:153:1: entryRuleNamed : ruleNamed EOF ;
    public final void entryRuleNamed() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:154:1: ( ruleNamed EOF )
            // InternalReferringTestLanguage.g:155:1: ruleNamed EOF
            {
             before(grammarAccess.getNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamed();

            state._fsp--;

             after(grammarAccess.getNamedRule()); 
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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // InternalReferringTestLanguage.g:162:1: ruleNamed : ( ( rule__Named__NameAssignment ) ) ;
    public final void ruleNamed() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:166:2: ( ( ( rule__Named__NameAssignment ) ) )
            // InternalReferringTestLanguage.g:167:2: ( ( rule__Named__NameAssignment ) )
            {
            // InternalReferringTestLanguage.g:167:2: ( ( rule__Named__NameAssignment ) )
            // InternalReferringTestLanguage.g:168:3: ( rule__Named__NameAssignment )
            {
             before(grammarAccess.getNamedAccess().getNameAssignment()); 
            // InternalReferringTestLanguage.g:169:3: ( rule__Named__NameAssignment )
            // InternalReferringTestLanguage.g:169:4: rule__Named__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Named__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNamedAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamed"


    // $ANTLR start "entryRuleFQN"
    // InternalReferringTestLanguage.g:178:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // InternalReferringTestLanguage.g:179:1: ( ruleFQN EOF )
            // InternalReferringTestLanguage.g:180:1: ruleFQN EOF
            {
             before(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getFQNRule()); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalReferringTestLanguage.g:187:1: ruleFQN : ( ( rule__FQN__Group__0 ) ) ;
    public final void ruleFQN() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:191:2: ( ( ( rule__FQN__Group__0 ) ) )
            // InternalReferringTestLanguage.g:192:2: ( ( rule__FQN__Group__0 ) )
            {
            // InternalReferringTestLanguage.g:192:2: ( ( rule__FQN__Group__0 ) )
            // InternalReferringTestLanguage.g:193:3: ( rule__FQN__Group__0 )
            {
             before(grammarAccess.getFQNAccess().getGroup()); 
            // InternalReferringTestLanguage.g:194:3: ( rule__FQN__Group__0 )
            // InternalReferringTestLanguage.g:194:4: rule__FQN__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFQNAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "rule__AbstractReference__Alternatives"
    // InternalReferringTestLanguage.g:202:1: rule__AbstractReference__Alternatives : ( ( ruleReference ) | ( ruleReference2 ) );
    public final void rule__AbstractReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:206:1: ( ( ruleReference ) | ( ruleReference2 ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalReferringTestLanguage.g:207:2: ( ruleReference )
                    {
                    // InternalReferringTestLanguage.g:207:2: ( ruleReference )
                    // InternalReferringTestLanguage.g:208:3: ruleReference
                    {
                     before(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalReferringTestLanguage.g:213:2: ( ruleReference2 )
                    {
                    // InternalReferringTestLanguage.g:213:2: ( ruleReference2 )
                    // InternalReferringTestLanguage.g:214:3: ruleReference2
                    {
                     before(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference2();

                    state._fsp--;

                     after(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractReference__Alternatives"


    // $ANTLR start "rule__Reference__Group__0"
    // InternalReferringTestLanguage.g:223:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:227:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalReferringTestLanguage.g:228:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__1();

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
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // InternalReferringTestLanguage.g:235:1: rule__Reference__Group__0__Impl : ( 'ref' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:239:1: ( ( 'ref' ) )
            // InternalReferringTestLanguage.g:240:1: ( 'ref' )
            {
            // InternalReferringTestLanguage.g:240:1: ( 'ref' )
            // InternalReferringTestLanguage.g:241:2: 'ref'
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // InternalReferringTestLanguage.g:250:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:254:1: ( rule__Reference__Group__1__Impl )
            // InternalReferringTestLanguage.g:255:2: rule__Reference__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__1__Impl();

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
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // InternalReferringTestLanguage.g:261:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__ReferencedAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:265:1: ( ( ( rule__Reference__ReferencedAssignment_1 ) ) )
            // InternalReferringTestLanguage.g:266:1: ( ( rule__Reference__ReferencedAssignment_1 ) )
            {
            // InternalReferringTestLanguage.g:266:1: ( ( rule__Reference__ReferencedAssignment_1 ) )
            // InternalReferringTestLanguage.g:267:2: ( rule__Reference__ReferencedAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); 
            // InternalReferringTestLanguage.g:268:2: ( rule__Reference__ReferencedAssignment_1 )
            // InternalReferringTestLanguage.g:268:3: rule__Reference__ReferencedAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__ReferencedAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference2__Group__0"
    // InternalReferringTestLanguage.g:277:1: rule__Reference2__Group__0 : rule__Reference2__Group__0__Impl rule__Reference2__Group__1 ;
    public final void rule__Reference2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:281:1: ( rule__Reference2__Group__0__Impl rule__Reference2__Group__1 )
            // InternalReferringTestLanguage.g:282:2: rule__Reference2__Group__0__Impl rule__Reference2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__1();

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
    // $ANTLR end "rule__Reference2__Group__0"


    // $ANTLR start "rule__Reference2__Group__0__Impl"
    // InternalReferringTestLanguage.g:289:1: rule__Reference2__Group__0__Impl : ( ruleNamed ) ;
    public final void rule__Reference2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:293:1: ( ( ruleNamed ) )
            // InternalReferringTestLanguage.g:294:1: ( ruleNamed )
            {
            // InternalReferringTestLanguage.g:294:1: ( ruleNamed )
            // InternalReferringTestLanguage.g:295:2: ruleNamed
            {
             before(grammarAccess.getReference2Access().getNamedParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamed();

            state._fsp--;

             after(grammarAccess.getReference2Access().getNamedParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__0__Impl"


    // $ANTLR start "rule__Reference2__Group__1"
    // InternalReferringTestLanguage.g:304:1: rule__Reference2__Group__1 : rule__Reference2__Group__1__Impl rule__Reference2__Group__2 ;
    public final void rule__Reference2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:308:1: ( rule__Reference2__Group__1__Impl rule__Reference2__Group__2 )
            // InternalReferringTestLanguage.g:309:2: rule__Reference2__Group__1__Impl rule__Reference2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__2();

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
    // $ANTLR end "rule__Reference2__Group__1"


    // $ANTLR start "rule__Reference2__Group__1__Impl"
    // InternalReferringTestLanguage.g:316:1: rule__Reference2__Group__1__Impl : ( '=' ) ;
    public final void rule__Reference2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:320:1: ( ( '=' ) )
            // InternalReferringTestLanguage.g:321:1: ( '=' )
            {
            // InternalReferringTestLanguage.g:321:1: ( '=' )
            // InternalReferringTestLanguage.g:322:2: '='
            {
             before(grammarAccess.getReference2Access().getEqualsSignKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReference2Access().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__1__Impl"


    // $ANTLR start "rule__Reference2__Group__2"
    // InternalReferringTestLanguage.g:331:1: rule__Reference2__Group__2 : rule__Reference2__Group__2__Impl ;
    public final void rule__Reference2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:335:1: ( rule__Reference2__Group__2__Impl )
            // InternalReferringTestLanguage.g:336:2: rule__Reference2__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__2__Impl();

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
    // $ANTLR end "rule__Reference2__Group__2"


    // $ANTLR start "rule__Reference2__Group__2__Impl"
    // InternalReferringTestLanguage.g:342:1: rule__Reference2__Group__2__Impl : ( ( rule__Reference2__ReferencedAssignment_2 ) ) ;
    public final void rule__Reference2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:346:1: ( ( ( rule__Reference2__ReferencedAssignment_2 ) ) )
            // InternalReferringTestLanguage.g:347:1: ( ( rule__Reference2__ReferencedAssignment_2 ) )
            {
            // InternalReferringTestLanguage.g:347:1: ( ( rule__Reference2__ReferencedAssignment_2 ) )
            // InternalReferringTestLanguage.g:348:2: ( rule__Reference2__ReferencedAssignment_2 )
            {
             before(grammarAccess.getReference2Access().getReferencedAssignment_2()); 
            // InternalReferringTestLanguage.g:349:2: ( rule__Reference2__ReferencedAssignment_2 )
            // InternalReferringTestLanguage.g:349:3: rule__Reference2__ReferencedAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__ReferencedAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReference2Access().getReferencedAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__2__Impl"


    // $ANTLR start "rule__FQN__Group__0"
    // InternalReferringTestLanguage.g:358:1: rule__FQN__Group__0 : rule__FQN__Group__0__Impl rule__FQN__Group__1 ;
    public final void rule__FQN__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:362:1: ( rule__FQN__Group__0__Impl rule__FQN__Group__1 )
            // InternalReferringTestLanguage.g:363:2: rule__FQN__Group__0__Impl rule__FQN__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__FQN__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__1();

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
    // $ANTLR end "rule__FQN__Group__0"


    // $ANTLR start "rule__FQN__Group__0__Impl"
    // InternalReferringTestLanguage.g:370:1: rule__FQN__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:374:1: ( ( RULE_ID ) )
            // InternalReferringTestLanguage.g:375:1: ( RULE_ID )
            {
            // InternalReferringTestLanguage.g:375:1: ( RULE_ID )
            // InternalReferringTestLanguage.g:376:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__0__Impl"


    // $ANTLR start "rule__FQN__Group__1"
    // InternalReferringTestLanguage.g:385:1: rule__FQN__Group__1 : rule__FQN__Group__1__Impl ;
    public final void rule__FQN__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:389:1: ( rule__FQN__Group__1__Impl )
            // InternalReferringTestLanguage.g:390:2: rule__FQN__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group__1__Impl();

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
    // $ANTLR end "rule__FQN__Group__1"


    // $ANTLR start "rule__FQN__Group__1__Impl"
    // InternalReferringTestLanguage.g:396:1: rule__FQN__Group__1__Impl : ( ( rule__FQN__Group_1__0 )* ) ;
    public final void rule__FQN__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:400:1: ( ( ( rule__FQN__Group_1__0 )* ) )
            // InternalReferringTestLanguage.g:401:1: ( ( rule__FQN__Group_1__0 )* )
            {
            // InternalReferringTestLanguage.g:401:1: ( ( rule__FQN__Group_1__0 )* )
            // InternalReferringTestLanguage.g:402:2: ( rule__FQN__Group_1__0 )*
            {
             before(grammarAccess.getFQNAccess().getGroup_1()); 
            // InternalReferringTestLanguage.g:403:2: ( rule__FQN__Group_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReferringTestLanguage.g:403:3: rule__FQN__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__FQN__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getFQNAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group__1__Impl"


    // $ANTLR start "rule__FQN__Group_1__0"
    // InternalReferringTestLanguage.g:412:1: rule__FQN__Group_1__0 : rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 ;
    public final void rule__FQN__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:416:1: ( rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1 )
            // InternalReferringTestLanguage.g:417:2: rule__FQN__Group_1__0__Impl rule__FQN__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__FQN__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__1();

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
    // $ANTLR end "rule__FQN__Group_1__0"


    // $ANTLR start "rule__FQN__Group_1__0__Impl"
    // InternalReferringTestLanguage.g:424:1: rule__FQN__Group_1__0__Impl : ( '.' ) ;
    public final void rule__FQN__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:428:1: ( ( '.' ) )
            // InternalReferringTestLanguage.g:429:1: ( '.' )
            {
            // InternalReferringTestLanguage.g:429:1: ( '.' )
            // InternalReferringTestLanguage.g:430:2: '.'
            {
             before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__0__Impl"


    // $ANTLR start "rule__FQN__Group_1__1"
    // InternalReferringTestLanguage.g:439:1: rule__FQN__Group_1__1 : rule__FQN__Group_1__1__Impl ;
    public final void rule__FQN__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:443:1: ( rule__FQN__Group_1__1__Impl )
            // InternalReferringTestLanguage.g:444:2: rule__FQN__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__FQN__Group_1__1__Impl();

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
    // $ANTLR end "rule__FQN__Group_1__1"


    // $ANTLR start "rule__FQN__Group_1__1__Impl"
    // InternalReferringTestLanguage.g:450:1: rule__FQN__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FQN__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:454:1: ( ( RULE_ID ) )
            // InternalReferringTestLanguage.g:455:1: ( RULE_ID )
            {
            // InternalReferringTestLanguage.g:455:1: ( RULE_ID )
            // InternalReferringTestLanguage.g:456:2: RULE_ID
            {
             before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FQN__Group_1__1__Impl"


    // $ANTLR start "rule__Main__ReferencedAssignment"
    // InternalReferringTestLanguage.g:466:1: rule__Main__ReferencedAssignment : ( ruleAbstractReference ) ;
    public final void rule__Main__ReferencedAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:470:1: ( ( ruleAbstractReference ) )
            // InternalReferringTestLanguage.g:471:2: ( ruleAbstractReference )
            {
            // InternalReferringTestLanguage.g:471:2: ( ruleAbstractReference )
            // InternalReferringTestLanguage.g:472:3: ruleAbstractReference
            {
             before(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractReference();

            state._fsp--;

             after(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Main__ReferencedAssignment"


    // $ANTLR start "rule__Reference__ReferencedAssignment_1"
    // InternalReferringTestLanguage.g:481:1: rule__Reference__ReferencedAssignment_1 : ( ( ruleFQN ) ) ;
    public final void rule__Reference__ReferencedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:485:1: ( ( ( ruleFQN ) ) )
            // InternalReferringTestLanguage.g:486:2: ( ( ruleFQN ) )
            {
            // InternalReferringTestLanguage.g:486:2: ( ( ruleFQN ) )
            // InternalReferringTestLanguage.g:487:3: ( ruleFQN )
            {
             before(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); 
            // InternalReferringTestLanguage.g:488:3: ( ruleFQN )
            // InternalReferringTestLanguage.g:489:4: ruleFQN
            {
             before(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__ReferencedAssignment_1"


    // $ANTLR start "rule__Reference2__ReferencedAssignment_2"
    // InternalReferringTestLanguage.g:500:1: rule__Reference2__ReferencedAssignment_2 : ( ( ruleFQN ) ) ;
    public final void rule__Reference2__ReferencedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:504:1: ( ( ( ruleFQN ) ) )
            // InternalReferringTestLanguage.g:505:2: ( ( ruleFQN ) )
            {
            // InternalReferringTestLanguage.g:505:2: ( ( ruleFQN ) )
            // InternalReferringTestLanguage.g:506:3: ( ruleFQN )
            {
             before(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0()); 
            // InternalReferringTestLanguage.g:507:3: ( ruleFQN )
            // InternalReferringTestLanguage.g:508:4: ruleFQN
            {
             before(grammarAccess.getReference2Access().getReferencedEObjectFQNParserRuleCall_2_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             after(grammarAccess.getReference2Access().getReferencedEObjectFQNParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__ReferencedAssignment_2"


    // $ANTLR start "rule__Named__NameAssignment"
    // InternalReferringTestLanguage.g:519:1: rule__Named__NameAssignment : ( RULE_ID ) ;
    public final void rule__Named__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalReferringTestLanguage.g:523:1: ( ( RULE_ID ) )
            // InternalReferringTestLanguage.g:524:2: ( RULE_ID )
            {
            // InternalReferringTestLanguage.g:524:2: ( RULE_ID )
            // InternalReferringTestLanguage.g:525:3: RULE_ID
            {
             before(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Named__NameAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
    }


}