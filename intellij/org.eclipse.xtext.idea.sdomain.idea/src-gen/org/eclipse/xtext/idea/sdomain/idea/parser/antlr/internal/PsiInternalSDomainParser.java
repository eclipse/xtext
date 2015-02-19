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
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:62:2: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:63:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:63:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:64:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:64:3: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:65:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getFile_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_ruleElement_in_ruleFile94);
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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:77:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:77:16: ( ruleImport EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:78:2: ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport120);
            ruleImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport126); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:84:1: ruleImport : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final void ruleImport() throws RecognitionException {
        Token otherlv_0=null;



        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:87:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:88:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:88:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:89:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport154); 

            			doneLeaf(otherlv_0, elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:96:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:97:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:97:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:98:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {

            					markComposite(elementTypeProvider.getImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport181);
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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:111:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:111:35: ( ruleQualifiedNameWithWildCard EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:112:2: ruleQualifiedNameWithWildCard EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameWithWildCardElementType()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard212);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard218); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:118:1: ruleQualifiedNameWithWildCard : ( ruleQualifiedName (kw= '.*' )? ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {
        Token kw=null;



        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:121:2: ( ( ruleQualifiedName (kw= '.*' )? ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:122:2: ( ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:122:2: ( ruleQualifiedName (kw= '.*' )? )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:123:3: ruleQualifiedName (kw= '.*' )?
            {

            			markComposite(elementTypeProvider.getQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType());
            		
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard244);
            ruleQualifiedName();

            state._fsp--;


            			doneComposite();
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:130:3: (kw= '.*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:131:4: kw= '.*'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleQualifiedNameWithWildCard264); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:143:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:143:23: ( ruleQualifiedName EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:144:2: ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName290);
            ruleQualifiedName();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName296); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:150:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;



        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:153:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:154:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:154:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:155:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName324); 

            			doneLeaf(this_ID_0, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:162:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:163:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedName344); 

            	    				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName361); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:182:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:182:19: ( ruleNamespace EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:183:2: ruleNamespace EOF
            {
             markComposite(elementTypeProvider.getNamespaceElementType()); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace387);
            ruleNamespace();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace393); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:189:1: ruleNamespace : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) ;
    public final void ruleNamespace() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;



        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:192:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:193:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:193:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:194:3: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}'
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:194:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:195:4: (lv_name_0_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:195:4: (lv_name_0_0= ruleQualifiedName )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:196:5: lv_name_0_0= ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamespace434);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleNamespace459); 

            			doneLeaf(otherlv_1, elementTypeProvider.getNamespace_LeftCurlyBracketKeyword_1ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:212:3: ( (lv_elements_2_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==11||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:213:4: (lv_elements_2_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:213:4: (lv_elements_2_0= ruleElement )
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:214:5: lv_elements_2_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getNamespace_ElementsElementParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FOLLOW_ruleElement_in_ruleNamespace486);
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
            		
            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleNamespace512); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:234:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:234:17: ( ruleElement EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:235:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement532);
            ruleElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement538); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:241:1: ruleElement : ( ruleNamespace | ruleType | ruleImport ) ;
    public final void ruleElement() throws RecognitionException {


        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:244:2: ( ( ruleNamespace | ruleType | ruleImport ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:245:2: ( ruleNamespace | ruleType | ruleImport )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:245:2: ( ruleNamespace | ruleType | ruleImport )
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
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:246:3: ruleNamespace
                    {

                    			markComposite(elementTypeProvider.getElement_NamespaceParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_ruleNamespace_in_ruleElement564);
                    ruleNamespace();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:254:3: ruleType
                    {

                    			markComposite(elementTypeProvider.getElement_TypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_ruleType_in_ruleElement584);
                    ruleType();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:262:3: ruleImport
                    {

                    			markComposite(elementTypeProvider.getElement_ImportParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_ruleImport_in_ruleElement604);
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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:273:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:273:14: ( ruleType EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:274:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType624);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType630); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:280:1: ruleType : ( ruleEntity | ruleDatatype ) ;
    public final void ruleType() throws RecognitionException {


        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:283:2: ( ( ruleEntity | ruleDatatype ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:284:2: ( ruleEntity | ruleDatatype )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:284:2: ( ruleEntity | ruleDatatype )
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
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:285:3: ruleEntity
                    {

                    			markComposite(elementTypeProvider.getType_EntityParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_ruleEntity_in_ruleType656);
                    ruleEntity();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:293:3: ruleDatatype
                    {

                    			markComposite(elementTypeProvider.getType_DatatypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_ruleDatatype_in_ruleType676);
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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:304:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:304:16: ( ruleEntity EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:305:2: ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity696);
            ruleEntity();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity702); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:311:1: ruleEntity : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final void ruleEntity() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;



        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:314:2: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:315:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:315:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:316:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleEntity730); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEntity_EntityKeyword_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:323:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:324:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:324:4: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:325:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity757); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleEntity782); 

            			doneLeaf(otherlv_2, elementTypeProvider.getEntity_LeftCurlyBracketKeyword_2ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:341:3: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:342:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:342:4: (lv_properties_3_0= ruleProperty )
            	    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:343:5: lv_properties_3_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getEntity_PropertiesPropertyParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity809);
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
            		
            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleEntity835); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:363:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:363:18: ( ruleDatatype EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:364:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype855);
            ruleDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype861); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:370:1: ruleDatatype : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;



        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:373:2: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:374:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:374:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:375:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleDatatype889); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:382:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:383:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:383:4: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:384:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype916); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:397:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:397:18: ( ruleProperty EOF )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:398:2: ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty947);
            ruleProperty();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty953); 

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
    // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:404:1: ruleProperty : ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleProperty() throws RecognitionException {
        Token lv_name_1_0=null;



        try {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:407:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:408:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:408:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:409:3: ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:409:3: ( ( ruleQualifiedName ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:410:4: ( ruleQualifiedName )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:410:4: ( ruleQualifiedName )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:411:5: ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType());
            				
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleProperty992);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:420:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:421:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:421:4: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.idea.sdomain.idea/src-gen/org/eclipse/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:422:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty1030); 

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
    public static final BitSet FOLLOW_ruleElement_in_ruleFile94 = new BitSet(new long[]{0x0000000000030812L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard244 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedNameWithWildCard264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName324 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName344 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName361 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespace434 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamespace459 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_ruleElement_in_ruleNamespace486 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_15_in_ruleNamespace512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleElement564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleElement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleElement604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleType676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity730 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity757 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEntity782 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity809 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleEntity835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDatatype889 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProperty992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty1030 = new BitSet(new long[]{0x0000000000000002L});

}