package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug362902ElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.linking.services.Bug362902GrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug362902Parser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'favourite'", "'Hello'", "'!'"
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


        public PsiInternalBug362902Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug362902Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug362902Parser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g"; }



    	protected Bug362902GrammarAccess grammarAccess;

    	protected Bug362902ElementTypeProvider elementTypeProvider;

    	public PsiInternalBug362902Parser(PsiBuilder builder, TokenStream input, Bug362902ElementTypeProvider elementTypeProvider, Bug362902GrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:51:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:59:1: ruleModel : ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:59:10: ( ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:60:2: ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:60:2: ( ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:61:3: ( (lv_greetings_0_0= ruleGreeting ) )* otherlv_1= 'favourite' ( ( ruleMyId ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:61:3: ( (lv_greetings_0_0= ruleGreeting ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:62:4: (lv_greetings_0_0= ruleGreeting )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:62:4: (lv_greetings_0_0= ruleGreeting )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:63:5: lv_greetings_0_0= ruleGreeting
            	    {

            	    					markComposite(elementTypeProvider.getModel_GreetingsGreetingParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleGreeting_in_ruleModel96);
            	    ruleGreeting();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel122); 

            			doneLeaf(otherlv_1, elementTypeProvider.getModel_FavouriteKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:79:3: ( ( ruleMyId ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:80:4: ( ruleMyId )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:80:4: ( ruleMyId )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:81:5: ruleMyId
            {

            					markComposite(elementTypeProvider.getModel_FavouriteGreetingCrossReference_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleMyId_in_ruleModel147);
            ruleMyId();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleGreeting"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:94:1: entryRuleGreeting : ruleGreeting EOF ;
    public final void entryRuleGreeting() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:94:18: ( ruleGreeting EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:95:2: ruleGreeting EOF
            {
             markComposite(elementTypeProvider.getGreetingElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGreeting_in_entryRuleGreeting178);
            ruleGreeting();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGreeting184); 

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
    // $ANTLR end "entryRuleGreeting"


    // $ANTLR start "ruleGreeting"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:103:1: ruleGreeting : (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' ) ;
    public final void ruleGreeting() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:103:13: ( (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:104:2: (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:104:2: (otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:105:3: otherlv_0= 'Hello' ( (lv_name_1_0= ruleMyId ) ) otherlv_2= '!'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleGreeting207); 

            			doneLeaf(otherlv_0, elementTypeProvider.getGreeting_HelloKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:112:3: ( (lv_name_1_0= ruleMyId ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:113:4: (lv_name_1_0= ruleMyId )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:113:4: (lv_name_1_0= ruleMyId )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:114:5: lv_name_1_0= ruleMyId
            {

            					markComposite(elementTypeProvider.getGreeting_NameMyIdParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleMyId_in_ruleGreeting234);
            ruleMyId();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleGreeting259); 

            			doneLeaf(otherlv_2, elementTypeProvider.getGreeting_ExclamationMarkKeyword_2ElementType());
            		

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
    // $ANTLR end "ruleGreeting"


    // $ANTLR start "entryRuleMyId"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:134:1: entryRuleMyId : ruleMyId EOF ;
    public final void entryRuleMyId() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:134:14: ( ruleMyId EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:135:2: ruleMyId EOF
            {
             markComposite(elementTypeProvider.getMyIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMyId_in_entryRuleMyId279);
            ruleMyId();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyId285); 

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
    // $ANTLR end "entryRuleMyId"


    // $ANTLR start "ruleMyId"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:143:1: ruleMyId : this_ID_0= RULE_ID ;
    public final void ruleMyId() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:143:9: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalBug362902.g:144:2: this_ID_0= RULE_ID
            {

            		markLeaf();
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMyId303); 

            		doneLeaf(this_ID_0, elementTypeProvider.getMyId_IDTerminalRuleCallElementType());
            	

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
    // $ANTLR end "ruleMyId"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGreeting_in_ruleModel96 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_11_in_ruleModel122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMyId_in_ruleModel147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGreeting_in_entryRuleGreeting178 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGreeting184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleGreeting207 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMyId_in_ruleGreeting234 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleGreeting259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyId_in_entryRuleMyId279 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyId285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMyId303 = new BitSet(new long[]{0x0000000000000002L});
    }


}