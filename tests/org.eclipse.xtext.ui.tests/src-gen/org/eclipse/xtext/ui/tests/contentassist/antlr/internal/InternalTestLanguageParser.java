package org.eclipse.xtext.ui.tests.contentassist.antlr.internal; 

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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:60:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:61:1: ( ruleFile EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:62:1: ruleFile EOF
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:69:1: ruleFile : ( ( rule__File__StuffAssignment )* ) ;
    public final void ruleFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:73:2: ( ( ( rule__File__StuffAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:74:1: ( ( rule__File__StuffAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:74:1: ( ( rule__File__StuffAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:75:1: ( rule__File__StuffAssignment )*
            {
             before(grammarAccess.getFileAccess().getStuffAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:76:1: ( rule__File__StuffAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:76:2: rule__File__StuffAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__File__StuffAssignment_in_ruleFile95);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:88:1: entryRuleStuff : ruleStuff EOF ;
    public final void entryRuleStuff() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:89:1: ( ruleStuff EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:90:1: ruleStuff EOF
            {
             before(grammarAccess.getStuffRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStuff_in_entryRuleStuff123);
            ruleStuff();
            _fsp--;

             after(grammarAccess.getStuffRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStuff130); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:97:1: ruleStuff : ( ( rule__Stuff__Group__0 ) ) ;
    public final void ruleStuff() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:101:2: ( ( ( rule__Stuff__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:102:1: ( ( rule__Stuff__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:102:1: ( ( rule__Stuff__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:103:1: ( rule__Stuff__Group__0 )
            {
             before(grammarAccess.getStuffAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:104:1: ( rule__Stuff__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:104:2: rule__Stuff__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__0_in_ruleStuff157);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:118:1: rule__Stuff__Group__0 : ( 'stuff' ) rule__Stuff__Group__1 ;
    public final void rule__Stuff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:122:1: ( ( 'stuff' ) rule__Stuff__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:123:1: ( 'stuff' ) rule__Stuff__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:123:1: ( 'stuff' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:124:1: 'stuff'
            {
             before(grammarAccess.getStuffAccess().getStuffKeyword_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Stuff__Group__0196); 
             after(grammarAccess.getStuffAccess().getStuffKeyword_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__1_in_rule__Stuff__Group__0206);
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


    // $ANTLR start rule__Stuff__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:138:1: rule__Stuff__Group__1 : ( ( rule__Stuff__NameAssignment_1 ) ) rule__Stuff__Group__2 ;
    public final void rule__Stuff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:142:1: ( ( ( rule__Stuff__NameAssignment_1 ) ) rule__Stuff__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:143:1: ( ( rule__Stuff__NameAssignment_1 ) ) rule__Stuff__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:143:1: ( ( rule__Stuff__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:144:1: ( rule__Stuff__NameAssignment_1 )
            {
             before(grammarAccess.getStuffAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:145:1: ( rule__Stuff__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:145:2: rule__Stuff__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__NameAssignment_1_in_rule__Stuff__Group__1234);
            rule__Stuff__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getStuffAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group__2_in_rule__Stuff__Group__1243);
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


    // $ANTLR start rule__Stuff__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:156:1: rule__Stuff__Group__2 : ( ( rule__Stuff__Group_2__0 )? ) ;
    public final void rule__Stuff__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:160:1: ( ( ( rule__Stuff__Group_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:161:1: ( ( rule__Stuff__Group_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:161:1: ( ( rule__Stuff__Group_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:162:1: ( rule__Stuff__Group_2__0 )?
            {
             before(grammarAccess.getStuffAccess().getGroup_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:163:1: ( rule__Stuff__Group_2__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:163:2: rule__Stuff__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group_2__0_in_rule__Stuff__Group__2271);
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
    // $ANTLR end rule__Stuff__Group__2


    // $ANTLR start rule__Stuff__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:179:1: rule__Stuff__Group_2__0 : ( 'refs' ) rule__Stuff__Group_2__1 ;
    public final void rule__Stuff__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:183:1: ( ( 'refs' ) rule__Stuff__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:184:1: ( 'refs' ) rule__Stuff__Group_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:184:1: ( 'refs' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:185:1: 'refs'
            {
             before(grammarAccess.getStuffAccess().getRefsKeyword_2_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Stuff__Group_2__0313); 
             after(grammarAccess.getStuffAccess().getRefsKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Stuff__Group_2__1_in_rule__Stuff__Group_2__0323);
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


    // $ANTLR start rule__Stuff__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:199:1: rule__Stuff__Group_2__1 : ( ( rule__Stuff__RefsAssignment_2_1 ) ) ;
    public final void rule__Stuff__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:203:1: ( ( ( rule__Stuff__RefsAssignment_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:204:1: ( ( rule__Stuff__RefsAssignment_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:204:1: ( ( rule__Stuff__RefsAssignment_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:205:1: ( rule__Stuff__RefsAssignment_2_1 )
            {
             before(grammarAccess.getStuffAccess().getRefsAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:206:1: ( rule__Stuff__RefsAssignment_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:206:2: rule__Stuff__RefsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Stuff__RefsAssignment_2_1_in_rule__Stuff__Group_2__1351);
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
    // $ANTLR end rule__Stuff__Group_2__1


    // $ANTLR start rule__File__StuffAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:221:1: rule__File__StuffAssignment : ( ruleStuff ) ;
    public final void rule__File__StuffAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:225:1: ( ( ruleStuff ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:226:1: ( ruleStuff )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:226:1: ( ruleStuff )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:227:1: ruleStuff
            {
             before(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleStuff_in_rule__File__StuffAssignment390);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:236:1: rule__Stuff__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stuff__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:240:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:241:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:241:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:242:1: RULE_ID
            {
             before(grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Stuff__NameAssignment_1421); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:251:1: rule__Stuff__RefsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Stuff__RefsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:255:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:256:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:256:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:257:1: ( RULE_ID )
            {
             before(grammarAccess.getStuffAccess().getRefsStuffCrossReference_2_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:258:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/contentassist/antlr/internal/InternalTestLanguage.g:259:1: RULE_ID
            {
             before(grammarAccess.getStuffAccess().getRefsStuffIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Stuff__RefsAssignment_2_1456); 
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
        public static final BitSet FOLLOW_rule__File__StuffAssignment_in_ruleFile95 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff123 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStuff130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group__0_in_ruleStuff157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Stuff__Group__0196 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Stuff__Group__1_in_rule__Stuff__Group__0206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__NameAssignment_1_in_rule__Stuff__Group__1234 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__Stuff__Group__2_in_rule__Stuff__Group__1243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__Group_2__0_in_rule__Stuff__Group__2271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Stuff__Group_2__0313 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Stuff__Group_2__1_in_rule__Stuff__Group_2__0323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Stuff__RefsAssignment_2_1_in_rule__Stuff__Group_2__1351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStuff_in_rule__File__StuffAssignment390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Stuff__NameAssignment_1421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Stuff__RefsAssignment_2_1456 = new BitSet(new long[]{0x0000000000000002L});
    }


}