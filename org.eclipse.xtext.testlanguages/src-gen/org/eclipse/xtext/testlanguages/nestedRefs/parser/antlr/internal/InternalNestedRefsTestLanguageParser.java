package org.eclipse.xtext.testlanguages.nestedRefs.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.nestedRefs.services.NestedRefsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNestedRefsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'decl'", "'end'", "';'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalNestedRefsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNestedRefsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNestedRefsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalNestedRefsTestLanguage.g"; }



     	private NestedRefsTestLanguageGrammarAccess grammarAccess;

        public InternalNestedRefsTestLanguageParser(TokenStream input, NestedRefsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Doc";
       	}

       	@Override
       	protected NestedRefsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDoc"
    // InternalNestedRefsTestLanguage.g:64:1: entryRuleDoc returns [EObject current=null] : iv_ruleDoc= ruleDoc EOF ;
    public final EObject entryRuleDoc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoc = null;


        try {
            // InternalNestedRefsTestLanguage.g:64:44: (iv_ruleDoc= ruleDoc EOF )
            // InternalNestedRefsTestLanguage.g:65:2: iv_ruleDoc= ruleDoc EOF
            {
             newCompositeNode(grammarAccess.getDocRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoc=ruleDoc();

            state._fsp--;

             current =iv_ruleDoc; 
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
    // $ANTLR end "entryRuleDoc"


    // $ANTLR start "ruleDoc"
    // InternalNestedRefsTestLanguage.g:71:1: ruleDoc returns [EObject current=null] : ( (lv_declarations_0_0= ruleSelfReferingDecl ) )* ;
    public final EObject ruleDoc() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_0_0 = null;



        	enterRule();

        try {
            // InternalNestedRefsTestLanguage.g:77:2: ( ( (lv_declarations_0_0= ruleSelfReferingDecl ) )* )
            // InternalNestedRefsTestLanguage.g:78:2: ( (lv_declarations_0_0= ruleSelfReferingDecl ) )*
            {
            // InternalNestedRefsTestLanguage.g:78:2: ( (lv_declarations_0_0= ruleSelfReferingDecl ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalNestedRefsTestLanguage.g:79:3: (lv_declarations_0_0= ruleSelfReferingDecl )
            	    {
            	    // InternalNestedRefsTestLanguage.g:79:3: (lv_declarations_0_0= ruleSelfReferingDecl )
            	    // InternalNestedRefsTestLanguage.g:80:4: lv_declarations_0_0= ruleSelfReferingDecl
            	    {

            	    				newCompositeNode(grammarAccess.getDocAccess().getDeclarationsSelfReferingDeclParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_declarations_0_0=ruleSelfReferingDecl();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getDocRule());
            	    				}
            	    				add(
            	    					current,
            	    					"declarations",
            	    					lv_declarations_0_0,
            	    					"org.eclipse.xtext.testlanguages.nestedRefs.NestedRefsTestLanguage.SelfReferingDecl");
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
    // $ANTLR end "ruleDoc"


    // $ANTLR start "entryRuleSelfReferingDecl"
    // InternalNestedRefsTestLanguage.g:100:1: entryRuleSelfReferingDecl returns [EObject current=null] : iv_ruleSelfReferingDecl= ruleSelfReferingDecl EOF ;
    public final EObject entryRuleSelfReferingDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfReferingDecl = null;


        try {
            // InternalNestedRefsTestLanguage.g:100:57: (iv_ruleSelfReferingDecl= ruleSelfReferingDecl EOF )
            // InternalNestedRefsTestLanguage.g:101:2: iv_ruleSelfReferingDecl= ruleSelfReferingDecl EOF
            {
             newCompositeNode(grammarAccess.getSelfReferingDeclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelfReferingDecl=ruleSelfReferingDecl();

            state._fsp--;

             current =iv_ruleSelfReferingDecl; 
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
    // $ANTLR end "entryRuleSelfReferingDecl"


    // $ANTLR start "ruleSelfReferingDecl"
    // InternalNestedRefsTestLanguage.g:107:1: ruleSelfReferingDecl returns [EObject current=null] : (otherlv_0= 'decl' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'end' ( ( ruleQualifiedName ) ) otherlv_4= ';' ) ;
    public final EObject ruleSelfReferingDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalNestedRefsTestLanguage.g:113:2: ( (otherlv_0= 'decl' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'end' ( ( ruleQualifiedName ) ) otherlv_4= ';' ) )
            // InternalNestedRefsTestLanguage.g:114:2: (otherlv_0= 'decl' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'end' ( ( ruleQualifiedName ) ) otherlv_4= ';' )
            {
            // InternalNestedRefsTestLanguage.g:114:2: (otherlv_0= 'decl' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'end' ( ( ruleQualifiedName ) ) otherlv_4= ';' )
            // InternalNestedRefsTestLanguage.g:115:3: otherlv_0= 'decl' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'end' ( ( ruleQualifiedName ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSelfReferingDeclAccess().getDeclKeyword_0());
            		
            // InternalNestedRefsTestLanguage.g:119:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalNestedRefsTestLanguage.g:120:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalNestedRefsTestLanguage.g:120:4: (lv_name_1_0= ruleQualifiedName )
            // InternalNestedRefsTestLanguage.g:121:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getSelfReferingDeclAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelfReferingDeclRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.testlanguages.nestedRefs.NestedRefsTestLanguage.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getSelfReferingDeclAccess().getEndKeyword_2());
            		
            // InternalNestedRefsTestLanguage.g:142:3: ( ( ruleQualifiedName ) )
            // InternalNestedRefsTestLanguage.g:143:4: ( ruleQualifiedName )
            {
            // InternalNestedRefsTestLanguage.g:143:4: ( ruleQualifiedName )
            // InternalNestedRefsTestLanguage.g:144:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSelfReferingDeclRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSelfReferingDeclAccess().getSelfRefSelfReferingDeclCrossReference_3_0());
            				
            pushFollow(FOLLOW_6);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSelfReferingDeclAccess().getSemicolonKeyword_4());
            		

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
    // $ANTLR end "ruleSelfReferingDecl"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalNestedRefsTestLanguage.g:166:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalNestedRefsTestLanguage.g:166:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalNestedRefsTestLanguage.g:167:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalNestedRefsTestLanguage.g:173:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalNestedRefsTestLanguage.g:179:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalNestedRefsTestLanguage.g:180:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalNestedRefsTestLanguage.g:180:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalNestedRefsTestLanguage.g:181:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalNestedRefsTestLanguage.g:188:3: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalNestedRefsTestLanguage.g:189:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,14,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});

}