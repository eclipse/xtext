package org.eclipse.xtext.parsetree.transientvalues.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalTransientValuesTestParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'required'", "'optional'", "':'", "'list'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalTransientValuesTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalTransientValuesTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalTransientValuesTestParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalTransientValuesTest.g"; }



    	protected TransientValuesTestGrammarAccess grammarAccess;

    	protected TransientValuesTestElementTypeProvider elementTypeProvider;

    	public PsiInternalTransientValuesTestParser(PsiBuilder builder, TokenStream input, TransientValuesTestElementTypeProvider elementTypeProvider, TransientValuesTestGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Root";
    	}




    // $ANTLR start "entryRuleRoot"
    // PsiInternalTransientValuesTest.g:52:1: entryRuleRoot returns [Boolean current=false] : iv_ruleRoot= ruleRoot EOF ;
    public final Boolean entryRuleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRoot = null;


        try {
            // PsiInternalTransientValuesTest.g:52:46: (iv_ruleRoot= ruleRoot EOF )
            // PsiInternalTransientValuesTest.g:53:2: iv_ruleRoot= ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalTransientValuesTest.g:59:1: ruleRoot returns [Boolean current=false] : (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_TestRequired_1 = null;

        Boolean this_TestOptional_2 = null;

        Boolean this_TestList_3 = null;


        try {
            // PsiInternalTransientValuesTest.g:60:1: ( (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) )
            // PsiInternalTransientValuesTest.g:61:2: (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            {
            // PsiInternalTransientValuesTest.g:61:2: (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            // PsiInternalTransientValuesTest.g:62:3: otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
            {

            			markLeaf(elementTypeProvider.getRoot_TestKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalTransientValuesTest.g:69:3: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalTransientValuesTest.g:70:4: this_TestRequired_1= ruleTestRequired
                    {

                    				markComposite(elementTypeProvider.getRoot_TestRequiredParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestRequired_1=ruleTestRequired();

                    state._fsp--;


                    				current = this_TestRequired_1;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalTransientValuesTest.g:79:4: this_TestOptional_2= ruleTestOptional
                    {

                    				markComposite(elementTypeProvider.getRoot_TestOptionalParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestOptional_2=ruleTestOptional();

                    state._fsp--;


                    				current = this_TestOptional_2;
                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalTransientValuesTest.g:88:4: this_TestList_3= ruleTestList
                    {

                    				markComposite(elementTypeProvider.getRoot_TestListParserRuleCall_1_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestList_3=ruleTestList();

                    state._fsp--;


                    				current = this_TestList_3;
                    				doneComposite();
                    			

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleTestRequired"
    // PsiInternalTransientValuesTest.g:101:1: entryRuleTestRequired returns [Boolean current=false] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final Boolean entryRuleTestRequired() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTestRequired = null;


        try {
            // PsiInternalTransientValuesTest.g:101:54: (iv_ruleTestRequired= ruleTestRequired EOF )
            // PsiInternalTransientValuesTest.g:102:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             markComposite(elementTypeProvider.getTestRequiredElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestRequired=ruleTestRequired();

            state._fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTestRequired"


    // $ANTLR start "ruleTestRequired"
    // PsiInternalTransientValuesTest.g:108:1: ruleTestRequired returns [Boolean current=false] : ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) ;
    public final Boolean ruleTestRequired() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_required1_2_0=null;
        Token lv_required2_3_0=null;

        try {
            // PsiInternalTransientValuesTest.g:109:1: ( ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) )
            // PsiInternalTransientValuesTest.g:110:2: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            {
            // PsiInternalTransientValuesTest.g:110:2: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            // PsiInternalTransientValuesTest.g:111:3: () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) )
            {
            // PsiInternalTransientValuesTest.g:111:3: ()
            // PsiInternalTransientValuesTest.g:112:4: 
            {

            				precedeComposite(elementTypeProvider.getTestRequired_TestRequiredAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTestRequired_RequiredKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalTransientValuesTest.g:125:3: ( (lv_required1_2_0= RULE_INT ) )
            // PsiInternalTransientValuesTest.g:126:4: (lv_required1_2_0= RULE_INT )
            {
            // PsiInternalTransientValuesTest.g:126:4: (lv_required1_2_0= RULE_INT )
            // PsiInternalTransientValuesTest.g:127:5: lv_required1_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getTestRequired_Required1INTTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_required1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_required1_2_0);
            				

            }


            }

            // PsiInternalTransientValuesTest.g:142:3: ( (lv_required2_3_0= RULE_INT ) )
            // PsiInternalTransientValuesTest.g:143:4: (lv_required2_3_0= RULE_INT )
            {
            // PsiInternalTransientValuesTest.g:143:4: (lv_required2_3_0= RULE_INT )
            // PsiInternalTransientValuesTest.g:144:5: lv_required2_3_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getTestRequired_Required2INTTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_required2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_required2_3_0);
            				

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
    // $ANTLR end "ruleTestRequired"


    // $ANTLR start "entryRuleTestOptional"
    // PsiInternalTransientValuesTest.g:163:1: entryRuleTestOptional returns [Boolean current=false] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final Boolean entryRuleTestOptional() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTestOptional = null;


        try {
            // PsiInternalTransientValuesTest.g:163:54: (iv_ruleTestOptional= ruleTestOptional EOF )
            // PsiInternalTransientValuesTest.g:164:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             markComposite(elementTypeProvider.getTestOptionalElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestOptional=ruleTestOptional();

            state._fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTestOptional"


    // $ANTLR start "ruleTestOptional"
    // PsiInternalTransientValuesTest.g:170:1: ruleTestOptional returns [Boolean current=false] : ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) ;
    public final Boolean ruleTestOptional() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_opt1_2_0=null;
        Token otherlv_3=null;
        Token lv_opt2_4_0=null;

        try {
            // PsiInternalTransientValuesTest.g:171:1: ( ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) )
            // PsiInternalTransientValuesTest.g:172:2: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            {
            // PsiInternalTransientValuesTest.g:172:2: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            // PsiInternalTransientValuesTest.g:173:3: () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            {
            // PsiInternalTransientValuesTest.g:173:3: ()
            // PsiInternalTransientValuesTest.g:174:4: 
            {

            				precedeComposite(elementTypeProvider.getTestOptional_TestOptionalAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTestOptional_OptionalKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalTransientValuesTest.g:187:3: ( (lv_opt1_2_0= RULE_INT ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalTransientValuesTest.g:188:4: (lv_opt1_2_0= RULE_INT )
                    {
                    // PsiInternalTransientValuesTest.g:188:4: (lv_opt1_2_0= RULE_INT )
                    // PsiInternalTransientValuesTest.g:189:5: lv_opt1_2_0= RULE_INT
                    {

                    					markLeaf(elementTypeProvider.getTestOptional_Opt1INTTerminalRuleCall_2_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_opt1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); 

                    					doneLeaf(lv_opt1_2_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalTransientValuesTest.g:204:3: (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalTransientValuesTest.g:205:4: otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) )
                    {

                    				markLeaf(elementTypeProvider.getTestOptional_ColonKeyword_3_0ElementType());
                    			
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalTransientValuesTest.g:212:4: ( (lv_opt2_4_0= RULE_INT ) )
                    // PsiInternalTransientValuesTest.g:213:5: (lv_opt2_4_0= RULE_INT )
                    {
                    // PsiInternalTransientValuesTest.g:213:5: (lv_opt2_4_0= RULE_INT )
                    // PsiInternalTransientValuesTest.g:214:6: lv_opt2_4_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getTestOptional_Opt2INTTerminalRuleCall_3_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_opt2_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_opt2_4_0);
                    					

                    }


                    }


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
    // $ANTLR end "ruleTestOptional"


    // $ANTLR start "entryRuleTestList"
    // PsiInternalTransientValuesTest.g:234:1: entryRuleTestList returns [Boolean current=false] : iv_ruleTestList= ruleTestList EOF ;
    public final Boolean entryRuleTestList() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTestList = null;


        try {
            // PsiInternalTransientValuesTest.g:234:50: (iv_ruleTestList= ruleTestList EOF )
            // PsiInternalTransientValuesTest.g:235:2: iv_ruleTestList= ruleTestList EOF
            {
             markComposite(elementTypeProvider.getTestListElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestList=ruleTestList();

            state._fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTestList"


    // $ANTLR start "ruleTestList"
    // PsiInternalTransientValuesTest.g:241:1: ruleTestList returns [Boolean current=false] : ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) ;
    public final Boolean ruleTestList() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_item_2_0=null;

        try {
            // PsiInternalTransientValuesTest.g:242:1: ( ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) )
            // PsiInternalTransientValuesTest.g:243:2: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            {
            // PsiInternalTransientValuesTest.g:243:2: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            // PsiInternalTransientValuesTest.g:244:3: () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )*
            {
            // PsiInternalTransientValuesTest.g:244:3: ()
            // PsiInternalTransientValuesTest.g:245:4: 
            {

            				precedeComposite(elementTypeProvider.getTestList_TestListAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTestList_ListKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalTransientValuesTest.g:258:3: ( (lv_item_2_0= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalTransientValuesTest.g:259:4: (lv_item_2_0= RULE_INT )
            	    {
            	    // PsiInternalTransientValuesTest.g:259:4: (lv_item_2_0= RULE_INT )
            	    // PsiInternalTransientValuesTest.g:260:5: lv_item_2_0= RULE_INT
            	    {

            	    					markLeaf(elementTypeProvider.getTestList_ItemINTTerminalRuleCall_2_0ElementType());
            	    				

            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				
            	    lv_item_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_7); 

            	    					doneLeaf(lv_item_2_0);
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleTestList"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000B000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000012L});
    }


}