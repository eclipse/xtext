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
    // PsiInternalSDomain.g:52:1: entryRuleFile returns [Boolean current=false] : iv_ruleFile= ruleFile EOF ;
    public final Boolean entryRuleFile() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFile = null;


        try {
            // PsiInternalSDomain.g:52:46: (iv_ruleFile= ruleFile EOF )
            // PsiInternalSDomain.g:53:2: iv_ruleFile= ruleFile EOF
            {
             markComposite(elementTypeProvider.getFileElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // PsiInternalSDomain.g:59:1: ruleFile returns [Boolean current=false] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final Boolean ruleFile() throws RecognitionException {
        Boolean current = false;

        Boolean lv_elements_0_0 = null;


        try {
            // PsiInternalSDomain.g:60:1: ( ( (lv_elements_0_0= ruleElement ) )* )
            // PsiInternalSDomain.g:61:2: ( (lv_elements_0_0= ruleElement ) )*
            {
            // PsiInternalSDomain.g:61:2: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalSDomain.g:62:3: (lv_elements_0_0= ruleElement )
            	    {
            	    // PsiInternalSDomain.g:62:3: (lv_elements_0_0= ruleElement )
            	    // PsiInternalSDomain.g:63:4: lv_elements_0_0= ruleElement
            	    {

            	    				markComposite(elementTypeProvider.getFile_ElementsElementParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    				doneComposite();
            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

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
        return current;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleImport"
    // PsiInternalSDomain.g:79:1: entryRuleImport returns [Boolean current=false] : iv_ruleImport= ruleImport EOF ;
    public final Boolean entryRuleImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleImport = null;


        try {
            // PsiInternalSDomain.g:79:48: (iv_ruleImport= ruleImport EOF )
            // PsiInternalSDomain.g:80:2: iv_ruleImport= ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // PsiInternalSDomain.g:86:1: ruleImport returns [Boolean current=false] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final Boolean ruleImport() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_importedNamespace_1_0 = null;


        try {
            // PsiInternalSDomain.g:87:1: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // PsiInternalSDomain.g:88:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // PsiInternalSDomain.g:88:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // PsiInternalSDomain.g:89:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {

            			markLeaf(elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSDomain.g:96:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // PsiInternalSDomain.g:97:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // PsiInternalSDomain.g:97:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // PsiInternalSDomain.g:98:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {

            					markComposite(elementTypeProvider.getImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // PsiInternalSDomain.g:115:1: entryRuleQualifiedNameWithWildCard returns [Boolean current=false] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final Boolean entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedNameWithWildCard = null;


        try {
            // PsiInternalSDomain.g:115:67: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // PsiInternalSDomain.g:116:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameWithWildCardElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildCard; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // PsiInternalSDomain.g:122:1: ruleQualifiedNameWithWildCard returns [Boolean current=false] : ( ruleQualifiedName (kw= '.*' )? ) ;
    public final Boolean ruleQualifiedNameWithWildCard() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalSDomain.g:123:1: ( ( ruleQualifiedName (kw= '.*' )? ) )
            // PsiInternalSDomain.g:124:2: ( ruleQualifiedName (kw= '.*' )? )
            {
            // PsiInternalSDomain.g:124:2: ( ruleQualifiedName (kw= '.*' )? )
            // PsiInternalSDomain.g:125:3: ruleQualifiedName (kw= '.*' )?
            {

            			markComposite(elementTypeProvider.getQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType());
            		
            pushFollow(FOLLOW_5);
            ruleQualifiedName();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalSDomain.g:132:3: (kw= '.*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalSDomain.g:133:4: kw= '.*'
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
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // PsiInternalSDomain.g:145:1: entryRuleQualifiedName returns [Boolean current=false] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final Boolean entryRuleQualifiedName() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQualifiedName = null;


        try {
            // PsiInternalSDomain.g:145:55: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // PsiInternalSDomain.g:146:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // PsiInternalSDomain.g:152:1: ruleQualifiedName returns [Boolean current=false] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final Boolean ruleQualifiedName() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalSDomain.g:153:1: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // PsiInternalSDomain.g:154:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // PsiInternalSDomain.g:154:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // PsiInternalSDomain.g:155:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {

            			markLeaf(elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalSDomain.g:162:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalSDomain.g:163:4: kw= '.' this_ID_2= RULE_ID
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
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNamespace"
    // PsiInternalSDomain.g:182:1: entryRuleNamespace returns [Boolean current=false] : iv_ruleNamespace= ruleNamespace EOF ;
    public final Boolean entryRuleNamespace() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNamespace = null;


        try {
            // PsiInternalSDomain.g:182:51: (iv_ruleNamespace= ruleNamespace EOF )
            // PsiInternalSDomain.g:183:2: iv_ruleNamespace= ruleNamespace EOF
            {
             markComposite(elementTypeProvider.getNamespaceElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // PsiInternalSDomain.g:189:1: ruleNamespace returns [Boolean current=false] : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) ;
    public final Boolean ruleNamespace() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_name_0_0 = null;

        Boolean lv_elements_2_0 = null;


        try {
            // PsiInternalSDomain.g:190:1: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) )
            // PsiInternalSDomain.g:191:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            {
            // PsiInternalSDomain.g:191:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            // PsiInternalSDomain.g:192:3: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}'
            {
            // PsiInternalSDomain.g:192:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // PsiInternalSDomain.g:193:4: (lv_name_0_0= ruleQualifiedName )
            {
            // PsiInternalSDomain.g:193:4: (lv_name_0_0= ruleQualifiedName )
            // PsiInternalSDomain.g:194:5: lv_name_0_0= ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_7);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getNamespace_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalSDomain.g:214:3: ( (lv_elements_2_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==11||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalSDomain.g:215:4: (lv_elements_2_0= ruleElement )
            	    {
            	    // PsiInternalSDomain.g:215:4: (lv_elements_2_0= ruleElement )
            	    // PsiInternalSDomain.g:216:5: lv_elements_2_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getNamespace_ElementsElementParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_elements_2_0=ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleElement"
    // PsiInternalSDomain.g:240:1: entryRuleElement returns [Boolean current=false] : iv_ruleElement= ruleElement EOF ;
    public final Boolean entryRuleElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElement = null;


        try {
            // PsiInternalSDomain.g:240:49: (iv_ruleElement= ruleElement EOF )
            // PsiInternalSDomain.g:241:2: iv_ruleElement= ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalSDomain.g:247:1: ruleElement returns [Boolean current=false] : (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport ) ;
    public final Boolean ruleElement() throws RecognitionException {
        Boolean current = false;

        Boolean this_Namespace_0 = null;

        Boolean this_Type_1 = null;

        Boolean this_Import_2 = null;


        try {
            // PsiInternalSDomain.g:248:1: ( (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport ) )
            // PsiInternalSDomain.g:249:2: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport )
            {
            // PsiInternalSDomain.g:249:2: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport )
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
                    // PsiInternalSDomain.g:250:3: this_Namespace_0= ruleNamespace
                    {

                    			markComposite(elementTypeProvider.getElement_NamespaceParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Namespace_0=ruleNamespace();

                    state._fsp--;


                    			current = this_Namespace_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSDomain.g:259:3: this_Type_1= ruleType
                    {

                    			markComposite(elementTypeProvider.getElement_TypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Type_1=ruleType();

                    state._fsp--;


                    			current = this_Type_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalSDomain.g:268:3: this_Import_2= ruleImport
                    {

                    			markComposite(elementTypeProvider.getElement_ImportParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Import_2=ruleImport();

                    state._fsp--;


                    			current = this_Import_2;
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
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleType"
    // PsiInternalSDomain.g:280:1: entryRuleType returns [Boolean current=false] : iv_ruleType= ruleType EOF ;
    public final Boolean entryRuleType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleType = null;


        try {
            // PsiInternalSDomain.g:280:46: (iv_ruleType= ruleType EOF )
            // PsiInternalSDomain.g:281:2: iv_ruleType= ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalSDomain.g:287:1: ruleType returns [Boolean current=false] : (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) ;
    public final Boolean ruleType() throws RecognitionException {
        Boolean current = false;

        Boolean this_Entity_0 = null;

        Boolean this_Datatype_1 = null;


        try {
            // PsiInternalSDomain.g:288:1: ( (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) )
            // PsiInternalSDomain.g:289:2: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
            {
            // PsiInternalSDomain.g:289:2: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
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
                    // PsiInternalSDomain.g:290:3: this_Entity_0= ruleEntity
                    {

                    			markComposite(elementTypeProvider.getType_EntityParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSDomain.g:299:3: this_Datatype_1= ruleDatatype
                    {

                    			markComposite(elementTypeProvider.getType_DatatypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Datatype_1=ruleDatatype();

                    state._fsp--;


                    			current = this_Datatype_1;
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
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleEntity"
    // PsiInternalSDomain.g:311:1: entryRuleEntity returns [Boolean current=false] : iv_ruleEntity= ruleEntity EOF ;
    public final Boolean entryRuleEntity() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntity = null;


        try {
            // PsiInternalSDomain.g:311:48: (iv_ruleEntity= ruleEntity EOF )
            // PsiInternalSDomain.g:312:2: iv_ruleEntity= ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // PsiInternalSDomain.g:318:1: ruleEntity returns [Boolean current=false] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final Boolean ruleEntity() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_properties_3_0 = null;


        try {
            // PsiInternalSDomain.g:319:1: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // PsiInternalSDomain.g:320:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // PsiInternalSDomain.g:320:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // PsiInternalSDomain.g:321:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {

            			markLeaf(elementTypeProvider.getEntity_EntityKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSDomain.g:328:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSDomain.g:329:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSDomain.g:329:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSDomain.g:330:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEntity_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_9); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSDomain.g:352:3: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalSDomain.g:353:4: (lv_properties_3_0= ruleProperty )
            	    {
            	    // PsiInternalSDomain.g:353:4: (lv_properties_3_0= ruleProperty )
            	    // PsiInternalSDomain.g:354:5: lv_properties_3_0= ruleProperty
            	    {

            	    					markComposite(elementTypeProvider.getEntity_PropertiesPropertyParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_properties_3_0=ruleProperty();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleDatatype"
    // PsiInternalSDomain.g:378:1: entryRuleDatatype returns [Boolean current=false] : iv_ruleDatatype= ruleDatatype EOF ;
    public final Boolean entryRuleDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype = null;


        try {
            // PsiInternalSDomain.g:378:50: (iv_ruleDatatype= ruleDatatype EOF )
            // PsiInternalSDomain.g:379:2: iv_ruleDatatype= ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // PsiInternalSDomain.g:385:1: ruleDatatype returns [Boolean current=false] : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleDatatype() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSDomain.g:386:1: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSDomain.g:387:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSDomain.g:387:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSDomain.g:388:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getDatatype_DatatypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSDomain.g:395:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSDomain.g:396:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSDomain.g:396:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSDomain.g:397:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDatatype_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleProperty"
    // PsiInternalSDomain.g:416:1: entryRuleProperty returns [Boolean current=false] : iv_ruleProperty= ruleProperty EOF ;
    public final Boolean entryRuleProperty() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleProperty = null;


        try {
            // PsiInternalSDomain.g:416:50: (iv_ruleProperty= ruleProperty EOF )
            // PsiInternalSDomain.g:417:2: iv_ruleProperty= ruleProperty EOF
            {
             markComposite(elementTypeProvider.getPropertyElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // PsiInternalSDomain.g:423:1: ruleProperty returns [Boolean current=false] : ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleProperty() throws RecognitionException {
        Boolean current = false;

        Token lv_name_1_0=null;

        try {
            // PsiInternalSDomain.g:424:1: ( ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSDomain.g:425:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSDomain.g:425:2: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSDomain.g:426:3: ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalSDomain.g:426:3: ( ( ruleQualifiedName ) )
            // PsiInternalSDomain.g:427:4: ( ruleQualifiedName )
            {
            // PsiInternalSDomain.g:427:4: ( ruleQualifiedName )
            // PsiInternalSDomain.g:428:5: ruleQualifiedName
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markComposite(elementTypeProvider.getProperty_TypeTypeCrossReference_0_0ElementType());
            				
            pushFollow(FOLLOW_4);
            ruleQualifiedName();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalSDomain.g:443:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSDomain.g:444:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSDomain.g:444:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSDomain.g:445:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getProperty_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
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