package org.eclipse.xtext.testlanguages.fileAware.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.fileAware.services.FileAwareTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFileAwareTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'import'", "'element'", "'{'", "'ref'", "'}'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalFileAwareTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFileAwareTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFileAwareTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFileAwareTestLanguage.g"; }



     	private FileAwareTestLanguageGrammarAccess grammarAccess;

        public InternalFileAwareTestLanguageParser(TokenStream input, FileAwareTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "PackageDeclaration";
       	}

       	@Override
       	protected FileAwareTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePackageDeclaration"
    // InternalFileAwareTestLanguage.g:64:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // InternalFileAwareTestLanguage.g:64:59: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // InternalFileAwareTestLanguage.g:65:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;

             current =iv_rulePackageDeclaration; 
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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalFileAwareTestLanguage.g:71:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_contents_3_0= ruleElement ) )* ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_contents_3_0 = null;



        	enterRule();

        try {
            // InternalFileAwareTestLanguage.g:77:2: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_contents_3_0= ruleElement ) )* ) )
            // InternalFileAwareTestLanguage.g:78:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_contents_3_0= ruleElement ) )* )
            {
            // InternalFileAwareTestLanguage.g:78:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_contents_3_0= ruleElement ) )* )
            // InternalFileAwareTestLanguage.g:79:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_contents_3_0= ruleElement ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
            		
            // InternalFileAwareTestLanguage.g:83:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:84:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalFileAwareTestLanguage.g:84:4: (lv_name_1_0= ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:85:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.testlanguages.fileAware.FileAwareTestLanguage.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFileAwareTestLanguage.g:102:3: ( (lv_imports_2_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:103:4: (lv_imports_2_0= ruleImport )
            	    {
            	    // InternalFileAwareTestLanguage.g:103:4: (lv_imports_2_0= ruleImport )
            	    // InternalFileAwareTestLanguage.g:104:5: lv_imports_2_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getImportsImportParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_2_0,
            	    						"org.eclipse.xtext.testlanguages.fileAware.FileAwareTestLanguage.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalFileAwareTestLanguage.g:121:3: ( (lv_contents_3_0= ruleElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:122:4: (lv_contents_3_0= ruleElement )
            	    {
            	    // InternalFileAwareTestLanguage.g:122:4: (lv_contents_3_0= ruleElement )
            	    // InternalFileAwareTestLanguage.g:123:5: lv_contents_3_0= ruleElement
            	    {

            	    					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getContentsElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_contents_3_0=ruleElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contents",
            	    						lv_contents_3_0,
            	    						"org.eclipse.xtext.testlanguages.fileAware.FileAwareTestLanguage.Element");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleImport"
    // InternalFileAwareTestLanguage.g:144:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalFileAwareTestLanguage.g:144:47: (iv_ruleImport= ruleImport EOF )
            // InternalFileAwareTestLanguage.g:145:2: iv_ruleImport= ruleImport EOF
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
    // InternalFileAwareTestLanguage.g:151:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalFileAwareTestLanguage.g:157:2: ( (otherlv_0= 'import' ( ( ruleQualifiedName ) ) ) )
            // InternalFileAwareTestLanguage.g:158:2: (otherlv_0= 'import' ( ( ruleQualifiedName ) ) )
            {
            // InternalFileAwareTestLanguage.g:158:2: (otherlv_0= 'import' ( ( ruleQualifiedName ) ) )
            // InternalFileAwareTestLanguage.g:159:3: otherlv_0= 'import' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalFileAwareTestLanguage.g:163:3: ( ( ruleQualifiedName ) )
            // InternalFileAwareTestLanguage.g:164:4: ( ruleQualifiedName )
            {
            // InternalFileAwareTestLanguage.g:164:4: ( ruleQualifiedName )
            // InternalFileAwareTestLanguage.g:165:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportAccess().getElementElementCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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


    // $ANTLR start "entryRuleElement"
    // InternalFileAwareTestLanguage.g:183:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalFileAwareTestLanguage.g:183:48: (iv_ruleElement= ruleElement EOF )
            // InternalFileAwareTestLanguage.g:184:2: iv_ruleElement= ruleElement EOF
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
    // InternalFileAwareTestLanguage.g:190:1: ruleElement returns [EObject current=null] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_contents_3_0= ruleElement ) ) | (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_contents_3_0 = null;



        	enterRule();

        try {
            // InternalFileAwareTestLanguage.g:196:2: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_contents_3_0= ruleElement ) ) | (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) ) )* otherlv_6= '}' ) )
            // InternalFileAwareTestLanguage.g:197:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_contents_3_0= ruleElement ) ) | (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) ) )* otherlv_6= '}' )
            {
            // InternalFileAwareTestLanguage.g:197:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_contents_3_0= ruleElement ) ) | (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) ) )* otherlv_6= '}' )
            // InternalFileAwareTestLanguage.g:198:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_contents_3_0= ruleElement ) ) | (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getElementAccess().getElementKeyword_0());
            		
            // InternalFileAwareTestLanguage.g:202:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFileAwareTestLanguage.g:203:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFileAwareTestLanguage.g:203:4: (lv_name_1_0= RULE_ID )
            // InternalFileAwareTestLanguage.g:204:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getElementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalFileAwareTestLanguage.g:224:3: ( ( (lv_contents_3_0= ruleElement ) ) | (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }
                else if ( (LA3_0==15) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:225:4: ( (lv_contents_3_0= ruleElement ) )
            	    {
            	    // InternalFileAwareTestLanguage.g:225:4: ( (lv_contents_3_0= ruleElement ) )
            	    // InternalFileAwareTestLanguage.g:226:5: (lv_contents_3_0= ruleElement )
            	    {
            	    // InternalFileAwareTestLanguage.g:226:5: (lv_contents_3_0= ruleElement )
            	    // InternalFileAwareTestLanguage.g:227:6: lv_contents_3_0= ruleElement
            	    {

            	    						newCompositeNode(grammarAccess.getElementAccess().getContentsElementParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_contents_3_0=ruleElement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getElementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"contents",
            	    							lv_contents_3_0,
            	    							"org.eclipse.xtext.testlanguages.fileAware.FileAwareTestLanguage.Element");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalFileAwareTestLanguage.g:245:4: (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) )
            	    {
            	    // InternalFileAwareTestLanguage.g:245:4: (otherlv_4= 'ref' ( ( ruleQualifiedName ) ) )
            	    // InternalFileAwareTestLanguage.g:246:5: otherlv_4= 'ref' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_4=(Token)match(input,15,FOLLOW_3); 

            	    					newLeafNode(otherlv_4, grammarAccess.getElementAccess().getRefKeyword_3_1_0());
            	    				
            	    // InternalFileAwareTestLanguage.g:250:5: ( ( ruleQualifiedName ) )
            	    // InternalFileAwareTestLanguage.g:251:6: ( ruleQualifiedName )
            	    {
            	    // InternalFileAwareTestLanguage.g:251:6: ( ruleQualifiedName )
            	    // InternalFileAwareTestLanguage.g:252:7: ruleQualifiedName
            	    {

            	    							if (current==null) {
            	    								current = createModelElement(grammarAccess.getElementRule());
            	    							}
            	    						

            	    							newCompositeNode(grammarAccess.getElementAccess().getRefElementCrossReference_3_1_1_0());
            	    						
            	    pushFollow(FOLLOW_7);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_6=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4());
            		

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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalFileAwareTestLanguage.g:276:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalFileAwareTestLanguage.g:276:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalFileAwareTestLanguage.g:277:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalFileAwareTestLanguage.g:283:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalFileAwareTestLanguage.g:289:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalFileAwareTestLanguage.g:290:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalFileAwareTestLanguage.g:290:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalFileAwareTestLanguage.g:291:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalFileAwareTestLanguage.g:298:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFileAwareTestLanguage.g:299:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,17,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001A000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020002L});

}