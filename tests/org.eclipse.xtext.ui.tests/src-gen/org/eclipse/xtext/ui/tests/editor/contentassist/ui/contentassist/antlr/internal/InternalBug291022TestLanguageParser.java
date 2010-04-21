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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug291022TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug291022TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'{'", "'}'", "':'", "'='"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug291022TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g"; }


     
     	private Bug291022TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug291022TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleRootModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:61:1: entryRuleRootModel : ruleRootModel EOF ;
    public final void entryRuleRootModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:62:1: ( ruleRootModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:63:1: ruleRootModel EOF
            {
             before(grammarAccess.getRootModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRootModel_in_entryRuleRootModel61);
            ruleRootModel();
            _fsp--;

             after(grammarAccess.getRootModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRootModel68); 

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
    // $ANTLR end entryRuleRootModel


    // $ANTLR start ruleRootModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:70:1: ruleRootModel : ( ( rule__RootModel__Group__0 )? ) ;
    public final void ruleRootModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:74:2: ( ( ( rule__RootModel__Group__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:75:1: ( ( rule__RootModel__Group__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:75:1: ( ( rule__RootModel__Group__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:76:1: ( rule__RootModel__Group__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:77:1: ( rule__RootModel__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:77:2: rule__RootModel__Group__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__0_in_ruleRootModel94);
                    rule__RootModel__Group__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleRootModel


    // $ANTLR start entryRuleModelElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:89:1: entryRuleModelElement : ruleModelElement EOF ;
    public final void entryRuleModelElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:90:1: ( ruleModelElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:91:1: ruleModelElement EOF
            {
             before(grammarAccess.getModelElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement122);
            ruleModelElement();
            _fsp--;

             after(grammarAccess.getModelElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement129); 

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
    // $ANTLR end entryRuleModelElement


    // $ANTLR start ruleModelElement
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:98:1: ruleModelElement : ( ( rule__ModelElement__Group__0 ) ) ;
    public final void ruleModelElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:102:2: ( ( ( rule__ModelElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:103:1: ( ( rule__ModelElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:103:1: ( ( rule__ModelElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:104:1: ( rule__ModelElement__Group__0 )
            {
             before(grammarAccess.getModelElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:105:1: ( rule__ModelElement__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:105:2: rule__ModelElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__0_in_ruleModelElement155);
            rule__ModelElement__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModelElement


    // $ANTLR start entryRuleModelAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:117:1: entryRuleModelAttribute : ruleModelAttribute EOF ;
    public final void entryRuleModelAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:118:1: ( ruleModelAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:119:1: ruleModelAttribute EOF
            {
             before(grammarAccess.getModelAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute182);
            ruleModelAttribute();
            _fsp--;

             after(grammarAccess.getModelAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelAttribute189); 

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
    // $ANTLR end entryRuleModelAttribute


    // $ANTLR start ruleModelAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:126:1: ruleModelAttribute : ( ( rule__ModelAttribute__Alternatives ) ) ;
    public final void ruleModelAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:130:2: ( ( ( rule__ModelAttribute__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:131:1: ( ( rule__ModelAttribute__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:131:1: ( ( rule__ModelAttribute__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:132:1: ( rule__ModelAttribute__Alternatives )
            {
             before(grammarAccess.getModelAttributeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:133:1: ( rule__ModelAttribute__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:133:2: rule__ModelAttribute__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelAttribute__Alternatives_in_ruleModelAttribute215);
            rule__ModelAttribute__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getModelAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModelAttribute


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:145:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:146:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:147:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute242);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute249); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:154:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:158:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:159:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:159:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:160:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:161:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:161:2: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0_in_ruleAttribute275);
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


    // $ANTLR start rule__ModelElement__Alternatives_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:173:1: rule__ModelElement__Alternatives_3 : ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) );
    public final void rule__ModelElement__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:177:1: ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("173:1: rule__ModelElement__Alternatives_3 : ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:178:1: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:178:1: ( ';' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:179:1: ';'
                    {
                     before(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__ModelElement__Alternatives_3312); 
                     after(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:186:6: ( ( rule__ModelElement__Group_3_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:186:6: ( ( rule__ModelElement__Group_3_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:187:1: ( rule__ModelElement__Group_3_1__0 )
                    {
                     before(grammarAccess.getModelElementAccess().getGroup_3_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:188:1: ( rule__ModelElement__Group_3_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:188:2: rule__ModelElement__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__0_in_rule__ModelElement__Alternatives_3331);
                    rule__ModelElement__Group_3_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelElementAccess().getGroup_3_1()); 

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
    // $ANTLR end rule__ModelElement__Alternatives_3


    // $ANTLR start rule__ModelAttribute__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:197:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );
    public final void rule__ModelAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:201:1: ( ( ruleModelElement ) | ( ruleAttribute ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_ID||(LA3_1>=11 && LA3_1<=12)||LA3_1==14) ) {
                    alt3=1;
                }
                else if ( (LA3_1==15) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("197:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("197:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:202:1: ( ruleModelElement )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:202:1: ( ruleModelElement )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:203:1: ruleModelElement
                    {
                     before(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_rule__ModelAttribute__Alternatives364);
                    ruleModelElement();
                    _fsp--;

                     after(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:208:6: ( ruleAttribute )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:208:6: ( ruleAttribute )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:209:1: ruleAttribute
                    {
                     before(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__ModelAttribute__Alternatives381);
                    ruleAttribute();
                    _fsp--;

                     after(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1()); 

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
    // $ANTLR end rule__ModelAttribute__Alternatives


    // $ANTLR start rule__RootModel__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:221:1: rule__RootModel__Group__0 : rule__RootModel__Group__0__Impl rule__RootModel__Group__1 ;
    public final void rule__RootModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:225:1: ( rule__RootModel__Group__0__Impl rule__RootModel__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:226:2: rule__RootModel__Group__0__Impl rule__RootModel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__0__Impl_in_rule__RootModel__Group__0411);
            rule__RootModel__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__1_in_rule__RootModel__Group__0414);
            rule__RootModel__Group__1();
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
    // $ANTLR end rule__RootModel__Group__0


    // $ANTLR start rule__RootModel__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:233:1: rule__RootModel__Group__0__Impl : ( () ) ;
    public final void rule__RootModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:237:1: ( ( () ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:238:1: ( () )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:238:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:239:1: ()
            {
             before(grammarAccess.getRootModelAccess().getRootModelAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:240:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:242:1: 
            {
            }

             after(grammarAccess.getRootModelAccess().getRootModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__Group__0__Impl


    // $ANTLR start rule__RootModel__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:252:1: rule__RootModel__Group__1 : rule__RootModel__Group__1__Impl rule__RootModel__Group__2 ;
    public final void rule__RootModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:256:1: ( rule__RootModel__Group__1__Impl rule__RootModel__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:257:2: rule__RootModel__Group__1__Impl rule__RootModel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__1__Impl_in_rule__RootModel__Group__1472);
            rule__RootModel__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__2_in_rule__RootModel__Group__1475);
            rule__RootModel__Group__2();
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
    // $ANTLR end rule__RootModel__Group__1


    // $ANTLR start rule__RootModel__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:264:1: rule__RootModel__Group__1__Impl : ( ( rule__RootModel__NameAssignment_1 ) ) ;
    public final void rule__RootModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:268:1: ( ( ( rule__RootModel__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:269:1: ( ( rule__RootModel__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:269:1: ( ( rule__RootModel__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:270:1: ( rule__RootModel__NameAssignment_1 )
            {
             before(grammarAccess.getRootModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:271:1: ( rule__RootModel__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:271:2: rule__RootModel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__NameAssignment_1_in_rule__RootModel__Group__1__Impl502);
            rule__RootModel__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getRootModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__Group__1__Impl


    // $ANTLR start rule__RootModel__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:281:1: rule__RootModel__Group__2 : rule__RootModel__Group__2__Impl rule__RootModel__Group__3 ;
    public final void rule__RootModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:285:1: ( rule__RootModel__Group__2__Impl rule__RootModel__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:286:2: rule__RootModel__Group__2__Impl rule__RootModel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__2__Impl_in_rule__RootModel__Group__2532);
            rule__RootModel__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__3_in_rule__RootModel__Group__2535);
            rule__RootModel__Group__3();
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
    // $ANTLR end rule__RootModel__Group__2


    // $ANTLR start rule__RootModel__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:293:1: rule__RootModel__Group__2__Impl : ( ( rule__RootModel__TypeAssignment_2 )? ) ;
    public final void rule__RootModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:297:1: ( ( ( rule__RootModel__TypeAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:298:1: ( ( rule__RootModel__TypeAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:298:1: ( ( rule__RootModel__TypeAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:299:1: ( rule__RootModel__TypeAssignment_2 )?
            {
             before(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:300:1: ( rule__RootModel__TypeAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:300:2: rule__RootModel__TypeAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__RootModel__TypeAssignment_2_in_rule__RootModel__Group__2__Impl562);
                    rule__RootModel__TypeAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__Group__2__Impl


    // $ANTLR start rule__RootModel__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:310:1: rule__RootModel__Group__3 : rule__RootModel__Group__3__Impl ;
    public final void rule__RootModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:314:1: ( rule__RootModel__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:315:2: rule__RootModel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__3__Impl_in_rule__RootModel__Group__3593);
            rule__RootModel__Group__3__Impl();
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
    // $ANTLR end rule__RootModel__Group__3


    // $ANTLR start rule__RootModel__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:321:1: rule__RootModel__Group__3__Impl : ( ( rule__RootModel__Group_3__0 )? ) ;
    public final void rule__RootModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:325:1: ( ( ( rule__RootModel__Group_3__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:326:1: ( ( rule__RootModel__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:326:1: ( ( rule__RootModel__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:327:1: ( rule__RootModel__Group_3__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:328:1: ( rule__RootModel__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:328:2: rule__RootModel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__0_in_rule__RootModel__Group__3__Impl620);
                    rule__RootModel__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__Group__3__Impl


    // $ANTLR start rule__RootModel__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:346:1: rule__RootModel__Group_3__0 : rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1 ;
    public final void rule__RootModel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:350:1: ( rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:351:2: rule__RootModel__Group_3__0__Impl rule__RootModel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__0__Impl_in_rule__RootModel__Group_3__0659);
            rule__RootModel__Group_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__1_in_rule__RootModel__Group_3__0662);
            rule__RootModel__Group_3__1();
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
    // $ANTLR end rule__RootModel__Group_3__0


    // $ANTLR start rule__RootModel__Group_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:358:1: rule__RootModel__Group_3__0__Impl : ( '{' ) ;
    public final void rule__RootModel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:362:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:363:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:363:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:364:1: '{'
            {
             before(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__RootModel__Group_3__0__Impl690); 
             after(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__Group_3__0__Impl


    // $ANTLR start rule__RootModel__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:377:1: rule__RootModel__Group_3__1 : rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2 ;
    public final void rule__RootModel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:381:1: ( rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:382:2: rule__RootModel__Group_3__1__Impl rule__RootModel__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__1__Impl_in_rule__RootModel__Group_3__1721);
            rule__RootModel__Group_3__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__2_in_rule__RootModel__Group_3__1724);
            rule__RootModel__Group_3__2();
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
    // $ANTLR end rule__RootModel__Group_3__1


    // $ANTLR start rule__RootModel__Group_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:389:1: rule__RootModel__Group_3__1__Impl : ( ( rule__RootModel__ElementsAssignment_3_1 )* ) ;
    public final void rule__RootModel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:393:1: ( ( ( rule__RootModel__ElementsAssignment_3_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:394:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:394:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:395:1: ( rule__RootModel__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getRootModelAccess().getElementsAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:396:1: ( rule__RootModel__ElementsAssignment_3_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:396:2: rule__RootModel__ElementsAssignment_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__RootModel__ElementsAssignment_3_1_in_rule__RootModel__Group_3__1__Impl751);
            	    rule__RootModel__ElementsAssignment_3_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getRootModelAccess().getElementsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__Group_3__1__Impl


    // $ANTLR start rule__RootModel__Group_3__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:406:1: rule__RootModel__Group_3__2 : rule__RootModel__Group_3__2__Impl ;
    public final void rule__RootModel__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:410:1: ( rule__RootModel__Group_3__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:411:2: rule__RootModel__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__2__Impl_in_rule__RootModel__Group_3__2782);
            rule__RootModel__Group_3__2__Impl();
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
    // $ANTLR end rule__RootModel__Group_3__2


    // $ANTLR start rule__RootModel__Group_3__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:417:1: rule__RootModel__Group_3__2__Impl : ( '}' ) ;
    public final void rule__RootModel__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:421:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:422:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:422:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:423:1: '}'
            {
             before(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__RootModel__Group_3__2__Impl810); 
             after(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__Group_3__2__Impl


    // $ANTLR start rule__ModelElement__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:442:1: rule__ModelElement__Group__0 : rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 ;
    public final void rule__ModelElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:446:1: ( rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:447:2: rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__0__Impl_in_rule__ModelElement__Group__0847);
            rule__ModelElement__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__1_in_rule__ModelElement__Group__0850);
            rule__ModelElement__Group__1();
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
    // $ANTLR end rule__ModelElement__Group__0


    // $ANTLR start rule__ModelElement__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:454:1: rule__ModelElement__Group__0__Impl : ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) ;
    public final void rule__ModelElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:458:1: ( ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:459:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:459:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:460:1: ( rule__ModelElement__FirstReferenceAssignment_0 )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:461:1: ( rule__ModelElement__FirstReferenceAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:461:2: rule__ModelElement__FirstReferenceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__FirstReferenceAssignment_0_in_rule__ModelElement__Group__0__Impl877);
            rule__ModelElement__FirstReferenceAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group__0__Impl


    // $ANTLR start rule__ModelElement__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:471:1: rule__ModelElement__Group__1 : rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 ;
    public final void rule__ModelElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:475:1: ( rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:476:2: rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__1__Impl_in_rule__ModelElement__Group__1907);
            rule__ModelElement__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__2_in_rule__ModelElement__Group__1910);
            rule__ModelElement__Group__2();
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
    // $ANTLR end rule__ModelElement__Group__1


    // $ANTLR start rule__ModelElement__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:483:1: rule__ModelElement__Group__1__Impl : ( ( rule__ModelElement__Group_1__0 )? ) ;
    public final void rule__ModelElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:487:1: ( ( ( rule__ModelElement__Group_1__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:488:1: ( ( rule__ModelElement__Group_1__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:488:1: ( ( rule__ModelElement__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:489:1: ( rule__ModelElement__Group_1__0 )?
            {
             before(grammarAccess.getModelElementAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:490:1: ( rule__ModelElement__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:490:2: rule__ModelElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_1__0_in_rule__ModelElement__Group__1__Impl937);
                    rule__ModelElement__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group__1__Impl


    // $ANTLR start rule__ModelElement__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:500:1: rule__ModelElement__Group__2 : rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3 ;
    public final void rule__ModelElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:504:1: ( rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:505:2: rule__ModelElement__Group__2__Impl rule__ModelElement__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__2__Impl_in_rule__ModelElement__Group__2968);
            rule__ModelElement__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__3_in_rule__ModelElement__Group__2971);
            rule__ModelElement__Group__3();
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
    // $ANTLR end rule__ModelElement__Group__2


    // $ANTLR start rule__ModelElement__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:512:1: rule__ModelElement__Group__2__Impl : ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) ;
    public final void rule__ModelElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:516:1: ( ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:517:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:517:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:518:1: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:519:1: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:519:2: rule__ModelElement__SecondReferenceAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ModelElement__SecondReferenceAssignment_2_in_rule__ModelElement__Group__2__Impl998);
                    rule__ModelElement__SecondReferenceAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group__2__Impl


    // $ANTLR start rule__ModelElement__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:529:1: rule__ModelElement__Group__3 : rule__ModelElement__Group__3__Impl ;
    public final void rule__ModelElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:533:1: ( rule__ModelElement__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:534:2: rule__ModelElement__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__3__Impl_in_rule__ModelElement__Group__31029);
            rule__ModelElement__Group__3__Impl();
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
    // $ANTLR end rule__ModelElement__Group__3


    // $ANTLR start rule__ModelElement__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:540:1: rule__ModelElement__Group__3__Impl : ( ( rule__ModelElement__Alternatives_3 ) ) ;
    public final void rule__ModelElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:544:1: ( ( ( rule__ModelElement__Alternatives_3 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:545:1: ( ( rule__ModelElement__Alternatives_3 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:545:1: ( ( rule__ModelElement__Alternatives_3 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:546:1: ( rule__ModelElement__Alternatives_3 )
            {
             before(grammarAccess.getModelElementAccess().getAlternatives_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:547:1: ( rule__ModelElement__Alternatives_3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:547:2: rule__ModelElement__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Alternatives_3_in_rule__ModelElement__Group__3__Impl1056);
            rule__ModelElement__Alternatives_3();
            _fsp--;


            }

             after(grammarAccess.getModelElementAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group__3__Impl


    // $ANTLR start rule__ModelElement__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:565:1: rule__ModelElement__Group_1__0 : rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1 ;
    public final void rule__ModelElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:569:1: ( rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:570:2: rule__ModelElement__Group_1__0__Impl rule__ModelElement__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_1__0__Impl_in_rule__ModelElement__Group_1__01094);
            rule__ModelElement__Group_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_1__1_in_rule__ModelElement__Group_1__01097);
            rule__ModelElement__Group_1__1();
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
    // $ANTLR end rule__ModelElement__Group_1__0


    // $ANTLR start rule__ModelElement__Group_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:577:1: rule__ModelElement__Group_1__0__Impl : ( ':' ) ;
    public final void rule__ModelElement__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:581:1: ( ( ':' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:582:1: ( ':' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:582:1: ( ':' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:583:1: ':'
            {
             before(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ModelElement__Group_1__0__Impl1125); 
             after(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group_1__0__Impl


    // $ANTLR start rule__ModelElement__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:596:1: rule__ModelElement__Group_1__1 : rule__ModelElement__Group_1__1__Impl ;
    public final void rule__ModelElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:600:1: ( rule__ModelElement__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:601:2: rule__ModelElement__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_1__1__Impl_in_rule__ModelElement__Group_1__11156);
            rule__ModelElement__Group_1__1__Impl();
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
    // $ANTLR end rule__ModelElement__Group_1__1


    // $ANTLR start rule__ModelElement__Group_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:607:1: rule__ModelElement__Group_1__1__Impl : ( ( rule__ModelElement__NameAssignment_1_1 ) ) ;
    public final void rule__ModelElement__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:611:1: ( ( ( rule__ModelElement__NameAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:612:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:612:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:613:1: ( rule__ModelElement__NameAssignment_1_1 )
            {
             before(grammarAccess.getModelElementAccess().getNameAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:614:1: ( rule__ModelElement__NameAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:614:2: rule__ModelElement__NameAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__NameAssignment_1_1_in_rule__ModelElement__Group_1__1__Impl1183);
            rule__ModelElement__NameAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getModelElementAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group_1__1__Impl


    // $ANTLR start rule__ModelElement__Group_3_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:628:1: rule__ModelElement__Group_3_1__0 : rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1 ;
    public final void rule__ModelElement__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:632:1: ( rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:633:2: rule__ModelElement__Group_3_1__0__Impl rule__ModelElement__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__0__Impl_in_rule__ModelElement__Group_3_1__01217);
            rule__ModelElement__Group_3_1__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__1_in_rule__ModelElement__Group_3_1__01220);
            rule__ModelElement__Group_3_1__1();
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
    // $ANTLR end rule__ModelElement__Group_3_1__0


    // $ANTLR start rule__ModelElement__Group_3_1__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:640:1: rule__ModelElement__Group_3_1__0__Impl : ( '{' ) ;
    public final void rule__ModelElement__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:644:1: ( ( '{' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:645:1: ( '{' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:645:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:646:1: '{'
            {
             before(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__ModelElement__Group_3_1__0__Impl1248); 
             after(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group_3_1__0__Impl


    // $ANTLR start rule__ModelElement__Group_3_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:659:1: rule__ModelElement__Group_3_1__1 : rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2 ;
    public final void rule__ModelElement__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:663:1: ( rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:664:2: rule__ModelElement__Group_3_1__1__Impl rule__ModelElement__Group_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__1__Impl_in_rule__ModelElement__Group_3_1__11279);
            rule__ModelElement__Group_3_1__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__2_in_rule__ModelElement__Group_3_1__11282);
            rule__ModelElement__Group_3_1__2();
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
    // $ANTLR end rule__ModelElement__Group_3_1__1


    // $ANTLR start rule__ModelElement__Group_3_1__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:671:1: rule__ModelElement__Group_3_1__1__Impl : ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) ;
    public final void rule__ModelElement__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:675:1: ( ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:676:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:676:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:677:1: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            {
             before(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:678:1: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:678:2: rule__ModelElement__ElementsAssignment_3_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ModelElement__ElementsAssignment_3_1_1_in_rule__ModelElement__Group_3_1__1__Impl1309);
            	    rule__ModelElement__ElementsAssignment_3_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group_3_1__1__Impl


    // $ANTLR start rule__ModelElement__Group_3_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:688:1: rule__ModelElement__Group_3_1__2 : rule__ModelElement__Group_3_1__2__Impl ;
    public final void rule__ModelElement__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:692:1: ( rule__ModelElement__Group_3_1__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:693:2: rule__ModelElement__Group_3_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__2__Impl_in_rule__ModelElement__Group_3_1__21340);
            rule__ModelElement__Group_3_1__2__Impl();
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
    // $ANTLR end rule__ModelElement__Group_3_1__2


    // $ANTLR start rule__ModelElement__Group_3_1__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:699:1: rule__ModelElement__Group_3_1__2__Impl : ( '}' ) ;
    public final void rule__ModelElement__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:703:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:704:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:704:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:705:1: '}'
            {
             before(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ModelElement__Group_3_1__2__Impl1368); 
             after(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__Group_3_1__2__Impl


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:724:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:728:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:729:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__01405);
            rule__Attribute__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01408);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:736:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__FeatureAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:740:1: ( ( ( rule__Attribute__FeatureAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:741:1: ( ( rule__Attribute__FeatureAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:741:1: ( ( rule__Attribute__FeatureAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:742:1: ( rule__Attribute__FeatureAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:743:1: ( rule__Attribute__FeatureAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:743:2: rule__Attribute__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__FeatureAssignment_0_in_rule__Attribute__Group__0__Impl1435);
            rule__Attribute__FeatureAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:753:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:757:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:758:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__11465);
            rule__Attribute__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11468);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:765:1: rule__Attribute__Group__1__Impl : ( '=' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:769:1: ( ( '=' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:770:1: ( '=' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:770:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:771:1: '='
            {
             before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Attribute__Group__1__Impl1496); 
             after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:784:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:788:1: ( rule__Attribute__Group__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:789:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__21527);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:795:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:799:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:800:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:800:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:801:1: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:802:1: ( rule__Attribute__ValueAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:802:2: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2__Impl1554);
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


    // $ANTLR start rule__RootModel__NameAssignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:819:1: rule__RootModel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RootModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:823:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:824:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:824:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:825:1: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RootModel__NameAssignment_11595); 
             after(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__NameAssignment_1


    // $ANTLR start rule__RootModel__TypeAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:834:1: rule__RootModel__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__RootModel__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:838:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:839:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:839:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:840:1: ( RULE_ID )
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:841:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:842:1: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RootModel__TypeAssignment_21630); 
             after(grammarAccess.getRootModelAccess().getTypeModelElementIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__TypeAssignment_2


    // $ANTLR start rule__RootModel__ElementsAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:853:1: rule__RootModel__ElementsAssignment_3_1 : ( ruleModelAttribute ) ;
    public final void rule__RootModel__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:857:1: ( ( ruleModelAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:858:1: ( ruleModelAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:858:1: ( ruleModelAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:859:1: ruleModelAttribute
            {
             before(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_rule__RootModel__ElementsAssignment_3_11665);
            ruleModelAttribute();
            _fsp--;

             after(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RootModel__ElementsAssignment_3_1


    // $ANTLR start rule__ModelElement__FirstReferenceAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:868:1: rule__ModelElement__FirstReferenceAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__FirstReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:872:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:873:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:873:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:874:1: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:875:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:876:1: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ModelElement__FirstReferenceAssignment_01700); 
             after(grammarAccess.getModelElementAccess().getFirstReferenceModelElementIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__FirstReferenceAssignment_0


    // $ANTLR start rule__ModelElement__NameAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:887:1: rule__ModelElement__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ModelElement__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:891:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:892:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:892:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:893:1: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ModelElement__NameAssignment_1_11735); 
             after(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__NameAssignment_1_1


    // $ANTLR start rule__ModelElement__SecondReferenceAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:902:1: rule__ModelElement__SecondReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__SecondReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:906:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:907:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:907:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:908:1: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:909:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:910:1: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ModelElement__SecondReferenceAssignment_21770); 
             after(grammarAccess.getModelElementAccess().getSecondReferenceModelElementIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__SecondReferenceAssignment_2


    // $ANTLR start rule__ModelElement__ElementsAssignment_3_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:921:1: rule__ModelElement__ElementsAssignment_3_1_1 : ( ruleModelAttribute ) ;
    public final void rule__ModelElement__ElementsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:925:1: ( ( ruleModelAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:926:1: ( ruleModelAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:926:1: ( ruleModelAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:927:1: ruleModelAttribute
            {
             before(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_rule__ModelElement__ElementsAssignment_3_1_11805);
            ruleModelAttribute();
            _fsp--;

             after(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ModelElement__ElementsAssignment_3_1_1


    // $ANTLR start rule__Attribute__FeatureAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:936:1: rule__Attribute__FeatureAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:940:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:941:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:941:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:942:1: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:943:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:944:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__FeatureAssignment_01840); 
             after(grammarAccess.getAttributeAccess().getFeatureModelElementIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Attribute__FeatureAssignment_0


    // $ANTLR start rule__Attribute__ValueAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:955:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:959:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:960:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:960:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug291022TestLanguage.g:961:1: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_21875); 
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRootModel_in_entryRuleRootModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRootModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__0_in_ruleRootModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__0_in_ruleModelElement155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelAttribute189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelAttribute__Alternatives_in_ruleModelAttribute215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ModelElement__Alternatives_3312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__0_in_rule__ModelElement__Alternatives_3331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_rule__ModelAttribute__Alternatives364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__ModelAttribute__Alternatives381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__0__Impl_in_rule__RootModel__Group__0411 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__RootModel__Group__1_in_rule__RootModel__Group__0414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__1__Impl_in_rule__RootModel__Group__1472 = new BitSet(new long[]{0x0000000000001012L});
        public static final BitSet FOLLOW_rule__RootModel__Group__2_in_rule__RootModel__Group__1475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__NameAssignment_1_in_rule__RootModel__Group__1__Impl502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__2__Impl_in_rule__RootModel__Group__2532 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__3_in_rule__RootModel__Group__2535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__TypeAssignment_2_in_rule__RootModel__Group__2__Impl562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__3__Impl_in_rule__RootModel__Group__3593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__0_in_rule__RootModel__Group__3__Impl620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__0__Impl_in_rule__RootModel__Group_3__0659 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__1_in_rule__RootModel__Group_3__0662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__RootModel__Group_3__0__Impl690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__1__Impl_in_rule__RootModel__Group_3__1721 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__2_in_rule__RootModel__Group_3__1724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__ElementsAssignment_3_1_in_rule__RootModel__Group_3__1__Impl751 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__2__Impl_in_rule__RootModel__Group_3__2782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__RootModel__Group_3__2__Impl810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__0__Impl_in_rule__ModelElement__Group__0847 = new BitSet(new long[]{0x0000000000005810L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__1_in_rule__ModelElement__Group__0850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__FirstReferenceAssignment_0_in_rule__ModelElement__Group__0__Impl877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__1__Impl_in_rule__ModelElement__Group__1907 = new BitSet(new long[]{0x0000000000001810L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__2_in_rule__ModelElement__Group__1910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_1__0_in_rule__ModelElement__Group__1__Impl937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__2__Impl_in_rule__ModelElement__Group__2968 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__3_in_rule__ModelElement__Group__2971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__SecondReferenceAssignment_2_in_rule__ModelElement__Group__2__Impl998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__3__Impl_in_rule__ModelElement__Group__31029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Alternatives_3_in_rule__ModelElement__Group__3__Impl1056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_1__0__Impl_in_rule__ModelElement__Group_1__01094 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_1__1_in_rule__ModelElement__Group_1__01097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ModelElement__Group_1__0__Impl1125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_1__1__Impl_in_rule__ModelElement__Group_1__11156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__NameAssignment_1_1_in_rule__ModelElement__Group_1__1__Impl1183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__0__Impl_in_rule__ModelElement__Group_3_1__01217 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__1_in_rule__ModelElement__Group_3_1__01220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ModelElement__Group_3_1__0__Impl1248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__1__Impl_in_rule__ModelElement__Group_3_1__11279 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__2_in_rule__ModelElement__Group_3_1__11282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__ElementsAssignment_3_1_1_in_rule__ModelElement__Group_3_1__1__Impl1309 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__2__Impl_in_rule__ModelElement__Group_3_1__21340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ModelElement__Group_3_1__2__Impl1368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__01405 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__FeatureAssignment_0_in_rule__Attribute__Group__0__Impl1435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__11465 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Attribute__Group__1__Impl1496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__21527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2__Impl1554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RootModel__NameAssignment_11595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RootModel__TypeAssignment_21630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_rule__RootModel__ElementsAssignment_3_11665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ModelElement__FirstReferenceAssignment_01700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ModelElement__NameAssignment_1_11735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ModelElement__SecondReferenceAssignment_21770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_rule__ModelElement__ElementsAssignment_3_1_11805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__FeatureAssignment_01840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_21875 = new BitSet(new long[]{0x0000000000000002L});
    }


}