package org.eclipse.xtext.idea.sdomain.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.idea.sdomain.services.SDomainGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSDomainParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'.*'", "'.'", "'{'", "'}'", "'entity'", "'datatype'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalSDomainParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSDomainParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSDomainParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g"; }


     
     	private SDomainGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(SDomainGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleFile"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:60:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:61:1: ( ruleFile EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:62:1: ruleFile EOF
            {
             before(grammarAccess.getFileRule()); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile61);
            ruleFile();

            state._fsp--;

             after(grammarAccess.getFileRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile68); 

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
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:69:1: ruleFile : ( ( rule__File__ElementsAssignment )* ) ;
    public final void ruleFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:73:2: ( ( ( rule__File__ElementsAssignment )* ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:74:1: ( ( rule__File__ElementsAssignment )* )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:74:1: ( ( rule__File__ElementsAssignment )* )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:75:1: ( rule__File__ElementsAssignment )*
            {
             before(grammarAccess.getFileAccess().getElementsAssignment()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:76:1: ( rule__File__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:76:2: rule__File__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__File__ElementsAssignment_in_ruleFile94);
            	    rule__File__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFileAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:88:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:89:1: ( ruleImport EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:90:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport122);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport129); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:97:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:101:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:102:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:102:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:103:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:104:1: ( rule__Import__Group__0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:104:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport155);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:116:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:117:1: ( ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:118:1: ruleQualifiedNameWithWildCard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard182);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildCardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard189); 

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
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:125:1: ruleQualifiedNameWithWildCard : ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:129:2: ( ( ( rule__QualifiedNameWithWildCard__Group__0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:130:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:130:1: ( ( rule__QualifiedNameWithWildCard__Group__0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:131:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:132:1: ( rule__QualifiedNameWithWildCard__Group__0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:132:2: rule__QualifiedNameWithWildCard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__0_in_ruleQualifiedNameWithWildCard215);
            rule__QualifiedNameWithWildCard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameWithWildCardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:144:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:145:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:146:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName242);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName249); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:153:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:157:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:159:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:160:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:160:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName275);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNamespace"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:172:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:173:1: ( ruleNamespace EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:174:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace302);
            ruleNamespace();

            state._fsp--;

             after(grammarAccess.getNamespaceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace309); 

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
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:181:1: ruleNamespace : ( ( rule__Namespace__Group__0 ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:185:2: ( ( ( rule__Namespace__Group__0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:186:1: ( ( rule__Namespace__Group__0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:186:1: ( ( rule__Namespace__Group__0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:187:1: ( rule__Namespace__Group__0 )
            {
             before(grammarAccess.getNamespaceAccess().getGroup()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:188:1: ( rule__Namespace__Group__0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:188:2: rule__Namespace__Group__0
            {
            pushFollow(FOLLOW_rule__Namespace__Group__0_in_ruleNamespace335);
            rule__Namespace__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamespaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:200:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:201:1: ( ruleElement EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:202:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement362);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement369); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:209:1: ruleElement : ( ( rule__Element__Alternatives ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:213:2: ( ( ( rule__Element__Alternatives ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:214:1: ( ( rule__Element__Alternatives ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:214:1: ( ( rule__Element__Alternatives ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:215:1: ( rule__Element__Alternatives )
            {
             before(grammarAccess.getElementAccess().getAlternatives()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:216:1: ( rule__Element__Alternatives )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:216:2: rule__Element__Alternatives
            {
            pushFollow(FOLLOW_rule__Element__Alternatives_in_ruleElement395);
            rule__Element__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:228:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:229:1: ( ruleType EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:230:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType422);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType429); 

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:237:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:241:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:242:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:242:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:243:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:244:1: ( rule__Type__Alternatives )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:244:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType455);
            rule__Type__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:256:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:257:1: ( ruleEntity EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:258:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity482);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity489); 

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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:265:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:269:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:270:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:270:1: ( ( rule__Entity__Group__0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:271:1: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:272:1: ( rule__Entity__Group__0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:272:2: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_rule__Entity__Group__0_in_ruleEntity515);
            rule__Entity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleDatatype"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:284:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:285:1: ( ruleDatatype EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:286:1: ruleDatatype EOF
            {
             before(grammarAccess.getDatatypeRule()); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype542);
            ruleDatatype();

            state._fsp--;

             after(grammarAccess.getDatatypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype549); 

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
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:293:1: ruleDatatype : ( ( rule__Datatype__Group__0 ) ) ;
    public final void ruleDatatype() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:297:2: ( ( ( rule__Datatype__Group__0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:298:1: ( ( rule__Datatype__Group__0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:298:1: ( ( rule__Datatype__Group__0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:299:1: ( rule__Datatype__Group__0 )
            {
             before(grammarAccess.getDatatypeAccess().getGroup()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:300:1: ( rule__Datatype__Group__0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:300:2: rule__Datatype__Group__0
            {
            pushFollow(FOLLOW_rule__Datatype__Group__0_in_ruleDatatype575);
            rule__Datatype__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDatatypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:312:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:313:1: ( ruleProperty EOF )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:314:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty602);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty609); 

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:321:1: ruleProperty : ( ( rule__Property__Group__0 ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:325:2: ( ( ( rule__Property__Group__0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:326:1: ( ( rule__Property__Group__0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:326:1: ( ( rule__Property__Group__0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:327:1: ( rule__Property__Group__0 )
            {
             before(grammarAccess.getPropertyAccess().getGroup()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:328:1: ( rule__Property__Group__0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:328:2: rule__Property__Group__0
            {
            pushFollow(FOLLOW_rule__Property__Group__0_in_ruleProperty635);
            rule__Property__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "rule__Element__Alternatives"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:340:1: rule__Element__Alternatives : ( ( ruleNamespace ) | ( ruleType ) | ( ruleImport ) );
    public final void rule__Element__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:344:1: ( ( ruleNamespace ) | ( ruleType ) | ( ruleImport ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case 16:
            case 17:
                {
                alt2=2;
                }
                break;
            case 11:
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
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:345:1: ( ruleNamespace )
                    {
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:345:1: ( ruleNamespace )
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:346:1: ruleNamespace
                    {
                     before(grammarAccess.getElementAccess().getNamespaceParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNamespace_in_rule__Element__Alternatives671);
                    ruleNamespace();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getNamespaceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:351:6: ( ruleType )
                    {
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:351:6: ( ruleType )
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:352:1: ruleType
                    {
                     before(grammarAccess.getElementAccess().getTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleType_in_rule__Element__Alternatives688);
                    ruleType();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getTypeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:357:6: ( ruleImport )
                    {
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:357:6: ( ruleImport )
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:358:1: ruleImport
                    {
                     before(grammarAccess.getElementAccess().getImportParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__Element__Alternatives705);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getElementAccess().getImportParserRuleCall_2()); 

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
    // $ANTLR end "rule__Element__Alternatives"


    // $ANTLR start "rule__Type__Alternatives"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:368:1: rule__Type__Alternatives : ( ( ruleEntity ) | ( ruleDatatype ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:372:1: ( ( ruleEntity ) | ( ruleDatatype ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==17) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:373:1: ( ruleEntity )
                    {
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:373:1: ( ruleEntity )
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:374:1: ruleEntity
                    {
                     before(grammarAccess.getTypeAccess().getEntityParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleEntity_in_rule__Type__Alternatives737);
                    ruleEntity();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getEntityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:379:6: ( ruleDatatype )
                    {
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:379:6: ( ruleDatatype )
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:380:1: ruleDatatype
                    {
                     before(grammarAccess.getTypeAccess().getDatatypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDatatype_in_rule__Type__Alternatives754);
                    ruleDatatype();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getDatatypeParserRuleCall_1()); 

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
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__Import__Group__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:392:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:396:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:397:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0784);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0787);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:404:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:408:1: ( ( 'import' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:409:1: ( 'import' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:409:1: ( 'import' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:410:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Import__Group__0__Impl815); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:423:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:427:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:428:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1846);
            rule__Import__Group__1__Impl();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:434:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:438:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:439:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:439:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:440:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:441:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:441:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl873);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:455:1: rule__QualifiedNameWithWildCard__Group__0 : rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 ;
    public final void rule__QualifiedNameWithWildCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:459:1: ( rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:460:2: rule__QualifiedNameWithWildCard__Group__0__Impl rule__QualifiedNameWithWildCard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__0907);
            rule__QualifiedNameWithWildCard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__0910);
            rule__QualifiedNameWithWildCard__Group__1();

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
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:467:1: rule__QualifiedNameWithWildCard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:471:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:472:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:472:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:473:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl937);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:484:1: rule__QualifiedNameWithWildCard__Group__1 : rule__QualifiedNameWithWildCard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:488:1: ( rule__QualifiedNameWithWildCard__Group__1__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:489:2: rule__QualifiedNameWithWildCard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__1966);
            rule__QualifiedNameWithWildCard__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildCard__Group__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:495:1: rule__QualifiedNameWithWildCard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:499:1: ( ( ( '.*' )? ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:500:1: ( ( '.*' )? )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:500:1: ( ( '.*' )? )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:501:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:502:1: ( '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:503:2: '.*'
                    {
                    match(input,12,FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group__1__Impl995); 

                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildCard__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:518:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:522:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:523:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01032);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01035);
            rule__QualifiedName__Group__1();

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:530:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:534:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:535:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:535:1: ( RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:536:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1062); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:547:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:551:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:552:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11091);
            rule__QualifiedName__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:558:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:562:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:563:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:563:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:564:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:565:1: ( rule__QualifiedName__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:565:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl1118);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:579:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:583:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:584:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__01153);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01156);
            rule__QualifiedName__Group_1__1();

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:591:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:595:1: ( ( '.' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:596:1: ( '.' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:596:1: ( '.' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:597:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__QualifiedName__Group_1__0__Impl1184); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:610:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:614:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:615:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__11215);
            rule__QualifiedName__Group_1__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:621:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:625:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:626:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:626:1: ( RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:627:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl1242); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Namespace__Group__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:642:1: rule__Namespace__Group__0 : rule__Namespace__Group__0__Impl rule__Namespace__Group__1 ;
    public final void rule__Namespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:646:1: ( rule__Namespace__Group__0__Impl rule__Namespace__Group__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:647:2: rule__Namespace__Group__0__Impl rule__Namespace__Group__1
            {
            pushFollow(FOLLOW_rule__Namespace__Group__0__Impl_in_rule__Namespace__Group__01275);
            rule__Namespace__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__01278);
            rule__Namespace__Group__1();

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
    // $ANTLR end "rule__Namespace__Group__0"


    // $ANTLR start "rule__Namespace__Group__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:654:1: rule__Namespace__Group__0__Impl : ( ( rule__Namespace__NameAssignment_0 ) ) ;
    public final void rule__Namespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:658:1: ( ( ( rule__Namespace__NameAssignment_0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:659:1: ( ( rule__Namespace__NameAssignment_0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:659:1: ( ( rule__Namespace__NameAssignment_0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:660:1: ( rule__Namespace__NameAssignment_0 )
            {
             before(grammarAccess.getNamespaceAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:661:1: ( rule__Namespace__NameAssignment_0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:661:2: rule__Namespace__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Namespace__NameAssignment_0_in_rule__Namespace__Group__0__Impl1305);
            rule__Namespace__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNamespaceAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__0__Impl"


    // $ANTLR start "rule__Namespace__Group__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:671:1: rule__Namespace__Group__1 : rule__Namespace__Group__1__Impl rule__Namespace__Group__2 ;
    public final void rule__Namespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:675:1: ( rule__Namespace__Group__1__Impl rule__Namespace__Group__2 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:676:2: rule__Namespace__Group__1__Impl rule__Namespace__Group__2
            {
            pushFollow(FOLLOW_rule__Namespace__Group__1__Impl_in_rule__Namespace__Group__11335);
            rule__Namespace__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__11338);
            rule__Namespace__Group__2();

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
    // $ANTLR end "rule__Namespace__Group__1"


    // $ANTLR start "rule__Namespace__Group__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:683:1: rule__Namespace__Group__1__Impl : ( '{' ) ;
    public final void rule__Namespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:687:1: ( ( '{' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:688:1: ( '{' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:688:1: ( '{' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:689:1: '{'
            {
             before(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__Namespace__Group__1__Impl1366); 
             after(grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__1__Impl"


    // $ANTLR start "rule__Namespace__Group__2"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:702:1: rule__Namespace__Group__2 : rule__Namespace__Group__2__Impl rule__Namespace__Group__3 ;
    public final void rule__Namespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:706:1: ( rule__Namespace__Group__2__Impl rule__Namespace__Group__3 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:707:2: rule__Namespace__Group__2__Impl rule__Namespace__Group__3
            {
            pushFollow(FOLLOW_rule__Namespace__Group__2__Impl_in_rule__Namespace__Group__21397);
            rule__Namespace__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__21400);
            rule__Namespace__Group__3();

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
    // $ANTLR end "rule__Namespace__Group__2"


    // $ANTLR start "rule__Namespace__Group__2__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:714:1: rule__Namespace__Group__2__Impl : ( ( rule__Namespace__ElementsAssignment_2 )* ) ;
    public final void rule__Namespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:718:1: ( ( ( rule__Namespace__ElementsAssignment_2 )* ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:719:1: ( ( rule__Namespace__ElementsAssignment_2 )* )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:719:1: ( ( rule__Namespace__ElementsAssignment_2 )* )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:720:1: ( rule__Namespace__ElementsAssignment_2 )*
            {
             before(grammarAccess.getNamespaceAccess().getElementsAssignment_2()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:721:1: ( rule__Namespace__ElementsAssignment_2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||LA6_0==11||(LA6_0>=16 && LA6_0<=17)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:721:2: rule__Namespace__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Namespace__ElementsAssignment_2_in_rule__Namespace__Group__2__Impl1427);
            	    rule__Namespace__ElementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getNamespaceAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__2__Impl"


    // $ANTLR start "rule__Namespace__Group__3"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:731:1: rule__Namespace__Group__3 : rule__Namespace__Group__3__Impl ;
    public final void rule__Namespace__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:735:1: ( rule__Namespace__Group__3__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:736:2: rule__Namespace__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Namespace__Group__3__Impl_in_rule__Namespace__Group__31458);
            rule__Namespace__Group__3__Impl();

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
    // $ANTLR end "rule__Namespace__Group__3"


    // $ANTLR start "rule__Namespace__Group__3__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:742:1: rule__Namespace__Group__3__Impl : ( '}' ) ;
    public final void rule__Namespace__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:746:1: ( ( '}' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:747:1: ( '}' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:747:1: ( '}' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:748:1: '}'
            {
             before(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_3()); 
            match(input,15,FOLLOW_15_in_rule__Namespace__Group__3__Impl1486); 
             after(grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Group__3__Impl"


    // $ANTLR start "rule__Entity__Group__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:769:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:773:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:774:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
            {
            pushFollow(FOLLOW_rule__Entity__Group__0__Impl_in_rule__Entity__Group__01525);
            rule__Entity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01528);
            rule__Entity__Group__1();

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
    // $ANTLR end "rule__Entity__Group__0"


    // $ANTLR start "rule__Entity__Group__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:781:1: rule__Entity__Group__0__Impl : ( 'entity' ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:785:1: ( ( 'entity' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:786:1: ( 'entity' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:786:1: ( 'entity' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:787:1: 'entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Entity__Group__0__Impl1556); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0__Impl"


    // $ANTLR start "rule__Entity__Group__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:800:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:804:1: ( rule__Entity__Group__1__Impl rule__Entity__Group__2 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:805:2: rule__Entity__Group__1__Impl rule__Entity__Group__2
            {
            pushFollow(FOLLOW_rule__Entity__Group__1__Impl_in_rule__Entity__Group__11587);
            rule__Entity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11590);
            rule__Entity__Group__2();

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
    // $ANTLR end "rule__Entity__Group__1"


    // $ANTLR start "rule__Entity__Group__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:812:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:816:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:817:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:817:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:818:1: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:819:1: ( rule__Entity__NameAssignment_1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:819:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1__Impl1617);
            rule__Entity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__2"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:829:1: rule__Entity__Group__2 : rule__Entity__Group__2__Impl rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:833:1: ( rule__Entity__Group__2__Impl rule__Entity__Group__3 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:834:2: rule__Entity__Group__2__Impl rule__Entity__Group__3
            {
            pushFollow(FOLLOW_rule__Entity__Group__2__Impl_in_rule__Entity__Group__21647);
            rule__Entity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21650);
            rule__Entity__Group__3();

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
    // $ANTLR end "rule__Entity__Group__2"


    // $ANTLR start "rule__Entity__Group__2__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:841:1: rule__Entity__Group__2__Impl : ( '{' ) ;
    public final void rule__Entity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:845:1: ( ( '{' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:846:1: ( '{' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:846:1: ( '{' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:847:1: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__Entity__Group__2__Impl1678); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2__Impl"


    // $ANTLR start "rule__Entity__Group__3"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:860:1: rule__Entity__Group__3 : rule__Entity__Group__3__Impl rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:864:1: ( rule__Entity__Group__3__Impl rule__Entity__Group__4 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:865:2: rule__Entity__Group__3__Impl rule__Entity__Group__4
            {
            pushFollow(FOLLOW_rule__Entity__Group__3__Impl_in_rule__Entity__Group__31709);
            rule__Entity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31712);
            rule__Entity__Group__4();

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
    // $ANTLR end "rule__Entity__Group__3"


    // $ANTLR start "rule__Entity__Group__3__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:872:1: rule__Entity__Group__3__Impl : ( ( rule__Entity__PropertiesAssignment_3 )* ) ;
    public final void rule__Entity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:876:1: ( ( ( rule__Entity__PropertiesAssignment_3 )* ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:877:1: ( ( rule__Entity__PropertiesAssignment_3 )* )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:877:1: ( ( rule__Entity__PropertiesAssignment_3 )* )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:878:1: ( rule__Entity__PropertiesAssignment_3 )*
            {
             before(grammarAccess.getEntityAccess().getPropertiesAssignment_3()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:879:1: ( rule__Entity__PropertiesAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:879:2: rule__Entity__PropertiesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Entity__PropertiesAssignment_3_in_rule__Entity__Group__3__Impl1739);
            	    rule__Entity__PropertiesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getPropertiesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3__Impl"


    // $ANTLR start "rule__Entity__Group__4"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:889:1: rule__Entity__Group__4 : rule__Entity__Group__4__Impl ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:893:1: ( rule__Entity__Group__4__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:894:2: rule__Entity__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Entity__Group__4__Impl_in_rule__Entity__Group__41770);
            rule__Entity__Group__4__Impl();

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
    // $ANTLR end "rule__Entity__Group__4"


    // $ANTLR start "rule__Entity__Group__4__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:900:1: rule__Entity__Group__4__Impl : ( '}' ) ;
    public final void rule__Entity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:904:1: ( ( '}' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:905:1: ( '}' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:905:1: ( '}' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:906:1: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__Entity__Group__4__Impl1798); 
             after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__4__Impl"


    // $ANTLR start "rule__Datatype__Group__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:929:1: rule__Datatype__Group__0 : rule__Datatype__Group__0__Impl rule__Datatype__Group__1 ;
    public final void rule__Datatype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:933:1: ( rule__Datatype__Group__0__Impl rule__Datatype__Group__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:934:2: rule__Datatype__Group__0__Impl rule__Datatype__Group__1
            {
            pushFollow(FOLLOW_rule__Datatype__Group__0__Impl_in_rule__Datatype__Group__01839);
            rule__Datatype__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Datatype__Group__1_in_rule__Datatype__Group__01842);
            rule__Datatype__Group__1();

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
    // $ANTLR end "rule__Datatype__Group__0"


    // $ANTLR start "rule__Datatype__Group__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:941:1: rule__Datatype__Group__0__Impl : ( 'datatype' ) ;
    public final void rule__Datatype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:945:1: ( ( 'datatype' ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:946:1: ( 'datatype' )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:946:1: ( 'datatype' )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:947:1: 'datatype'
            {
             before(grammarAccess.getDatatypeAccess().getDatatypeKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Datatype__Group__0__Impl1870); 
             after(grammarAccess.getDatatypeAccess().getDatatypeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Datatype__Group__0__Impl"


    // $ANTLR start "rule__Datatype__Group__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:960:1: rule__Datatype__Group__1 : rule__Datatype__Group__1__Impl ;
    public final void rule__Datatype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:964:1: ( rule__Datatype__Group__1__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:965:2: rule__Datatype__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Datatype__Group__1__Impl_in_rule__Datatype__Group__11901);
            rule__Datatype__Group__1__Impl();

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
    // $ANTLR end "rule__Datatype__Group__1"


    // $ANTLR start "rule__Datatype__Group__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:971:1: rule__Datatype__Group__1__Impl : ( ( rule__Datatype__NameAssignment_1 ) ) ;
    public final void rule__Datatype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:975:1: ( ( ( rule__Datatype__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:976:1: ( ( rule__Datatype__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:976:1: ( ( rule__Datatype__NameAssignment_1 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:977:1: ( rule__Datatype__NameAssignment_1 )
            {
             before(grammarAccess.getDatatypeAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:978:1: ( rule__Datatype__NameAssignment_1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:978:2: rule__Datatype__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Datatype__NameAssignment_1_in_rule__Datatype__Group__1__Impl1928);
            rule__Datatype__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDatatypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Datatype__Group__1__Impl"


    // $ANTLR start "rule__Property__Group__0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:992:1: rule__Property__Group__0 : rule__Property__Group__0__Impl rule__Property__Group__1 ;
    public final void rule__Property__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:996:1: ( rule__Property__Group__0__Impl rule__Property__Group__1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:997:2: rule__Property__Group__0__Impl rule__Property__Group__1
            {
            pushFollow(FOLLOW_rule__Property__Group__0__Impl_in_rule__Property__Group__01962);
            rule__Property__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Property__Group__1_in_rule__Property__Group__01965);
            rule__Property__Group__1();

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
    // $ANTLR end "rule__Property__Group__0"


    // $ANTLR start "rule__Property__Group__0__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1004:1: rule__Property__Group__0__Impl : ( ( rule__Property__TypeAssignment_0 ) ) ;
    public final void rule__Property__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1008:1: ( ( ( rule__Property__TypeAssignment_0 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1009:1: ( ( rule__Property__TypeAssignment_0 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1009:1: ( ( rule__Property__TypeAssignment_0 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1010:1: ( rule__Property__TypeAssignment_0 )
            {
             before(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1011:1: ( rule__Property__TypeAssignment_0 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1011:2: rule__Property__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__Property__TypeAssignment_0_in_rule__Property__Group__0__Impl1992);
            rule__Property__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__Group__0__Impl"


    // $ANTLR start "rule__Property__Group__1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1021:1: rule__Property__Group__1 : rule__Property__Group__1__Impl ;
    public final void rule__Property__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1025:1: ( rule__Property__Group__1__Impl )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1026:2: rule__Property__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Property__Group__1__Impl_in_rule__Property__Group__12022);
            rule__Property__Group__1__Impl();

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
    // $ANTLR end "rule__Property__Group__1"


    // $ANTLR start "rule__Property__Group__1__Impl"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1032:1: rule__Property__Group__1__Impl : ( ( rule__Property__NameAssignment_1 ) ) ;
    public final void rule__Property__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1036:1: ( ( ( rule__Property__NameAssignment_1 ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1037:1: ( ( rule__Property__NameAssignment_1 ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1037:1: ( ( rule__Property__NameAssignment_1 ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1038:1: ( rule__Property__NameAssignment_1 )
            {
             before(grammarAccess.getPropertyAccess().getNameAssignment_1()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1039:1: ( rule__Property__NameAssignment_1 )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1039:2: rule__Property__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Property__NameAssignment_1_in_rule__Property__Group__1__Impl2049);
            rule__Property__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__Group__1__Impl"


    // $ANTLR start "rule__File__ElementsAssignment"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1054:1: rule__File__ElementsAssignment : ( ruleElement ) ;
    public final void rule__File__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1058:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1059:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1059:1: ( ruleElement )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1060:1: ruleElement
            {
             before(grammarAccess.getFileAccess().getElementsElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__File__ElementsAssignment2088);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getFileAccess().getElementsElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__File__ElementsAssignment"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1069:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildCard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1073:1: ( ( ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1074:1: ( ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1074:1: ( ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1075:1: ruleQualifiedNameWithWildCard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_12119);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Namespace__NameAssignment_0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1084:1: rule__Namespace__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__Namespace__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1088:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1089:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1089:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1090:1: ruleQualifiedName
            {
             before(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_02150);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__NameAssignment_0"


    // $ANTLR start "rule__Namespace__ElementsAssignment_2"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1099:1: rule__Namespace__ElementsAssignment_2 : ( ruleElement ) ;
    public final void rule__Namespace__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1103:1: ( ( ruleElement ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1104:1: ( ruleElement )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1104:1: ( ruleElement )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1105:1: ruleElement
            {
             before(grammarAccess.getNamespaceAccess().getElementsElementParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleElement_in_rule__Namespace__ElementsAssignment_22181);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getNamespaceAccess().getElementsElementParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__ElementsAssignment_2"


    // $ANTLR start "rule__Entity__NameAssignment_1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1114:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1118:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1119:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1119:1: ( RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1120:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_12212); 
             after(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__NameAssignment_1"


    // $ANTLR start "rule__Entity__PropertiesAssignment_3"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1129:1: rule__Entity__PropertiesAssignment_3 : ( ruleProperty ) ;
    public final void rule__Entity__PropertiesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1133:1: ( ( ruleProperty ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1134:1: ( ruleProperty )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1134:1: ( ruleProperty )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1135:1: ruleProperty
            {
             before(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_32243);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__PropertiesAssignment_3"


    // $ANTLR start "rule__Datatype__NameAssignment_1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1144:1: rule__Datatype__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Datatype__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1148:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1149:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1149:1: ( RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1150:1: RULE_ID
            {
             before(grammarAccess.getDatatypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Datatype__NameAssignment_12274); 
             after(grammarAccess.getDatatypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Datatype__NameAssignment_1"


    // $ANTLR start "rule__Property__TypeAssignment_0"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1159:1: rule__Property__TypeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Property__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1163:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1164:1: ( ( ruleQualifiedName ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1164:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1165:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0()); 
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1166:1: ( ruleQualifiedName )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1167:1: ruleQualifiedName
            {
             before(grammarAccess.getPropertyAccess().getTypeTypeQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Property__TypeAssignment_02309);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPropertyAccess().getTypeTypeQualifiedNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__TypeAssignment_0"


    // $ANTLR start "rule__Property__NameAssignment_1"
    // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1178:1: rule__Property__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Property__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1182:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1183:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1183:1: ( RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.ui/src-gen/org/eclipse/xtext/idea/sdomain/ui/contentassist/antlr/internal/InternalSDomain.g:1184:1: RULE_ID
            {
             before(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Property__NameAssignment_12344); 
             after(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Property__NameAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__File__ElementsAssignment_in_ruleFile94 = new BitSet(new long[]{0x0000000000030812L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0_in_ruleQualifiedNameWithWildCard215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Namespace__Group__0_in_ruleNamespace335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Element__Alternatives_in_ruleElement395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Datatype__Group__0_in_ruleDatatype575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Group__0_in_ruleProperty635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_rule__Element__Alternatives671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Element__Alternatives688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Element__Alternatives705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Type__Alternatives737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_rule__Type__Alternatives754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__0784 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Import__Group__0__Impl815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__0__Impl_in_rule__QualifiedNameWithWildCard__Group__0907 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1_in_rule__QualifiedNameWithWildCard__Group__0910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildCard__Group__0__Impl937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildCard__Group__1__Impl_in_rule__QualifiedNameWithWildCard__Group__1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__QualifiedNameWithWildCard__Group__1__Impl995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01032 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl1118 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__01153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__01156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__QualifiedName__Group_1__0__Impl1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__11215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Namespace__Group__0__Impl_in_rule__Namespace__Group__01275 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Namespace__Group__1_in_rule__Namespace__Group__01278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Namespace__NameAssignment_0_in_rule__Namespace__Group__0__Impl1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Namespace__Group__1__Impl_in_rule__Namespace__Group__11335 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_rule__Namespace__Group__2_in_rule__Namespace__Group__11338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Namespace__Group__1__Impl1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Namespace__Group__2__Impl_in_rule__Namespace__Group__21397 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_rule__Namespace__Group__3_in_rule__Namespace__Group__21400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Namespace__ElementsAssignment_2_in_rule__Namespace__Group__2__Impl1427 = new BitSet(new long[]{0x0000000000030812L});
    public static final BitSet FOLLOW_rule__Namespace__Group__3__Impl_in_rule__Namespace__Group__31458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Namespace__Group__3__Impl1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0__Impl_in_rule__Entity__Group__01525 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__01528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Entity__Group__0__Impl1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__1__Impl_in_rule__Entity__Group__11587 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__11590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1__Impl1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__2__Impl_in_rule__Entity__Group__21647 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Entity__Group__2__Impl1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__3__Impl_in_rule__Entity__Group__31709 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__PropertiesAssignment_3_in_rule__Entity__Group__3__Impl1739 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Entity__Group__4__Impl_in_rule__Entity__Group__41770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Entity__Group__4__Impl1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Datatype__Group__0__Impl_in_rule__Datatype__Group__01839 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Datatype__Group__1_in_rule__Datatype__Group__01842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Datatype__Group__0__Impl1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Datatype__Group__1__Impl_in_rule__Datatype__Group__11901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Datatype__NameAssignment_1_in_rule__Datatype__Group__1__Impl1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Group__0__Impl_in_rule__Property__Group__01962 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Property__Group__1_in_rule__Property__Group__01965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__TypeAssignment_0_in_rule__Property__Group__0__Impl1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Group__1__Impl_in_rule__Property__Group__12022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__NameAssignment_1_in_rule__Property__Group__1__Impl2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__File__ElementsAssignment2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_rule__Import__ImportedNamespaceAssignment_12119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Namespace__NameAssignment_02150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_rule__Namespace__ElementsAssignment_22181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_12212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_32243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Datatype__NameAssignment_12274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Property__TypeAssignment_02309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Property__NameAssignment_12344 = new BitSet(new long[]{0x0000000000000002L});

}