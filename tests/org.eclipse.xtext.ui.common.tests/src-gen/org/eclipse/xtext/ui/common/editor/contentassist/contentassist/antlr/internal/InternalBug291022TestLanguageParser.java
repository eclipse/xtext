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
import org.eclipse.xtext.ui.common.editor.contentassist.services.Bug291022TestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g"; }


     
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:60:1: entryRuleRootModel : ruleRootModel EOF ;
    public final void entryRuleRootModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:60:20: ( ruleRootModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:61:1: ruleRootModel EOF
            {
             before(grammarAccess.getRootModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRootModel_in_entryRuleRootModel60);
            ruleRootModel();
            _fsp--;

             after(grammarAccess.getRootModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRootModel67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:68:1: ruleRootModel : ( ( rule__RootModel__Group__0 )? ) ;
    public final void ruleRootModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:72:2: ( ( ( rule__RootModel__Group__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:73:1: ( ( rule__RootModel__Group__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:73:1: ( ( rule__RootModel__Group__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:74:1: ( rule__RootModel__Group__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:75:1: ( rule__RootModel__Group__0 )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:75:2: rule__RootModel__Group__0
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:87:1: entryRuleModelElement : ruleModelElement EOF ;
    public final void entryRuleModelElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:87:23: ( ruleModelElement EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:88:1: ruleModelElement EOF
            {
             before(grammarAccess.getModelElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement121);
            ruleModelElement();
            _fsp--;

             after(grammarAccess.getModelElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement128); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:95:1: ruleModelElement : ( ( rule__ModelElement__Group__0 ) ) ;
    public final void ruleModelElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:99:2: ( ( ( rule__ModelElement__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:100:1: ( ( rule__ModelElement__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:100:1: ( ( rule__ModelElement__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:101:1: ( rule__ModelElement__Group__0 )
            {
             before(grammarAccess.getModelElementAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:102:1: ( rule__ModelElement__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:102:2: rule__ModelElement__Group__0
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:114:1: entryRuleModelAttribute : ruleModelAttribute EOF ;
    public final void entryRuleModelAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:114:25: ( ruleModelAttribute EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:115:1: ruleModelAttribute EOF
            {
             before(grammarAccess.getModelAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute181);
            ruleModelAttribute();
            _fsp--;

             after(grammarAccess.getModelAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelAttribute188); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:122:1: ruleModelAttribute : ( ( rule__ModelAttribute__Alternatives ) ) ;
    public final void ruleModelAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:126:2: ( ( ( rule__ModelAttribute__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:127:1: ( ( rule__ModelAttribute__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:127:1: ( ( rule__ModelAttribute__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:128:1: ( rule__ModelAttribute__Alternatives )
            {
             before(grammarAccess.getModelAttributeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:129:1: ( rule__ModelAttribute__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:129:2: rule__ModelAttribute__Alternatives
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:141:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:141:20: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:142:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute241);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute248); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:149:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:153:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:154:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:154:1: ( ( rule__Attribute__Group__0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:155:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:156:1: ( rule__Attribute__Group__0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:156:2: rule__Attribute__Group__0
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:168:1: rule__ModelElement__Alternatives_3 : ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) );
    public final void rule__ModelElement__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:172:1: ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) )
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
                    new NoViableAltException("168:1: rule__ModelElement__Alternatives_3 : ( ( ';' ) | ( ( rule__ModelElement__Group_3_1__0 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:173:1: ( ';' )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:173:1: ( ';' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:174:1: ';'
                    {
                     before(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__ModelElement__Alternatives_3312); 
                     after(grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:181:6: ( ( rule__ModelElement__Group_3_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:181:6: ( ( rule__ModelElement__Group_3_1__0 ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:182:1: ( rule__ModelElement__Group_3_1__0 )
                    {
                     before(grammarAccess.getModelElementAccess().getGroup_3_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:183:1: ( rule__ModelElement__Group_3_1__0 )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:183:2: rule__ModelElement__Group_3_1__0
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:192:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );
    public final void rule__ModelAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:196:1: ( ( ruleModelElement ) | ( ruleAttribute ) )
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
                        new NoViableAltException("192:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("192:1: rule__ModelAttribute__Alternatives : ( ( ruleModelElement ) | ( ruleAttribute ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:197:1: ( ruleModelElement )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:197:1: ( ruleModelElement )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:198:1: ruleModelElement
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
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:203:6: ( ruleAttribute )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:203:6: ( ruleAttribute )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:204:1: ruleAttribute
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:216:1: rule__RootModel__Group__0 : ( () ) rule__RootModel__Group__1 ;
    public final void rule__RootModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:220:1: ( ( () ) rule__RootModel__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:221:1: ( () ) rule__RootModel__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:221:1: ( () )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:222:1: ()
            {
             before(grammarAccess.getRootModelAccess().getRootModelAction_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:223:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:225:1: 
            {
            }

             after(grammarAccess.getRootModelAccess().getRootModelAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__1_in_rule__RootModel__Group__0425);
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


    // $ANTLR start rule__RootModel__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:236:1: rule__RootModel__Group__1 : ( ( rule__RootModel__NameAssignment_1 ) ) rule__RootModel__Group__2 ;
    public final void rule__RootModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:240:1: ( ( ( rule__RootModel__NameAssignment_1 ) ) rule__RootModel__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:241:1: ( ( rule__RootModel__NameAssignment_1 ) ) rule__RootModel__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:241:1: ( ( rule__RootModel__NameAssignment_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:242:1: ( rule__RootModel__NameAssignment_1 )
            {
             before(grammarAccess.getRootModelAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:243:1: ( rule__RootModel__NameAssignment_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:243:2: rule__RootModel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RootModel__NameAssignment_1_in_rule__RootModel__Group__1453);
            rule__RootModel__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getRootModelAccess().getNameAssignment_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__2_in_rule__RootModel__Group__1462);
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


    // $ANTLR start rule__RootModel__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:254:1: rule__RootModel__Group__2 : ( ( rule__RootModel__TypeAssignment_2 )? ) rule__RootModel__Group__3 ;
    public final void rule__RootModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:258:1: ( ( ( rule__RootModel__TypeAssignment_2 )? ) rule__RootModel__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:259:1: ( ( rule__RootModel__TypeAssignment_2 )? ) rule__RootModel__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:259:1: ( ( rule__RootModel__TypeAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:260:1: ( rule__RootModel__TypeAssignment_2 )?
            {
             before(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:261:1: ( rule__RootModel__TypeAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:261:2: rule__RootModel__TypeAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__RootModel__TypeAssignment_2_in_rule__RootModel__Group__2490);
                    rule__RootModel__TypeAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRootModelAccess().getTypeAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group__3_in_rule__RootModel__Group__2500);
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


    // $ANTLR start rule__RootModel__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:272:1: rule__RootModel__Group__3 : ( ( rule__RootModel__Group_3__0 )? ) ;
    public final void rule__RootModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:276:1: ( ( ( rule__RootModel__Group_3__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:277:1: ( ( rule__RootModel__Group_3__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:277:1: ( ( rule__RootModel__Group_3__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:278:1: ( rule__RootModel__Group_3__0 )?
            {
             before(grammarAccess.getRootModelAccess().getGroup_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:279:1: ( rule__RootModel__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:279:2: rule__RootModel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__0_in_rule__RootModel__Group__3528);
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
    // $ANTLR end rule__RootModel__Group__3


    // $ANTLR start rule__RootModel__Group_3__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:297:1: rule__RootModel__Group_3__0 : ( '{' ) rule__RootModel__Group_3__1 ;
    public final void rule__RootModel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:301:1: ( ( '{' ) rule__RootModel__Group_3__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:302:1: ( '{' ) rule__RootModel__Group_3__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:302:1: ( '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:303:1: '{'
            {
             before(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__RootModel__Group_3__0572); 
             after(grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__1_in_rule__RootModel__Group_3__0582);
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


    // $ANTLR start rule__RootModel__Group_3__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:317:1: rule__RootModel__Group_3__1 : ( ( rule__RootModel__ElementsAssignment_3_1 )* ) rule__RootModel__Group_3__2 ;
    public final void rule__RootModel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:321:1: ( ( ( rule__RootModel__ElementsAssignment_3_1 )* ) rule__RootModel__Group_3__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:322:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* ) rule__RootModel__Group_3__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:322:1: ( ( rule__RootModel__ElementsAssignment_3_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:323:1: ( rule__RootModel__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getRootModelAccess().getElementsAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:324:1: ( rule__RootModel__ElementsAssignment_3_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:324:2: rule__RootModel__ElementsAssignment_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__RootModel__ElementsAssignment_3_1_in_rule__RootModel__Group_3__1610);
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

            pushFollow(FollowSets000.FOLLOW_rule__RootModel__Group_3__2_in_rule__RootModel__Group_3__1620);
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


    // $ANTLR start rule__RootModel__Group_3__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:335:1: rule__RootModel__Group_3__2 : ( '}' ) ;
    public final void rule__RootModel__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:339:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:340:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:340:1: ( '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:341:1: '}'
            {
             before(grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__RootModel__Group_3__2649); 
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
    // $ANTLR end rule__RootModel__Group_3__2


    // $ANTLR start rule__ModelElement__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:360:1: rule__ModelElement__Group__0 : ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) rule__ModelElement__Group__1 ;
    public final void rule__ModelElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:364:1: ( ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) rule__ModelElement__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:365:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) ) rule__ModelElement__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:365:1: ( ( rule__ModelElement__FirstReferenceAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:366:1: ( rule__ModelElement__FirstReferenceAssignment_0 )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:367:1: ( rule__ModelElement__FirstReferenceAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:367:2: rule__ModelElement__FirstReferenceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__FirstReferenceAssignment_0_in_rule__ModelElement__Group__0690);
            rule__ModelElement__FirstReferenceAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getModelElementAccess().getFirstReferenceAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__1_in_rule__ModelElement__Group__0699);
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


    // $ANTLR start rule__ModelElement__Group__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:378:1: rule__ModelElement__Group__1 : ( ( rule__ModelElement__Group_1__0 )? ) rule__ModelElement__Group__2 ;
    public final void rule__ModelElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:382:1: ( ( ( rule__ModelElement__Group_1__0 )? ) rule__ModelElement__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:383:1: ( ( rule__ModelElement__Group_1__0 )? ) rule__ModelElement__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:383:1: ( ( rule__ModelElement__Group_1__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:384:1: ( rule__ModelElement__Group_1__0 )?
            {
             before(grammarAccess.getModelElementAccess().getGroup_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:385:1: ( rule__ModelElement__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:385:2: rule__ModelElement__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_1__0_in_rule__ModelElement__Group__1727);
                    rule__ModelElement__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getGroup_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__2_in_rule__ModelElement__Group__1737);
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


    // $ANTLR start rule__ModelElement__Group__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:396:1: rule__ModelElement__Group__2 : ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) rule__ModelElement__Group__3 ;
    public final void rule__ModelElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:400:1: ( ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) rule__ModelElement__Group__3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:401:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? ) rule__ModelElement__Group__3
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:401:1: ( ( rule__ModelElement__SecondReferenceAssignment_2 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:402:1: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:403:1: ( rule__ModelElement__SecondReferenceAssignment_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:403:2: rule__ModelElement__SecondReferenceAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__ModelElement__SecondReferenceAssignment_2_in_rule__ModelElement__Group__2765);
                    rule__ModelElement__SecondReferenceAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelElementAccess().getSecondReferenceAssignment_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group__3_in_rule__ModelElement__Group__2775);
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


    // $ANTLR start rule__ModelElement__Group__3
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:414:1: rule__ModelElement__Group__3 : ( ( rule__ModelElement__Alternatives_3 ) ) ;
    public final void rule__ModelElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:418:1: ( ( ( rule__ModelElement__Alternatives_3 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:419:1: ( ( rule__ModelElement__Alternatives_3 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:419:1: ( ( rule__ModelElement__Alternatives_3 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:420:1: ( rule__ModelElement__Alternatives_3 )
            {
             before(grammarAccess.getModelElementAccess().getAlternatives_3()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:421:1: ( rule__ModelElement__Alternatives_3 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:421:2: rule__ModelElement__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Alternatives_3_in_rule__ModelElement__Group__3803);
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
    // $ANTLR end rule__ModelElement__Group__3


    // $ANTLR start rule__ModelElement__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:439:1: rule__ModelElement__Group_1__0 : ( ':' ) rule__ModelElement__Group_1__1 ;
    public final void rule__ModelElement__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:443:1: ( ( ':' ) rule__ModelElement__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:444:1: ( ':' ) rule__ModelElement__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:444:1: ( ':' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:445:1: ':'
            {
             before(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ModelElement__Group_1__0846); 
             after(grammarAccess.getModelElementAccess().getColonKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_1__1_in_rule__ModelElement__Group_1__0856);
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


    // $ANTLR start rule__ModelElement__Group_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:459:1: rule__ModelElement__Group_1__1 : ( ( rule__ModelElement__NameAssignment_1_1 ) ) ;
    public final void rule__ModelElement__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:463:1: ( ( ( rule__ModelElement__NameAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:464:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:464:1: ( ( rule__ModelElement__NameAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:465:1: ( rule__ModelElement__NameAssignment_1_1 )
            {
             before(grammarAccess.getModelElementAccess().getNameAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:466:1: ( rule__ModelElement__NameAssignment_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:466:2: rule__ModelElement__NameAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__NameAssignment_1_1_in_rule__ModelElement__Group_1__1884);
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
    // $ANTLR end rule__ModelElement__Group_1__1


    // $ANTLR start rule__ModelElement__Group_3_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:480:1: rule__ModelElement__Group_3_1__0 : ( '{' ) rule__ModelElement__Group_3_1__1 ;
    public final void rule__ModelElement__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:484:1: ( ( '{' ) rule__ModelElement__Group_3_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:485:1: ( '{' ) rule__ModelElement__Group_3_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:485:1: ( '{' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:486:1: '{'
            {
             before(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__ModelElement__Group_3_1__0923); 
             after(grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__1_in_rule__ModelElement__Group_3_1__0933);
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


    // $ANTLR start rule__ModelElement__Group_3_1__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:500:1: rule__ModelElement__Group_3_1__1 : ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) rule__ModelElement__Group_3_1__2 ;
    public final void rule__ModelElement__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:504:1: ( ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) rule__ModelElement__Group_3_1__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:505:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* ) rule__ModelElement__Group_3_1__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:505:1: ( ( rule__ModelElement__ElementsAssignment_3_1_1 )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:506:1: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            {
             before(grammarAccess.getModelElementAccess().getElementsAssignment_3_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:507:1: ( rule__ModelElement__ElementsAssignment_3_1_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:507:2: rule__ModelElement__ElementsAssignment_3_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ModelElement__ElementsAssignment_3_1_1_in_rule__ModelElement__Group_3_1__1961);
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

            pushFollow(FollowSets000.FOLLOW_rule__ModelElement__Group_3_1__2_in_rule__ModelElement__Group_3_1__1971);
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


    // $ANTLR start rule__ModelElement__Group_3_1__2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:518:1: rule__ModelElement__Group_3_1__2 : ( '}' ) ;
    public final void rule__ModelElement__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:522:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:523:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:523:1: ( '}' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:524:1: '}'
            {
             before(grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ModelElement__Group_3_1__21000); 
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
    // $ANTLR end rule__ModelElement__Group_3_1__2


    // $ANTLR start rule__Attribute__Group__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:543:1: rule__Attribute__Group__0 : ( ( rule__Attribute__FeatureAssignment_0 ) ) rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:547:1: ( ( ( rule__Attribute__FeatureAssignment_0 ) ) rule__Attribute__Group__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:548:1: ( ( rule__Attribute__FeatureAssignment_0 ) ) rule__Attribute__Group__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:548:1: ( ( rule__Attribute__FeatureAssignment_0 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:549:1: ( rule__Attribute__FeatureAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:550:1: ( rule__Attribute__FeatureAssignment_0 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:550:2: rule__Attribute__FeatureAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__FeatureAssignment_0_in_rule__Attribute__Group__01041);
            rule__Attribute__FeatureAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getFeatureAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01050);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:561:1: rule__Attribute__Group__1 : ( '=' ) rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:565:1: ( ( '=' ) rule__Attribute__Group__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:566:1: ( '=' ) rule__Attribute__Group__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:566:1: ( '=' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:567:1: '='
            {
             before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Attribute__Group__11079); 
             after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11089);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:581:1: rule__Attribute__Group__2 : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:585:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:586:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:586:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:587:1: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:588:1: ( rule__Attribute__ValueAssignment_2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:588:2: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__21117);
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


    // $ANTLR start rule__RootModel__NameAssignment_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:604:1: rule__RootModel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__RootModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:608:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:609:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:609:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:610:1: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RootModel__NameAssignment_11157); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:619:1: rule__RootModel__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__RootModel__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:623:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:624:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:624:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:625:1: ( RULE_ID )
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:626:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:627:1: RULE_ID
            {
             before(grammarAccess.getRootModelAccess().getTypeModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__RootModel__TypeAssignment_21192); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:638:1: rule__RootModel__ElementsAssignment_3_1 : ( ruleModelAttribute ) ;
    public final void rule__RootModel__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:642:1: ( ( ruleModelAttribute ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:643:1: ( ruleModelAttribute )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:643:1: ( ruleModelAttribute )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:644:1: ruleModelAttribute
            {
             before(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_rule__RootModel__ElementsAssignment_3_11227);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:653:1: rule__ModelElement__FirstReferenceAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__FirstReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:657:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:658:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:658:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:659:1: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:660:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:661:1: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getFirstReferenceModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ModelElement__FirstReferenceAssignment_01262); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:672:1: rule__ModelElement__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__ModelElement__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:676:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:677:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:677:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:678:1: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ModelElement__NameAssignment_1_11297); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:687:1: rule__ModelElement__SecondReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ModelElement__SecondReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:691:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:692:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:692:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:693:1: ( RULE_ID )
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:694:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:695:1: RULE_ID
            {
             before(grammarAccess.getModelElementAccess().getSecondReferenceModelElementIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ModelElement__SecondReferenceAssignment_21332); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:706:1: rule__ModelElement__ElementsAssignment_3_1_1 : ( ruleModelAttribute ) ;
    public final void rule__ModelElement__ElementsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:710:1: ( ( ruleModelAttribute ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:711:1: ( ruleModelAttribute )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:711:1: ( ruleModelAttribute )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:712:1: ruleModelAttribute
            {
             before(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_rule__ModelElement__ElementsAssignment_3_1_11367);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:721:1: rule__Attribute__FeatureAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__FeatureAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:725:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:726:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:726:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:727:1: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:728:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:729:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getFeatureModelElementIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__FeatureAssignment_01402); 
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:740:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:744:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:745:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:745:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/contentassist/antlr/internal/InternalBug291022TestLanguage.g:746:1: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_21437); 
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
        public static final BitSet FOLLOW_ruleRootModel_in_entryRuleRootModel60 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRootModel67 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__0_in_ruleRootModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__0_in_ruleModelElement155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelAttribute188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelAttribute__Alternatives_in_ruleModelAttribute215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ModelElement__Alternatives_3312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__0_in_rule__ModelElement__Alternatives_3331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_rule__ModelAttribute__Alternatives364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__ModelAttribute__Alternatives381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__1_in_rule__RootModel__Group__0425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__NameAssignment_1_in_rule__RootModel__Group__1453 = new BitSet(new long[]{0x0000000000001012L});
        public static final BitSet FOLLOW_rule__RootModel__Group__2_in_rule__RootModel__Group__1462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__TypeAssignment_2_in_rule__RootModel__Group__2490 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__RootModel__Group__3_in_rule__RootModel__Group__2500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__0_in_rule__RootModel__Group__3528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__RootModel__Group_3__0572 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__1_in_rule__RootModel__Group_3__0582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RootModel__ElementsAssignment_3_1_in_rule__RootModel__Group_3__1610 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_rule__RootModel__Group_3__2_in_rule__RootModel__Group_3__1620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__RootModel__Group_3__2649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__FirstReferenceAssignment_0_in_rule__ModelElement__Group__0690 = new BitSet(new long[]{0x0000000000005810L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__1_in_rule__ModelElement__Group__0699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_1__0_in_rule__ModelElement__Group__1727 = new BitSet(new long[]{0x0000000000001810L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__2_in_rule__ModelElement__Group__1737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__SecondReferenceAssignment_2_in_rule__ModelElement__Group__2765 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__ModelElement__Group__3_in_rule__ModelElement__Group__2775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__Alternatives_3_in_rule__ModelElement__Group__3803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ModelElement__Group_1__0846 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_1__1_in_rule__ModelElement__Group_1__0856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__NameAssignment_1_1_in_rule__ModelElement__Group_1__1884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ModelElement__Group_3_1__0923 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__1_in_rule__ModelElement__Group_3_1__0933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ModelElement__ElementsAssignment_3_1_1_in_rule__ModelElement__Group_3_1__1961 = new BitSet(new long[]{0x0000000000002010L});
        public static final BitSet FOLLOW_rule__ModelElement__Group_3_1__2_in_rule__ModelElement__Group_3_1__1971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ModelElement__Group_3_1__21000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__FeatureAssignment_0_in_rule__Attribute__Group__01041 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Attribute__Group__11079 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__21117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RootModel__NameAssignment_11157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__RootModel__TypeAssignment_21192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_rule__RootModel__ElementsAssignment_3_11227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ModelElement__FirstReferenceAssignment_01262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ModelElement__NameAssignment_1_11297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ModelElement__SecondReferenceAssignment_21332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_rule__ModelElement__ElementsAssignment_3_1_11367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__FeatureAssignment_01402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_21437 = new BitSet(new long[]{0x0000000000000002L});
    }


}