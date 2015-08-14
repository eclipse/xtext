package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.reconstr.services.SerializationBug269362TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSerializationBug269362TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo'", "'bar'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalSerializationBug269362TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSerializationBug269362TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSerializationBug269362TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSerializationBug269362TestLanguage.g"; }



    	protected SerializationBug269362TestLanguageGrammarAccess grammarAccess;

    	protected SerializationBug269362TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSerializationBug269362TestLanguageParser(PsiBuilder builder, TokenStream input, SerializationBug269362TestLanguageElementTypeProvider elementTypeProvider, SerializationBug269362TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalSerializationBug269362TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalSerializationBug269362TestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalSerializationBug269362TestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalSerializationBug269362TestLanguage.g:58:1: ruleModel : ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_foo_1_0=null;
        Token otherlv_2=null;
        Token lv_bar_3_0=null;
        Token otherlv_4=null;
        Token lv_bar_5_0=null;

        try {
            // PsiInternalSerializationBug269362TestLanguage.g:58:10: ( ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) ) )
            // PsiInternalSerializationBug269362TestLanguage.g:59:2: ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) )
            {
            // PsiInternalSerializationBug269362TestLanguage.g:59:2: ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalSerializationBug269362TestLanguage.g:60:3: (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? )
                    {
                    // PsiInternalSerializationBug269362TestLanguage.g:60:3: (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? )
                    // PsiInternalSerializationBug269362TestLanguage.g:61:4: otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )?
                    {

                    				markLeaf(elementTypeProvider.getModel_FooKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalSerializationBug269362TestLanguage.g:68:4: ( (lv_foo_1_0= RULE_ID ) )
                    // PsiInternalSerializationBug269362TestLanguage.g:69:5: (lv_foo_1_0= RULE_ID )
                    {
                    // PsiInternalSerializationBug269362TestLanguage.g:69:5: (lv_foo_1_0= RULE_ID )
                    // PsiInternalSerializationBug269362TestLanguage.g:70:6: lv_foo_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getModel_FooIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_foo_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

                    						doneLeaf(lv_foo_1_0);
                    					

                    }


                    }

                    // PsiInternalSerializationBug269362TestLanguage.g:79:4: (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // PsiInternalSerializationBug269362TestLanguage.g:80:5: otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) )
                            {

                            					markLeaf(elementTypeProvider.getModel_BarKeyword_0_2_0ElementType());
                            				
                            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                            					doneLeaf(otherlv_2);
                            				
                            // PsiInternalSerializationBug269362TestLanguage.g:87:5: ( (lv_bar_3_0= RULE_ID ) )
                            // PsiInternalSerializationBug269362TestLanguage.g:88:6: (lv_bar_3_0= RULE_ID )
                            {
                            // PsiInternalSerializationBug269362TestLanguage.g:88:6: (lv_bar_3_0= RULE_ID )
                            // PsiInternalSerializationBug269362TestLanguage.g:89:7: lv_bar_3_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getModel_BarIDTerminalRuleCall_0_2_1_0ElementType());
                            						
                            lv_bar_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_bar_3_0);
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSerializationBug269362TestLanguage.g:101:3: (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) )
                    {
                    // PsiInternalSerializationBug269362TestLanguage.g:101:3: (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) )
                    // PsiInternalSerializationBug269362TestLanguage.g:102:4: otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_BarKeyword_1_0ElementType());
                    			
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalSerializationBug269362TestLanguage.g:109:4: ( (lv_bar_5_0= RULE_ID ) )
                    // PsiInternalSerializationBug269362TestLanguage.g:110:5: (lv_bar_5_0= RULE_ID )
                    {
                    // PsiInternalSerializationBug269362TestLanguage.g:110:5: (lv_bar_5_0= RULE_ID )
                    // PsiInternalSerializationBug269362TestLanguage.g:111:6: lv_bar_5_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getModel_BarIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_bar_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_bar_5_0);
                    					

                    }


                    }


                    }


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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    }


}