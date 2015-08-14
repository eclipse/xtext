package org.eclipse.xtext.valueconverter.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalQualifiedNameTestLanguage.g"; }



    	protected QualifiedNameTestLanguageGrammarAccess grammarAccess;

    	protected QualifiedNameTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalQualifiedNameTestLanguageParser(PsiBuilder builder, TokenStream input, QualifiedNameTestLanguageElementTypeProvider elementTypeProvider, QualifiedNameTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Element";
    	}




    // $ANTLR start "entryRuleElement"
    // PsiInternalQualifiedNameTestLanguage.g:52:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalQualifiedNameTestLanguage.g:52:17: ( ruleElement EOF )
            // PsiInternalQualifiedNameTestLanguage.g:53:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalQualifiedNameTestLanguage.g:58:1: ruleElement : (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) ) ;
    public final void ruleElement() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalQualifiedNameTestLanguage.g:58:12: ( (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) ) )
            // PsiInternalQualifiedNameTestLanguage.g:59:2: (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) )
            {
            // PsiInternalQualifiedNameTestLanguage.g:59:2: (otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) ) )
            // PsiInternalQualifiedNameTestLanguage.g:60:3: otherlv_0= 'keyword' ( (lv_qualifiedName_1_0= ruleQualifiedName ) )
            {

            			markLeaf(elementTypeProvider.getElement_KeywordKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalQualifiedNameTestLanguage.g:67:3: ( (lv_qualifiedName_1_0= ruleQualifiedName ) )
            // PsiInternalQualifiedNameTestLanguage.g:68:4: (lv_qualifiedName_1_0= ruleQualifiedName )
            {
            // PsiInternalQualifiedNameTestLanguage.g:68:4: (lv_qualifiedName_1_0= ruleQualifiedName )
            // PsiInternalQualifiedNameTestLanguage.g:69:5: lv_qualifiedName_1_0= ruleQualifiedName
            {

            					markComposite(elementTypeProvider.getElement_QualifiedNameQualifiedNameParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalQualifiedNameTestLanguage.g:82:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // PsiInternalQualifiedNameTestLanguage.g:82:23: ( ruleQualifiedName EOF )
            // PsiInternalQualifiedNameTestLanguage.g:83:2: ruleQualifiedName EOF
            {
             markComposite(elementTypeProvider.getQualifiedNameElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalQualifiedNameTestLanguage.g:88:1: ruleQualifiedName : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? ) ;
    public final void ruleQualifiedName() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalQualifiedNameTestLanguage.g:88:18: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? ) )
            // PsiInternalQualifiedNameTestLanguage.g:89:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? )
            {
            // PsiInternalQualifiedNameTestLanguage.g:89:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )? )
            // PsiInternalQualifiedNameTestLanguage.g:90:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= '.' kw= '*' )?
            {

            			markLeaf(elementTypeProvider.getQualifiedName_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            			doneLeaf(this_ID_0);
            		
            // PsiInternalQualifiedNameTestLanguage.g:97:3: (kw= '.' this_ID_2= RULE_ID )*
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
            	    // PsiInternalQualifiedNameTestLanguage.g:98:4: kw= '.' this_ID_2= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_1_0ElementType());
            	    			
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(kw);
            	    			

            	    				markLeaf(elementTypeProvider.getQualifiedName_IDTerminalRuleCall_1_1ElementType());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(this_ID_2);
            	    			

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // PsiInternalQualifiedNameTestLanguage.g:113:3: (kw= '.' kw= '*' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalQualifiedNameTestLanguage.g:114:4: kw= '.' kw= '*'
                    {

                    				markLeaf(elementTypeProvider.getQualifiedName_FullStopKeyword_2_0ElementType());
                    			
                    kw=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    				doneLeaf(kw);
                    			

                    				markLeaf(elementTypeProvider.getQualifiedName_AsteriskKeyword_2_1ElementType());
                    			
                    kw=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    }


}