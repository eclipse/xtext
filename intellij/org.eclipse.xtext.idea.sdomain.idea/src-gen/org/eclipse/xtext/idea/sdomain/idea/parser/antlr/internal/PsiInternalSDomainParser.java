package org.eclipse.xtext.idea.sdomain.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.idea.sdomain.services.SDomainGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSDomainParser extends AbstractPsiAntlrParser {
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


        public PsiInternalSDomainParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSDomainParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSDomainParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g"; }



    	protected SDomainGrammarAccess grammarAccess;

    	protected SDomainElementTypeProvider elementTypeProvider;

    	public PsiInternalSDomainParser(PsiBuilder builder, TokenStream input, SDomainElementTypeProvider elementTypeProvider, SDomainGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "File";
    	}




    // $ANTLR start "entryRuleFile"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:52:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:52:14: ( ruleFile EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:53:2: ruleFile EOF
            {
             markComposite(elementTypeProvider.getFileElementType()); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile54);
            ruleFile();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFile60); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:59:1: ruleFile : ( (lv_elements_0_0= ruleElement ) )* ;
    public final void ruleFile() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:59:9: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:60:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:60:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:61:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:61:3: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:62:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getFile_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_ruleElement_in_ruleFile85);
            	    ruleElement();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:74:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:74:16: ( ruleImport EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:75:2: ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport111);
            ruleImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport117); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:81:1: ruleImport : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final void ruleImport() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:81:11: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:82:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:82:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:83:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport136); 

            			doneLeaf(otherlv_0, elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:90:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:91:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:91:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:92:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {

            					markComposite(elementTypeProvider.getImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport163);
            ruleQualifiedNameWithWildCard();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            }


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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:105:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:105:35: ( ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:106:2: ruleQualifiedNameWithWildCard EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameWithWildCardElementType()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard194);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard200); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:112:1: ruleQualifiedNameWithWildCard : ( ruleQualifiedName (kw= '.*' )? ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {
        Token kw=null;

        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:112:30: ( ( ruleQualifiedName (kw= '.*' )? ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:113:2: ( ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:113:2: ( ruleQualifiedName (kw= '.*' )? )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:114:3: ruleQualifiedName (kw= '.*' )?
            {

            			markComposite(elementTypeProvider.getQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType());
            		
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard217);
            ruleQualifiedName();

            state._fsp--;


            			doneComposite();
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:121:3: (kw= '.*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:122:4: kw= '.*'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleQualifiedNameWithWildCard237); 

                    				doneLeaf(kw, elementTypeProvider.getQualifiedNameWithWildCard_FullStopAsteriskKeyword_1ElementType());
                    			

                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:134:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:134:23: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:135:2: ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName263);
            ruleQualifiedName();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName269); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:141:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:141:18: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:142:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:142:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:143:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName288); 

            			doneLeaf(this_ID_0, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:150:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:151:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedName308); 

            	    				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName325); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_1_1ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNamespace"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:170:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:170:19: ( ruleNamespace EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:171:2: ruleNamespace EOF
            {
             markComposite(elementTypeProvider.getNamespaceElementType()); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace351);
            ruleNamespace();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace357); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:177:1: ruleNamespace : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) ;
    public final void ruleNamespace() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:177:14: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:178:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:178:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:179:3: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}'
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:179:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:180:4: (lv_name_0_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:180:4: (lv_name_0_0= ruleQualifiedName )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:181:5: lv_name_0_0= ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamespace389);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleNamespace414); 

            			doneLeaf(otherlv_1, elementTypeProvider.getNamespace_LeftCurlyBracketKeyword_1ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:197:3: ( (lv_elements_2_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==11||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:198:4: (lv_elements_2_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:198:4: (lv_elements_2_0= ruleElement )
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:199:5: lv_elements_2_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getNamespace_ElementsElementParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FOLLOW_ruleElement_in_ruleNamespace441);
            	    ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleNamespace467); 

            			doneLeaf(otherlv_3, elementTypeProvider.getNamespace_RightCurlyBracketKeyword_3ElementType());
            		

            }


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
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:219:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:219:17: ( ruleElement EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:220:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement487);
            ruleElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement493); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:226:1: ruleElement : ( ruleNamespace | ruleType | ruleImport ) ;
    public final void ruleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:226:12: ( ( ruleNamespace | ruleType | ruleImport ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:227:2: ( ruleNamespace | ruleType | ruleImport )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:227:2: ( ruleNamespace | ruleType | ruleImport )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 16:
            case 17:
                {
                alt5=2;
                }
                break;
            case 11:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:228:3: ruleNamespace
                    {

                    			markComposite(elementTypeProvider.getElement_NamespaceParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_ruleNamespace_in_ruleElement510);
                    ruleNamespace();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:236:3: ruleType
                    {

                    			markComposite(elementTypeProvider.getElement_TypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_ruleType_in_ruleElement530);
                    ruleType();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:244:3: ruleImport
                    {

                    			markComposite(elementTypeProvider.getElement_ImportParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_ruleImport_in_ruleElement550);
                    ruleImport();

                    state._fsp--;


                    			doneComposite();
                    		

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
        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:255:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:255:14: ( ruleType EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:256:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType570);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType576); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:262:1: ruleType : ( ruleEntity | ruleDatatype ) ;
    public final void ruleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:262:9: ( ( ruleEntity | ruleDatatype ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:263:2: ( ruleEntity | ruleDatatype )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:263:2: ( ruleEntity | ruleDatatype )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:264:3: ruleEntity
                    {

                    			markComposite(elementTypeProvider.getType_EntityParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_ruleEntity_in_ruleType593);
                    ruleEntity();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:272:3: ruleDatatype
                    {

                    			markComposite(elementTypeProvider.getType_DatatypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_ruleDatatype_in_ruleType613);
                    ruleDatatype();

                    state._fsp--;


                    			doneComposite();
                    		

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
        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:283:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:283:16: ( ruleEntity EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:284:2: ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity633);
            ruleEntity();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity639); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:290:1: ruleEntity : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final void ruleEntity() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:290:11: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:291:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:291:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:292:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleEntity658); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEntity_EntityKeyword_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:299:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:300:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:300:4: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:301:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity685); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleEntity710); 

            			doneLeaf(otherlv_2, elementTypeProvider.getEntity_LeftCurlyBracketKeyword_2ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:317:3: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:318:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:318:4: (lv_properties_3_0= ruleProperty )
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:319:5: lv_properties_3_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getEntity_PropertiesPropertyParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity737);
            	    ruleProperty();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleEntity763); 

            			doneLeaf(otherlv_4, elementTypeProvider.getEntity_RightCurlyBracketKeyword_4ElementType());
            		

            }


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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleDatatype"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:339:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:339:18: ( ruleDatatype EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:340:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype783);
            ruleDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype789); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:346:1: ruleDatatype : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:346:13: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:347:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:347:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:348:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleDatatype808); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:355:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:356:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:356:4: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:357:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype835); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getDatatype_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            }


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
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:370:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:370:18: ( ruleProperty EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:371:2: ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty866);
            ruleProperty();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty872); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:377:1: ruleProperty : ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleProperty() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:377:13: ( ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:378:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:378:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:379:3: ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:379:3: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:380:4: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:380:4: ( ruleQualifiedName )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:381:5: ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType());
            				
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleProperty902);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:390:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:391:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:391:4: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:392:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty940); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            }


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
    // $ANTLR end "ruleProperty"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleFile_in_entryRuleFile54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFile60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_ruleFile85 = new BitSet(new long[]{0x0000000000030812L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport136 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard217 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedNameWithWildCard237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName288 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName308 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName325 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespace389 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamespace414 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_ruleElement_in_ruleNamespace441 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_15_in_ruleNamespace467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleElement510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleElement530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleElement550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleType613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity658 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity685 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEntity710 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity737 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleEntity763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDatatype808 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProperty902 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty940 = new BitSet(new long[]{0x0000000000000002L});

}