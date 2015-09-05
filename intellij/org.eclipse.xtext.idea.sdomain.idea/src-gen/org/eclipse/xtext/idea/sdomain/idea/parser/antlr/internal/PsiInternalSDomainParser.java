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
    public String getGrammarFileName() { return "PsiInternalSDomain.g"; }



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
    // PsiInternalSDomain.g:52:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:52:14: ( ruleFile EOF )
            // PsiInternalSDomain.g:53:2: ruleFile EOF
            {
             markComposite(elementTypeProvider.getFileElementType()); 
            pushFollow(FOLLOW_1);
            ruleFile();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:58:1: ruleFile : ( (lv_elements_0_0= ruleElement ) )* ;
    public final void ruleFile() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:58:9: ( ( (lv_elements_0_0= ruleElement ) )* )
            // PsiInternalSDomain.g:59:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // PsiInternalSDomain.g:59:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalSDomain.g:60:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // PsiInternalSDomain.g:60:3: (lv_elements_0_0= ruleElement )
            	    // PsiInternalSDomain.g:61:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getFile_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
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
    // PsiInternalSDomain.g:73:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:73:16: ( ruleImport EOF )
            // PsiInternalSDomain.g:74:2: ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:79:1: ruleImport : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final void ruleImport() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalSDomain.g:79:11: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // PsiInternalSDomain.g:80:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // PsiInternalSDomain.g:80:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // PsiInternalSDomain.g:81:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {

            			markLeaf(elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSDomain.g:88:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // PsiInternalSDomain.g:89:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // PsiInternalSDomain.g:89:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // PsiInternalSDomain.g:90:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {

            					markComposite(elementTypeProvider.getImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_2);
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
    // PsiInternalSDomain.g:103:1: entryRuleQualifiedNameWithWildCard : ruleQualifiedNameWithWildCard EOF ;
    public final void entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:103:35: ( ruleQualifiedNameWithWildCard EOF )
            // PsiInternalSDomain.g:104:2: ruleQualifiedNameWithWildCard EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameWithWildCardElementType()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedNameWithWildCard();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:109:1: ruleQualifiedNameWithWildCard : ( ruleQualifiedName (kw= '.*' )? ) ;
    public final void ruleQualifiedNameWithWildCard() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalSDomain.g:109:30: ( ( ruleQualifiedName (kw= '.*' )? ) )
            // PsiInternalSDomain.g:110:2: ( ruleQualifiedName (kw= '.*' )? )
            {
            // PsiInternalSDomain.g:110:2: ( ruleQualifiedName (kw= '.*' )? )
            // PsiInternalSDomain.g:111:3: ruleQualifiedName (kw= '.*' )?
            {

            			markComposite(elementTypeProvider.getQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType());
            		
            pushFollow(FOLLOW_5);
            ruleQualifiedName();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalSDomain.g:118:3: (kw= '.*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalSDomain.g:119:4: kw= '.*'
                    {

                    				markLeaf(elementTypeProvider.getQualifiedNameWithWildCard_FullStopAsteriskKeyword_1ElementType());
                    			
                    kw=(Token)match(input,12,FOLLOW_2); 

                    				doneLeaf(kw);
                    			

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
    // PsiInternalSDomain.g:131:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:131:23: ( ruleQualifiedName EOF )
            // PsiInternalSDomain.g:132:2: ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:137:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalSDomain.g:137:18: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalSDomain.g:138:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalSDomain.g:138:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalSDomain.g:139:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalSDomain.g:146:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalSDomain.g:147:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getQualifiedName_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    				doneLeaf(this_ID_2);
            	    			

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
    // PsiInternalSDomain.g:166:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:166:19: ( ruleNamespace EOF )
            // PsiInternalSDomain.g:167:2: ruleNamespace EOF
            {
             markComposite(elementTypeProvider.getNamespaceElementType()); 
            pushFollow(FOLLOW_1);
            ruleNamespace();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:172:1: ruleNamespace : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) ;
    public final void ruleNamespace() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalSDomain.g:172:14: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) )
            // PsiInternalSDomain.g:173:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            {
            // PsiInternalSDomain.g:173:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            // PsiInternalSDomain.g:174:3: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}'
            {
            // PsiInternalSDomain.g:174:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // PsiInternalSDomain.g:175:4: (lv_name_0_0= ruleQualifiedName )
            {
            // PsiInternalSDomain.g:175:4: (lv_name_0_0= ruleQualifiedName )
            // PsiInternalSDomain.g:176:5: lv_name_0_0= ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_7);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getNamespace_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalSDomain.g:192:3: ( (lv_elements_2_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==11||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalSDomain.g:193:4: (lv_elements_2_0= ruleElement )
            	    {
            	    // PsiInternalSDomain.g:193:4: (lv_elements_2_0= ruleElement )
            	    // PsiInternalSDomain.g:194:5: lv_elements_2_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getNamespace_ElementsElementParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FOLLOW_8);
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


            			markLeaf(elementTypeProvider.getNamespace_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

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
    // PsiInternalSDomain.g:214:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:214:17: ( ruleElement EOF )
            // PsiInternalSDomain.g:215:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:220:1: ruleElement : ( ruleNamespace | ruleType | ruleImport ) ;
    public final void ruleElement() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:220:12: ( ( ruleNamespace | ruleType | ruleImport ) )
            // PsiInternalSDomain.g:221:2: ( ruleNamespace | ruleType | ruleImport )
            {
            // PsiInternalSDomain.g:221:2: ( ruleNamespace | ruleType | ruleImport )
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
                    // PsiInternalSDomain.g:222:3: ruleNamespace
                    {

                    			markComposite(elementTypeProvider.getElement_NamespaceParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleNamespace();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSDomain.g:230:3: ruleType
                    {

                    			markComposite(elementTypeProvider.getElement_TypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleType();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalSDomain.g:238:3: ruleImport
                    {

                    			markComposite(elementTypeProvider.getElement_ImportParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
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
    // PsiInternalSDomain.g:249:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:249:14: ( ruleType EOF )
            // PsiInternalSDomain.g:250:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FOLLOW_1);
            ruleType();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:255:1: ruleType : ( ruleEntity | ruleDatatype ) ;
    public final void ruleType() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:255:9: ( ( ruleEntity | ruleDatatype ) )
            // PsiInternalSDomain.g:256:2: ( ruleEntity | ruleDatatype )
            {
            // PsiInternalSDomain.g:256:2: ( ruleEntity | ruleDatatype )
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
                    // PsiInternalSDomain.g:257:3: ruleEntity
                    {

                    			markComposite(elementTypeProvider.getType_EntityParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleEntity();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSDomain.g:265:3: ruleDatatype
                    {

                    			markComposite(elementTypeProvider.getType_DatatypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
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
    // PsiInternalSDomain.g:276:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:276:16: ( ruleEntity EOF )
            // PsiInternalSDomain.g:277:2: ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FOLLOW_1);
            ruleEntity();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:282:1: ruleEntity : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final void ruleEntity() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalSDomain.g:282:11: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // PsiInternalSDomain.g:283:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // PsiInternalSDomain.g:283:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // PsiInternalSDomain.g:284:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {

            			markLeaf(elementTypeProvider.getEntity_EntityKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSDomain.g:291:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSDomain.g:292:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSDomain.g:292:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSDomain.g:293:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEntity_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_9); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSDomain.g:309:3: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalSDomain.g:310:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // PsiInternalSDomain.g:310:4: (lv_properties_3_0= ruleProperty )
            	    // PsiInternalSDomain.g:311:5: lv_properties_3_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getEntity_PropertiesPropertyParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_9);
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


            			markLeaf(elementTypeProvider.getEntity_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

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
    // PsiInternalSDomain.g:331:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:331:18: ( ruleDatatype EOF )
            // PsiInternalSDomain.g:332:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FOLLOW_1);
            ruleDatatype();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:337:1: ruleDatatype : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSDomain.g:337:13: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSDomain.g:338:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSDomain.g:338:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSDomain.g:339:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSDomain.g:346:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSDomain.g:347:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSDomain.g:347:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSDomain.g:348:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDatatype_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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
    // PsiInternalSDomain.g:361:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // PsiInternalSDomain.g:361:18: ( ruleProperty EOF )
            // PsiInternalSDomain.g:362:2: ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleProperty();

            state._fsp--;

            match(input,EOF,FOLLOW_2); 

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
    // PsiInternalSDomain.g:367:1: ruleProperty : ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleProperty() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // PsiInternalSDomain.g:367:13: ( ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSDomain.g:368:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSDomain.g:368:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSDomain.g:369:3: ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalSDomain.g:369:3: ( ( ruleQualifiedName ) )
            // PsiInternalSDomain.g:370:4: ( ruleQualifiedName )
            {
            // PsiInternalSDomain.g:370:4: ( ruleQualifiedName )
            // PsiInternalSDomain.g:371:5: ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType());
            				
            pushFollow(FOLLOW_4);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalSDomain.g:380:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSDomain.g:381:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSDomain.g:381:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSDomain.g:382:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000030812L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000038810L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008010L});

}