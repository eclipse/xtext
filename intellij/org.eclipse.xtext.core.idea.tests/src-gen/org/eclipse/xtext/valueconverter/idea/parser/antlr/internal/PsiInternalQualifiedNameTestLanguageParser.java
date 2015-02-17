package org.eclipse.xtext.valueconverter.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.valueconverter.services.QualifiedNameTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalQualifiedNameTestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalQualifiedNameTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalQualifiedNameTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalQualifiedNameTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g"; }



    private QualifiedNameTestLanguageGrammarAccess grammarAccess;

    private QualifiedNameTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalQualifiedNameTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, QualifiedNameTestLanguageElementTypeProvider elementTypeProvider, QualifiedNameTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Element";
    }




    // $ANTLR start "entryRuleElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:49:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:49:17: ( ruleElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:50:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement54);
            ruleElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:58:1: ruleElement : (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) ) ;
    public final void ruleElement() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:58:12: ( (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:59:2: (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:59:2: (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:60:3: otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement83); 

            			doneLeaf(otherlv_0, elementTypeProvider.getElement_KeywordKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:67:3: ( (lv_qualifiedName_1_0= ruleQualifiedName ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:68:4: (lv_qualifiedName_1_0= ruleQualifiedName )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:68:4: (lv_qualifiedName_1_0= ruleQualifiedName )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:69:5: lv_qualifiedName_1_0= ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getElement_QualifiedNameQualifiedNameParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleElement110);
            ruleQualifiedName();

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleQualifiedName"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:82:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:82:23: ( ruleQualifiedName EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:83:2: ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName141);
            ruleQualifiedName();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName147); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:91:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:91:18: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:92:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:92:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:93:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )?
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName170); 

            			doneLeaf(this_ID_0, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:100:3: (kw= '.' this_ID_2= RULE_ID )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:101:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf();
            	    			
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleQualifiedName190); 

            	    				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			

            	    				markLeaf();
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName207); 

            	    				doneLeaf(this_ID_2, elementTypeProvider.getQualifiedName_IDTerminalRuleCall_1_1ElementType());
            	    			

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:116:3: (kw= '.' kw= '*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalQualifiedNameTestLanguage.g:117:4: kw= '.' kw= '*'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleQualifiedName233); 

                    				doneLeaf(kw, elementTypeProvider.getQualifiedName_FullStopKeyword_2_0ElementType());
                    			

                    				markLeaf();
                    			
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleQualifiedName250); 

                    				doneLeaf(kw, elementTypeProvider.getQualifiedName_AsteriskKeyword_2_1ElementType());
                    			

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement83 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleElement110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName170 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleQualifiedName190 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName207 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleQualifiedName233 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleQualifiedName250 = new BitSet(new long[]{0x0000000000000002L});
    }


}