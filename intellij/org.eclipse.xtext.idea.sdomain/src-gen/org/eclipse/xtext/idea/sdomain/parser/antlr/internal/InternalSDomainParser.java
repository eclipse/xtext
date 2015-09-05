package org.eclipse.xtext.idea.sdomain.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.idea.sdomain.services.SDomainGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSDomainParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "InternalSDomain.g"; }



     	private SDomainGrammarAccess grammarAccess;
     	
        public InternalSDomainParser(TokenStream input, SDomainGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	
       	@Override
       	protected SDomainGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFile"
    // InternalSDomain.g:67:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // InternalSDomain.g:68:2: (iv_ruleFile= ruleFile EOF )
            // InternalSDomain.g:69:2: iv_ruleFile= ruleFile EOF
            {
             newCompositeNode(grammarAccess.getFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalSDomain.g:76:1: ruleFile returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // InternalSDomain.g:79:28: ( ( (lv_elements_0_0= ruleElement ) )* )
            // InternalSDomain.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // InternalSDomain.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSDomain.g:81:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // InternalSDomain.g:81:1: (lv_elements_0_0= ruleElement )
            	    // InternalSDomain.g:82:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFileAccess().getElementsElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"org.eclipse.xtext.idea.sdomain.SDomain.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleImport"
    // InternalSDomain.g:106:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSDomain.g:107:2: (iv_ruleImport= ruleImport EOF )
            // InternalSDomain.g:108:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalSDomain.g:115:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSDomain.g:118:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // InternalSDomain.g:119:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // InternalSDomain.g:119:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // InternalSDomain.g:119:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalSDomain.g:123:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // InternalSDomain.g:124:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // InternalSDomain.g:124:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // InternalSDomain.g:125:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"org.eclipse.xtext.idea.sdomain.SDomain.QualifiedNameWithWildCard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // InternalSDomain.g:149:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // InternalSDomain.g:150:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // InternalSDomain.g:151:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildCard.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // InternalSDomain.g:158:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalSDomain.g:161:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalSDomain.g:162:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalSDomain.g:162:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalSDomain.g:163:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_5);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalSDomain.g:173:1: (kw= '.*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalSDomain.g:174:2: kw= '.*'
                    {
                    kw=(Token)match(input,12,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalSDomain.g:187:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSDomain.g:188:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSDomain.g:189:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalSDomain.g:196:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalSDomain.g:199:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSDomain.g:200:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSDomain.g:200:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSDomain.g:200:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalSDomain.g:207:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSDomain.g:208:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,13,FOLLOW_4); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNamespace"
    // InternalSDomain.g:228:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalSDomain.g:229:2: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalSDomain.g:230:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalSDomain.g:237:1: ruleNamespace returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSDomain.g:240:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' ) )
            // InternalSDomain.g:241:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            {
            // InternalSDomain.g:241:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}' )
            // InternalSDomain.g:241:2: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= '{' ( (lv_elements_2_0= ruleElement ) )* otherlv_3= '}'
            {
            // InternalSDomain.g:241:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalSDomain.g:242:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalSDomain.g:242:1: (lv_name_0_0= ruleQualifiedName )
            // InternalSDomain.g:243:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamespaceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.idea.sdomain.SDomain.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_8); 

                	newLeafNode(otherlv_1, grammarAccess.getNamespaceAccess().getLeftCurlyBracketKeyword_1());
                
            // InternalSDomain.g:263:1: ( (lv_elements_2_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==11||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSDomain.g:264:1: (lv_elements_2_0= ruleElement )
            	    {
            	    // InternalSDomain.g:264:1: (lv_elements_2_0= ruleElement )
            	    // InternalSDomain.g:265:3: lv_elements_2_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNamespaceAccess().getElementsElementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
            	    lv_elements_2_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNamespaceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_2_0, 
            	            		"org.eclipse.xtext.idea.sdomain.SDomain.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getNamespaceAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleElement"
    // InternalSDomain.g:293:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalSDomain.g:294:2: (iv_ruleElement= ruleElement EOF )
            // InternalSDomain.g:295:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalSDomain.g:302:1: ruleElement returns [EObject current=null] : (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Namespace_0 = null;

        EObject this_Type_1 = null;

        EObject this_Import_2 = null;


         enterRule(); 
            
        try {
            // InternalSDomain.g:305:28: ( (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport ) )
            // InternalSDomain.g:306:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport )
            {
            // InternalSDomain.g:306:1: (this_Namespace_0= ruleNamespace | this_Type_1= ruleType | this_Import_2= ruleImport )
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
                    // InternalSDomain.g:307:5: this_Namespace_0= ruleNamespace
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getNamespaceParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Namespace_0=ruleNamespace();

                    state._fsp--;

                     
                            current = this_Namespace_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalSDomain.g:317:5: this_Type_1= ruleType
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Type_1=ruleType();

                    state._fsp--;

                     
                            current = this_Type_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalSDomain.g:327:5: this_Import_2= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getImportParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Import_2=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleType"
    // InternalSDomain.g:343:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalSDomain.g:344:2: (iv_ruleType= ruleType EOF )
            // InternalSDomain.g:345:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalSDomain.g:352:1: ruleType returns [EObject current=null] : (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_Entity_0 = null;

        EObject this_Datatype_1 = null;


         enterRule(); 
            
        try {
            // InternalSDomain.g:355:28: ( (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype ) )
            // InternalSDomain.g:356:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
            {
            // InternalSDomain.g:356:1: (this_Entity_0= ruleEntity | this_Datatype_1= ruleDatatype )
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
                    // InternalSDomain.g:357:5: this_Entity_0= ruleEntity
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;

                     
                            current = this_Entity_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalSDomain.g:367:5: this_Datatype_1= ruleDatatype
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getDatatypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Datatype_1=ruleDatatype();

                    state._fsp--;

                     
                            current = this_Datatype_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleEntity"
    // InternalSDomain.g:383:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalSDomain.g:384:2: (iv_ruleEntity= ruleEntity EOF )
            // InternalSDomain.g:385:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalSDomain.g:392:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_properties_3_0 = null;


         enterRule(); 
            
        try {
            // InternalSDomain.g:395:28: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' ) )
            // InternalSDomain.g:396:1: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            {
            // InternalSDomain.g:396:1: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}' )
            // InternalSDomain.g:396:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_properties_3_0= ruleProperty ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
                
            // InternalSDomain.g:400:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSDomain.g:401:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSDomain.g:401:1: (lv_name_1_0= RULE_ID )
            // InternalSDomain.g:402:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEntityRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_9); 

                	newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalSDomain.g:422:1: ( (lv_properties_3_0= ruleProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSDomain.g:423:1: (lv_properties_3_0= ruleProperty )
            	    {
            	    // InternalSDomain.g:423:1: (lv_properties_3_0= ruleProperty )
            	    // InternalSDomain.g:424:3: lv_properties_3_0= ruleProperty
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_9);
            	    lv_properties_3_0=ruleProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEntityRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"properties",
            	            		lv_properties_3_0, 
            	            		"org.eclipse.xtext.idea.sdomain.SDomain.Property");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleDatatype"
    // InternalSDomain.g:452:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // InternalSDomain.g:453:2: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalSDomain.g:454:2: iv_ruleDatatype= ruleDatatype EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // InternalSDomain.g:461:1: ruleDatatype returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalSDomain.g:464:28: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSDomain.g:465:1: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSDomain.g:465:1: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSDomain.g:465:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getDatatypeAccess().getDatatypeKeyword_0());
                
            // InternalSDomain.g:469:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSDomain.g:470:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSDomain.g:470:1: (lv_name_1_0= RULE_ID )
            // InternalSDomain.g:471:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDatatypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDatatypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleProperty"
    // InternalSDomain.g:495:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalSDomain.g:496:2: (iv_ruleProperty= ruleProperty EOF )
            // InternalSDomain.g:497:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalSDomain.g:504:1: ruleProperty returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalSDomain.g:507:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSDomain.g:508:1: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSDomain.g:508:1: ( ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSDomain.g:508:2: ( ( ruleQualifiedName ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSDomain.g:508:2: ( ( ruleQualifiedName ) )
            // InternalSDomain.g:509:1: ( ruleQualifiedName )
            {
            // InternalSDomain.g:509:1: ( ruleQualifiedName )
            // InternalSDomain.g:510:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalSDomain.g:523:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalSDomain.g:524:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSDomain.g:524:1: (lv_name_1_0= RULE_ID )
            // InternalSDomain.g:525:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
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