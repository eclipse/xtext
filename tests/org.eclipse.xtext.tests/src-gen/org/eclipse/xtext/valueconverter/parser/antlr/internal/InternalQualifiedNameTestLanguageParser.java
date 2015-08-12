package org.eclipse.xtext.valueconverter.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.valueconverter.services.QualifiedNameTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQualifiedNameTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'keyword'", "'.'", "'*'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalQualifiedNameTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQualifiedNameTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQualifiedNameTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g"; }



     	private QualifiedNameTestLanguageGrammarAccess grammarAccess;
     	
        public InternalQualifiedNameTestLanguageParser(TokenStream input, QualifiedNameTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Element";	
       	}
       	
       	@Override
       	protected QualifiedNameTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:67:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:68:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:69:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement75);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:76:1: ruleElement returns [EObject current=null] : (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_qualifiedName_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:79:28: ( (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:80:1: (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:80:1: (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:80:3: otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement122); 

                	newLeafNode(otherlv_0, grammarAccess.getElementAccess().getKeywordKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:84:1: ( (lv_qualifiedName_1_0= ruleQualifiedName ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:85:1: (lv_qualifiedName_1_0= ruleQualifiedName )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:85:1: (lv_qualifiedName_1_0= ruleQualifiedName )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:86:3: lv_qualifiedName_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getElementAccess().getQualifiedNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement143);
            lv_qualifiedName_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getElementRule());
            	        }
                   		set(
                   			current, 
                   			"qualifiedName",
                    		lv_qualifiedName_1_0, 
                    		"org.eclipse.xtext.valueconverter.QualifiedNameTestLanguage.QualifiedName");
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:110:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:111:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:112:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName180);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName191); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:119:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:122:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:123:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:123:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:123:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName231); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:130:1: (kw= '.' this_ID_2= RULE_ID )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==RULE_ID) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:131:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleQualifiedName250); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName265); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:143:3: (kw= '.' kw= '*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalQualifiedNameTestLanguage.g:144:2: kw= '.' kw= '*'
                    {
                    kw=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleQualifiedName286); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_2_0()); 
                        
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleQualifiedName299); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getAsteriskKeyword_2_1()); 
                        

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName231 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleQualifiedName250 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName265 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleQualifiedName286 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleQualifiedName299 = new BitSet(new long[]{0x0000000000000002L});
    }


}