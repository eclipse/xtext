package org.xtext.idea.sdomain.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.xtext.idea.sdomain.idea.lang.SDomainElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;

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
    public String getGrammarFileName() { return "../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g"; }


    public SDomainElementTypeProvider elementTypeProvider;

    public PsiInternalSDomainParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, SDomainElementTypeProvider elementTypeProvider) {
    	super(builder, input, tokenTypeProvider);
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "File";
    }




    // $ANTLR start "entryRuleFile"
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:44:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:44:14: ( ruleFile EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:45:2: ruleFile EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleFile_in_entryRuleFile54);
            ruleFile();

            state._fsp--;

             doneComposite(elementTypeProvider.getFileElementType()); 
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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:53:1: ruleFile : ( (lv_elements_0_0= ruleElement ) )* ;
    public final void ruleFile() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:53:9: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:54:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:54:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:55:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:55:3: (lv_elements_0_0= ruleElement )
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:56:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite();
            	    			
            	    pushFollow(FOLLOW_ruleElement_in_ruleFile89);
            	    ruleElement();

            	    state._fsp--;


            	    				doneComposite(elementTypeProvider.getFile_ElementsElementParserRuleCall_0ElementType());
            	    			

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:68:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:68:16: ( ruleImport EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:69:2: ruleImport EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport115);
            ruleImport();

            state._fsp--;

             doneComposite(elementTypeProvider.getImportElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport121); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:77:1: ruleImport : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final void ruleImport() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:77:11: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:78:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:78:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:79:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport144); 

            			doneLeaf(otherlv_0, elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:86:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:87:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:87:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:88:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {

            					markComposite();
            				
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport171);
            ruleQualifiedNameWithWildCard();

            state._fsp--;


            					doneComposite(elementTypeProvider.getImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType());
            				

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:101:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:101:35: ( ruleQualifiedNameWithWildCard EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:102:2: ruleQualifiedNameWithWildCard EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard202);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

             doneComposite(elementTypeProvider.getQualifiedNameWithWildCardElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard208); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:110:1: ruleQualifiedNameWithWildCard : ( ruleQualifiedName (kw= '.*' )? ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {
        Token kw=null;

        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:110:30: ( ( ruleQualifiedName (kw= '.*' )? ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:111:2: ( ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:111:2: ( ruleQualifiedName (kw= '.*' )? )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:112:3: ruleQualifiedName (kw= '.*' )?
            {

            			markComposite();
            		
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard229);
            ruleQualifiedName();

            state._fsp--;


            			doneComposite(elementTypeProvider.getQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType());
            		
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:119:3: (kw= '.*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:120:4: kw= '.*'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleQualifiedNameWithWildCard249); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:132:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:132:23: ( ruleQualifiedName EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:133:2: ruleQualifiedName EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName275);
            ruleQualifiedName();

            state._fsp--;

             doneComposite(elementTypeProvider.getQualifiedNameElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName281); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:141:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:141:18: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:142:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:142:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:143:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName304); 

            			doneLeaf(this_ID_0, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:150:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:151:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedName324); 

            	    				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName341); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:170:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:170:19: ( ruleNamespace EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:171:2: ruleNamespace EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleNamespace_in_entryRuleNamespace367);
            ruleNamespace();

            state._fsp--;

             doneComposite(elementTypeProvider.getNamespaceElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespace373); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:179:1: ruleNamespace : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) ;
    public final void ruleNamespace() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:179:14: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:180:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:180:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:181:3: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}'
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:181:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:182:4: (lv_name_0_0= ruleQualifiedName )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:182:4: (lv_name_0_0= ruleQualifiedName )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:183:5: lv_name_0_0= ruleQualifiedName
            {

            					markComposite();
            				
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamespace409);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite(elementTypeProvider.getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleNamespace434); 

            			doneLeaf(otherlv_1, elementTypeProvider.getNamespace_LeftCurlyBracketKeyword_1ElementType());
            		
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:199:3: ( (lv_elements_2_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==11||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:200:4: (lv_elements_2_0= ruleElement )
            	    {
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:200:4: (lv_elements_2_0= ruleElement )
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:201:5: lv_elements_2_0= ruleElement
            	    {

            	    					markComposite();
            	    				
            	    pushFollow(FOLLOW_ruleElement_in_ruleNamespace461);
            	    ruleElement();

            	    state._fsp--;


            	    					doneComposite(elementTypeProvider.getNamespace_ElementsElementParserRuleCall_2_0ElementType());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleNamespace487); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:221:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:221:17: ( ruleElement EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:222:2: ruleElement EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleElement_in_entryRuleElement507);
            ruleElement();

            state._fsp--;

             doneComposite(elementTypeProvider.getElementElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElement513); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:230:1: ruleElement : ( ruleNamespace | ruleType | ruleImport ) ;
    public final void ruleElement() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:230:12: ( ( ruleNamespace | ruleType | ruleImport ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:231:2: ( ruleNamespace | ruleType | ruleImport )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:231:2: ( ruleNamespace | ruleType | ruleImport )
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
                    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:232:3: ruleNamespace
                    {

                    			markComposite();
                    		
                    pushFollow(FOLLOW_ruleNamespace_in_ruleElement534);
                    ruleNamespace();

                    state._fsp--;


                    			doneComposite(elementTypeProvider.getElement_NamespaceParserRuleCall_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:240:3: ruleType
                    {

                    			markComposite();
                    		
                    pushFollow(FOLLOW_ruleType_in_ruleElement554);
                    ruleType();

                    state._fsp--;


                    			doneComposite(elementTypeProvider.getElement_TypeParserRuleCall_1ElementType());
                    		

                    }
                    break;
                case 3 :
                    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:248:3: ruleImport
                    {

                    			markComposite();
                    		
                    pushFollow(FOLLOW_ruleImport_in_ruleElement574);
                    ruleImport();

                    state._fsp--;


                    			doneComposite(elementTypeProvider.getElement_ImportParserRuleCall_2ElementType());
                    		

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:259:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:259:14: ( ruleType EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:260:2: ruleType EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType594);
            ruleType();

            state._fsp--;

             doneComposite(elementTypeProvider.getTypeElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType600); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:268:1: ruleType : ( ruleEntity | ruleDatatype ) ;
    public final void ruleType() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:268:9: ( ( ruleEntity | ruleDatatype ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:269:2: ( ruleEntity | ruleDatatype )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:269:2: ( ruleEntity | ruleDatatype )
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
                    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:270:3: ruleEntity
                    {

                    			markComposite();
                    		
                    pushFollow(FOLLOW_ruleEntity_in_ruleType621);
                    ruleEntity();

                    state._fsp--;


                    			doneComposite(elementTypeProvider.getType_EntityParserRuleCall_0ElementType());
                    		

                    }
                    break;
                case 2 :
                    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:278:3: ruleDatatype
                    {

                    			markComposite();
                    		
                    pushFollow(FOLLOW_ruleDatatype_in_ruleType641);
                    ruleDatatype();

                    state._fsp--;


                    			doneComposite(elementTypeProvider.getType_DatatypeParserRuleCall_1ElementType());
                    		

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:289:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:289:16: ( ruleEntity EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:290:2: ruleEntity EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity661);
            ruleEntity();

            state._fsp--;

             doneComposite(elementTypeProvider.getEntityElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity667); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:298:1: ruleEntity : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final void ruleEntity() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:298:11: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:299:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:299:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:300:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleEntity690); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEntity_EntityKeyword_0ElementType());
            		
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:307:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:308:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:308:4: (lv_name_1_0= RULE_ID )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:309:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity717); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleEntity742); 

            			doneLeaf(otherlv_2, elementTypeProvider.getEntity_LeftCurlyBracketKeyword_2ElementType());
            		
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:325:3: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:326:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:326:4: (lv_properties_3_0= ruleProperty )
            	    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:327:5: lv_properties_3_0= ruleProperty
            	    {

            	    					markComposite();
            	    				
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity769);
            	    ruleProperty();

            	    state._fsp--;


            	    					doneComposite(elementTypeProvider.getEntity_PropertiesPropertyParserRuleCall_3_0ElementType());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleEntity795); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:347:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:347:18: ( ruleDatatype EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:348:2: ruleDatatype EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype815);
            ruleDatatype();

            state._fsp--;

             doneComposite(elementTypeProvider.getDatatypeElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype821); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:356:1: ruleDatatype : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:356:13: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:357:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:357:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:358:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleDatatype844); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:365:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:366:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:366:4: (lv_name_1_0= RULE_ID )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:367:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype871); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:380:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:380:18: ( ruleProperty EOF )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:381:2: ruleProperty EOF
            {
             markComposite(); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty902);
            ruleProperty();

            state._fsp--;

             doneComposite(elementTypeProvider.getPropertyElementType()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty908); 

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
    // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:389:1: ruleProperty : ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleProperty() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:389:13: ( ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:390:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:390:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:391:3: ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:391:3: ( ( ruleQualifiedName ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:392:4: ( ruleQualifiedName )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:392:4: ( ruleQualifiedName )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:393:5: ruleQualifiedName
            {

            					markComposite();
            				
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleProperty942);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite(elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType());
            				

            }


            }

            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:402:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:403:4: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:403:4: (lv_name_1_0= RULE_ID )
            // ../org.xtext.idea.sdomain.idea/src-gen/org/xtext/idea/sdomain/idea/parser/antlr/internal/PsiInternalSDomain.g:404:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProperty980); 

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
    public static final BitSet FOLLOW_ruleElement_in_ruleFile89 = new BitSet(new long[]{0x0000000000030812L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport144 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard229 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedNameWithWildCard249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName304 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName324 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName341 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleNamespace_in_entryRuleNamespace367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespace373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespace409 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleNamespace434 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_ruleElement_in_ruleNamespace461 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_15_in_ruleNamespace487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElement_in_entryRuleElement507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElement513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespace_in_ruleElement534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleElement554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleElement574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleType641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntity690 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity717 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleEntity742 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity769 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleEntity795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype815 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDatatype844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProperty942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProperty980 = new BitSet(new long[]{0x0000000000000002L});

}