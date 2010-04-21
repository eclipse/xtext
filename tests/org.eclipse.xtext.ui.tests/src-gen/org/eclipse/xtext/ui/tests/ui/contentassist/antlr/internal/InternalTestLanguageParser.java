package org.eclipse.xtext.ui.tests.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stuff'", "'refs'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g"; }


     
     	private TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:61:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:62:1: ( ruleFile EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:63:1: ruleFile EOF
            {
             before(grammarAccess.getFileRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFile_in_entryRuleFile61);
            ruleFile();
            _fsp--;

             after(grammarAccess.getFileRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFile68); 

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
    // $ANTLR end entryRuleFile


    // $ANTLR start ruleFile
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:70:1: ruleFile : ( ( rule__File__StuffAssignment )* ) ;
    public final void ruleFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:74:2: ( ( ( rule__File__StuffAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:75:1: ( ( rule__File__StuffAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:75:1: ( ( rule__File__StuffAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:76:1: ( rule__File__StuffAssignment )*
            {
             before(grammarAccess.getFileAccess().getStuffAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:77:1: ( rule__File__StuffAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:77:2: rule__File__StuffAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__File__StuffAssignment_in_ruleFile94);
            	    rule__File__StuffAssignment();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFileAccess().getStuffAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleStuff
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:89:1: entryRuleStuff : ruleStuff EOF ;
    public final void entryRuleStuff() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:90:1: ( ruleStuff EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:91:1: ruleStuff EOF
            {
             before(grammarAccess.getStuffRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStuff_in_entryRuleStuff122);
            ruleStuff();
            _fsp--;

             after(grammarAccess.getStuffRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStuff129); 

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
    // $ANTLR end entryRuleStuff


    // $ANTLR start ruleStuff
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:98:1: ruleStuff : ( ( rule__Stuff__Group__0 ) ) ;
    public final void ruleStuff() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:102:2: ( ( ( rule__Stuff__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:103:1: ( ( rule__Stuff__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:103:1: ( ( rule__Stuff__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:104:1: ( rule__Stuff__Group__0 )
            {
             before(grammarAccess.getStuffAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:105:1: ( rule__Stuff__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:105:2: rule__Stuff__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__0_in_ruleStuff155);
            rule__Stuff__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStuffAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStuff


    // $ANTLR start rule__Stuff__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:119:1: rule__Stuff__Group__0 : rule__Stuff__Group__0__Impl rule__Stuff__Group__1 ;
    public final void rule__Stuff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:123:1: ( rule__Stuff__Group__0__Impl rule__Stuff__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:124:2: rule__Stuff__Group__0__Impl rule__Stuff__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__0__Impl_in_rule__Stuff__Group__0189);
            rule__Stuff__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__1_in_rule__Stuff__Group__0192);
            rule__Stuff__Group__1();
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
    // $ANTLR end rule__Stuff__Group__0


    // $ANTLR start rule__Stuff__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:131:1: rule__Stuff__Group__0__Impl : ( 'stuff' ) ;
    public final void rule__Stuff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:135:1: ( ( 'stuff' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:136:1: ( 'stuff' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:136:1: ( 'stuff' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:137:1: 'stuff'
            {
             before(grammarAccess.getStuffAccess().getStuffKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Stuff__Group__0__Impl220); 
             after(grammarAccess.getStuffAccess().getStuffKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Stuff__Group__0__Impl


    // $ANTLR start rule__Stuff__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:150:1: rule__Stuff__Group__1 : rule__Stuff__Group__1__Impl rule__Stuff__Group__2 ;
    public final void rule__Stuff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:154:1: ( rule__Stuff__Group__1__Impl rule__Stuff__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:155:2: rule__Stuff__Group__1__Impl rule__Stuff__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__1__Impl_in_rule__Stuff__Group__1251);
            rule__Stuff__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__2_in_rule__Stuff__Group__1254);
            rule__Stuff__Group__2();
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
    // $ANTLR end rule__Stuff__Group__1


    // $ANTLR start rule__Stuff__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:162:1: rule__Stuff__Group__1__Impl : ( ( rule__Stuff__NameAssignment_1 ) ) ;
    public final void rule__Stuff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:166:1: ( ( ( rule__Stuff__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:167:1: ( ( rule__Stuff__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:167:1: ( ( rule__Stuff__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:168:1: ( rule__Stuff__NameAssignment_1 )
            {
             before(grammarAccess.getStuffAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:169:1: ( rule__Stuff__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:169:2: rule__Stuff__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__NameAssignment_1_in_rule__Stuff__Group__1__Impl281);
            rule__Stuff__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStuffAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Stuff__Group__1__Impl


    // $ANTLR start rule__Stuff__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:179:1: rule__Stuff__Group__2 : rule__Stuff__Group__2__Impl ;
    public final void rule__Stuff__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:183:1: ( rule__Stuff__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:184:2: rule__Stuff__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__2__Impl_in_rule__Stuff__Group__2311);
            rule__Stuff__Group__2__Impl();
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
    // $ANTLR end rule__Stuff__Group__2


    // $ANTLR start rule__Stuff__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:190:1: rule__Stuff__Group__2__Impl : ( ( rule__Stuff__Group_2__0 )? ) ;
    public final void rule__Stuff__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:194:1: ( ( ( rule__Stuff__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:195:1: ( ( rule__Stuff__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:195:1: ( ( rule__Stuff__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:196:1: ( rule__Stuff__Group_2__0 )?
            {
             before(grammarAccess.getStuffAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:197:1: ( rule__Stuff__Group_2__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:197:2: rule__Stuff__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group_2__0_in_rule__Stuff__Group__2__Impl338);
                    rule__Stuff__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStuffAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Stuff__Group__2__Impl


    // $ANTLR start rule__Stuff__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:213:1: rule__Stuff__Group_2__0 : rule__Stuff__Group_2__0__Impl rule__Stuff__Group_2__1 ;
    public final void rule__Stuff__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:217:1: ( rule__Stuff__Group_2__0__Impl rule__Stuff__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:218:2: rule__Stuff__Group_2__0__Impl rule__Stuff__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group_2__0__Impl_in_rule__Stuff__Group_2__0375);
            rule__Stuff__Group_2__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group_2__1_in_rule__Stuff__Group_2__0378);
            rule__Stuff__Group_2__1();
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
    // $ANTLR end rule__Stuff__Group_2__0


    // $ANTLR start rule__Stuff__Group_2__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:225:1: rule__Stuff__Group_2__0__Impl : ( 'refs' ) ;
    public final void rule__Stuff__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:229:1: ( ( 'refs' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:230:1: ( 'refs' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:230:1: ( 'refs' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:231:1: 'refs'
            {
             before(grammarAccess.getStuffAccess().getRefsKeyword_2_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Stuff__Group_2__0__Impl406); 
             after(grammarAccess.getStuffAccess().getRefsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Stuff__Group_2__0__Impl


    // $ANTLR start rule__Stuff__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:244:1: rule__Stuff__Group_2__1 : rule__Stuff__Group_2__1__Impl ;
    public final void rule__Stuff__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:248:1: ( rule__Stuff__Group_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:249:2: rule__Stuff__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group_2__1__Impl_in_rule__Stuff__Group_2__1437);
            rule__Stuff__Group_2__1__Impl();
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
    // $ANTLR end rule__Stuff__Group_2__1


    // $ANTLR start rule__Stuff__Group_2__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:255:1: rule__Stuff__Group_2__1__Impl : ( ( rule__Stuff__RefsAssignment_2_1 ) ) ;
    public final void rule__Stuff__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:259:1: ( ( ( rule__Stuff__RefsAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:260:1: ( ( rule__Stuff__RefsAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:260:1: ( ( rule__Stuff__RefsAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:261:1: ( rule__Stuff__RefsAssignment_2_1 )
            {
             before(grammarAccess.getStuffAccess().getRefsAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:262:1: ( rule__Stuff__RefsAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:262:2: rule__Stuff__RefsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__RefsAssignment_2_1_in_rule__Stuff__Group_2__1__Impl464);
            rule__Stuff__RefsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getStuffAccess().getRefsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Stuff__Group_2__1__Impl


    // $ANTLR start rule__File__StuffAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:277:1: rule__File__StuffAssignment : ( ruleStuff ) ;
    public final void rule__File__StuffAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:281:1: ( ( ruleStuff ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:282:1: ( ruleStuff )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:282:1: ( ruleStuff )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:283:1: ruleStuff
            {
             before(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleStuff_in_rule__File__StuffAssignment503);
            ruleStuff();
            _fsp--;

             after(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__File__StuffAssignment


    // $ANTLR start rule__Stuff__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:292:1: rule__Stuff__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stuff__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:296:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:297:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:297:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:298:1: RULE_ID
            {
             before(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Stuff__NameAssignment_1534); 
             after(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Stuff__NameAssignment_1


    // $ANTLR start rule__Stuff__RefsAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:307:1: rule__Stuff__RefsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Stuff__RefsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:311:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:312:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:312:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:313:1: ( RULE_ID )
            {
             before(grammarAccess.getStuffAccess().getRefsStuffCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:314:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/ui/contentassist/antlr/internal/InternalTestLanguage.g:315:1: RULE_ID
            {
             before(grammarAccess.getStuffAccess().getRefsStuffIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Stuff__RefsAssignment_2_1569); 
             after(grammarAccess.getStuffAccess().getRefsStuffIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getStuffAccess().getRefsStuffCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Stuff__RefsAssignment_2_1


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFile_in_entryRuleFile61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFile68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__File__StuffAssignment_in_ruleFile94 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStuff129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group__0_in_ruleStuff155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group__0__Impl_in_rule__Stuff__Group__0189 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Stuff__Group__1_in_rule__Stuff__Group__0192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Stuff__Group__0__Impl220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group__1__Impl_in_rule__Stuff__Group__1251 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__Stuff__Group__2_in_rule__Stuff__Group__1254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__NameAssignment_1_in_rule__Stuff__Group__1__Impl281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group__2__Impl_in_rule__Stuff__Group__2311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group_2__0_in_rule__Stuff__Group__2__Impl338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group_2__0__Impl_in_rule__Stuff__Group_2__0375 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Stuff__Group_2__1_in_rule__Stuff__Group_2__0378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Stuff__Group_2__0__Impl406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group_2__1__Impl_in_rule__Stuff__Group_2__1437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__RefsAssignment_2_1_in_rule__Stuff__Group_2__1__Impl464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStuff_in_rule__File__StuffAssignment503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Stuff__NameAssignment_1534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Stuff__RefsAssignment_2_1569 = new BitSet(new long[]{0x0000000000000002L});
    }


}