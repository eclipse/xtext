package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalLangATestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'", "'implements'", "','"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalLangATestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalLangATestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalLangATestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalLangATestLanguage.g"; }



    	protected LangATestLanguageGrammarAccess grammarAccess;

    	protected LangATestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalLangATestLanguageParser(PsiBuilder builder, TokenStream input, LangATestLanguageElementTypeProvider elementTypeProvider, LangATestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Main";
    	}




    // $ANTLR start "entryRuleMain"
    // PsiInternalLangATestLanguage.g:52:1: entryRuleMain returns [Boolean current=false] : iv_ruleMain= ruleMain EOF ;
    public final Boolean entryRuleMain() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMain = null;


        try {
            // PsiInternalLangATestLanguage.g:52:46: (iv_ruleMain= ruleMain EOF )
            // PsiInternalLangATestLanguage.g:53:2: iv_ruleMain= ruleMain EOF
            {
             markComposite(elementTypeProvider.getMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMain=ruleMain();

            state._fsp--;

             current =iv_ruleMain; 
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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // PsiInternalLangATestLanguage.g:59:1: ruleMain returns [Boolean current=false] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) ;
    public final Boolean ruleMain() throws RecognitionException {
        Boolean current = false;

        Boolean lv_imports_0_0 = null;

        Boolean lv_types_1_0 = null;


        try {
            // PsiInternalLangATestLanguage.g:60:1: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) )
            // PsiInternalLangATestLanguage.g:61:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            {
            // PsiInternalLangATestLanguage.g:61:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            // PsiInternalLangATestLanguage.g:62:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )*
            {
            // PsiInternalLangATestLanguage.g:62:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalLangATestLanguage.g:63:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // PsiInternalLangATestLanguage.g:63:4: (lv_imports_0_0= ruleImport )
            	    // PsiInternalLangATestLanguage.g:64:5: lv_imports_0_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getMain_ImportsImportParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

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

            // PsiInternalLangATestLanguage.g:77:3: ( (lv_types_1_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalLangATestLanguage.g:78:4: (lv_types_1_0= ruleType )
            	    {
            	    // PsiInternalLangATestLanguage.g:78:4: (lv_types_1_0= ruleType )
            	    // PsiInternalLangATestLanguage.g:79:5: lv_types_1_0= ruleType
            	    {

            	    					markComposite(elementTypeProvider.getMain_TypesTypeParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_types_1_0=ruleType();

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
            	    break loop2;
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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleImport"
    // PsiInternalLangATestLanguage.g:96:1: entryRuleImport returns [Boolean current=false] : iv_ruleImport= ruleImport EOF ;
    public final Boolean entryRuleImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleImport = null;


        try {
            // PsiInternalLangATestLanguage.g:96:48: (iv_ruleImport= ruleImport EOF )
            // PsiInternalLangATestLanguage.g:97:2: iv_ruleImport= ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // PsiInternalLangATestLanguage.g:103:1: ruleImport returns [Boolean current=false] : (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) ;
    public final Boolean ruleImport() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_uri_1_0=null;

        try {
            // PsiInternalLangATestLanguage.g:104:1: ( (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) )
            // PsiInternalLangATestLanguage.g:105:2: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            {
            // PsiInternalLangATestLanguage.g:105:2: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            // PsiInternalLangATestLanguage.g:106:3: otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLangATestLanguage.g:113:3: ( (lv_uri_1_0= RULE_STRING ) )
            // PsiInternalLangATestLanguage.g:114:4: (lv_uri_1_0= RULE_STRING )
            {
            // PsiInternalLangATestLanguage.g:114:4: (lv_uri_1_0= RULE_STRING )
            // PsiInternalLangATestLanguage.g:115:5: lv_uri_1_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getImport_UriSTRINGTerminalRuleCall_1_0ElementType());
            				
            lv_uri_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_uri_1_0);
            				

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


    // $ANTLR start "entryRuleType"
    // PsiInternalLangATestLanguage.g:134:1: entryRuleType returns [Boolean current=false] : iv_ruleType= ruleType EOF ;
    public final Boolean entryRuleType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleType = null;


        try {
            // PsiInternalLangATestLanguage.g:134:46: (iv_ruleType= ruleType EOF )
            // PsiInternalLangATestLanguage.g:135:2: iv_ruleType= ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalLangATestLanguage.g:141:1: ruleType returns [Boolean current=false] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? ) ;
    public final Boolean ruleType() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

        try {
            // PsiInternalLangATestLanguage.g:142:1: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? ) )
            // PsiInternalLangATestLanguage.g:143:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? )
            {
            // PsiInternalLangATestLanguage.g:143:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? )
            // PsiInternalLangATestLanguage.g:144:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            {

            			markLeaf(elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLangATestLanguage.g:151:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalLangATestLanguage.g:152:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalLangATestLanguage.g:152:4: (lv_name_1_0= RULE_ID )
            // PsiInternalLangATestLanguage.g:153:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // PsiInternalLangATestLanguage.g:168:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalLangATestLanguage.g:169:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getType_ExtendsKeyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalLangATestLanguage.g:176:4: ( (otherlv_3= RULE_ID ) )
                    // PsiInternalLangATestLanguage.g:177:5: (otherlv_3= RULE_ID )
                    {
                    // PsiInternalLangATestLanguage.g:177:5: (otherlv_3= RULE_ID )
                    // PsiInternalLangATestLanguage.g:178:6: otherlv_3= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType());
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    						doneLeaf(otherlv_3);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalLangATestLanguage.g:194:3: (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalLangATestLanguage.g:195:4: otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {

                    				markLeaf(elementTypeProvider.getType_ImplementsKeyword_3_0ElementType());
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalLangATestLanguage.g:202:4: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalLangATestLanguage.g:203:5: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalLangATestLanguage.g:203:5: (otherlv_5= RULE_ID )
                    // PsiInternalLangATestLanguage.g:204:6: otherlv_5= RULE_ID
                    {

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						markLeaf(elementTypeProvider.getType_ImplementsTypeCrossReference_3_1_0ElementType());
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    						doneLeaf(otherlv_5);
                    					

                    }


                    }

                    // PsiInternalLangATestLanguage.g:219:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // PsiInternalLangATestLanguage.g:220:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getType_CommaKeyword_3_2_0ElementType());
                    	    				
                    	    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    	    					doneLeaf(otherlv_6);
                    	    				
                    	    // PsiInternalLangATestLanguage.g:227:5: ( (otherlv_7= RULE_ID ) )
                    	    // PsiInternalLangATestLanguage.g:228:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // PsiInternalLangATestLanguage.g:228:6: (otherlv_7= RULE_ID )
                    	    // PsiInternalLangATestLanguage.g:229:7: otherlv_7= RULE_ID
                    	    {

                    	    							if (!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						

                    	    							markLeaf(elementTypeProvider.getType_ImplementsTypeCrossReference_3_2_1_0ElementType());
                    	    						
                    	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    							doneLeaf(otherlv_7);
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


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
    // $ANTLR end "ruleType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008002L});
    }


}