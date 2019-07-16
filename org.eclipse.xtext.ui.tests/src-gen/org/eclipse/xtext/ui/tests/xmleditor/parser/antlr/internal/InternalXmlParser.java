package org.eclipse.xtext.ui.tests.xmleditor.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.xmleditor.services.XmlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXmlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TAG_START_OPEN", "RULE_TAG_END_OPEN", "RULE_TAG_CLOSE", "RULE_TAG_EMPTY_CLOSE", "RULE_ATTR_EQ", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_PCDATA"
    };
    public static final int RULE_ID=9;
    public static final int RULE_WS=11;
    public static final int RULE_TAG_CLOSE=6;
    public static final int RULE_PCDATA=12;
    public static final int RULE_STRING=10;
    public static final int RULE_TAG_START_OPEN=4;
    public static final int RULE_TAG_EMPTY_CLOSE=7;
    public static final int RULE_ATTR_EQ=8;
    public static final int RULE_TAG_END_OPEN=5;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalXmlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXmlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXmlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXmlParser.g"; }



     	private XmlGrammarAccess grammarAccess;

        public InternalXmlParser(TokenStream input, XmlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "XmlDocument";
       	}

       	@Override
       	protected XmlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleXmlDocument"
    // InternalXmlParser.g:57:1: entryRuleXmlDocument returns [EObject current=null] : iv_ruleXmlDocument= ruleXmlDocument EOF ;
    public final EObject entryRuleXmlDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXmlDocument = null;


        try {
            // InternalXmlParser.g:57:52: (iv_ruleXmlDocument= ruleXmlDocument EOF )
            // InternalXmlParser.g:58:2: iv_ruleXmlDocument= ruleXmlDocument EOF
            {
             newCompositeNode(grammarAccess.getXmlDocumentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXmlDocument=ruleXmlDocument();

            state._fsp--;

             current =iv_ruleXmlDocument; 
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
    // $ANTLR end "entryRuleXmlDocument"


    // $ANTLR start "ruleXmlDocument"
    // InternalXmlParser.g:64:1: ruleXmlDocument returns [EObject current=null] : ( () ( (lv_contents_1_0= ruleContent ) )* ) ;
    public final EObject ruleXmlDocument() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_1_0 = null;



        	enterRule();

        try {
            // InternalXmlParser.g:70:2: ( ( () ( (lv_contents_1_0= ruleContent ) )* ) )
            // InternalXmlParser.g:71:2: ( () ( (lv_contents_1_0= ruleContent ) )* )
            {
            // InternalXmlParser.g:71:2: ( () ( (lv_contents_1_0= ruleContent ) )* )
            // InternalXmlParser.g:72:3: () ( (lv_contents_1_0= ruleContent ) )*
            {
            // InternalXmlParser.g:72:3: ()
            // InternalXmlParser.g:73:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXmlDocumentAccess().getXmlDocumentAction_0(),
            					current);
            			

            }

            // InternalXmlParser.g:79:3: ( (lv_contents_1_0= ruleContent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_TAG_START_OPEN||LA1_0==RULE_PCDATA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXmlParser.g:80:4: (lv_contents_1_0= ruleContent )
            	    {
            	    // InternalXmlParser.g:80:4: (lv_contents_1_0= ruleContent )
            	    // InternalXmlParser.g:81:5: lv_contents_1_0= ruleContent
            	    {

            	    					newCompositeNode(grammarAccess.getXmlDocumentAccess().getContentsContentParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_contents_1_0=ruleContent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getXmlDocumentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"contents",
            	    						lv_contents_1_0,
            	    						"org.eclipse.xtext.ui.tests.xmleditor.Xml.Content");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleXmlDocument"


    // $ANTLR start "entryRuleContent"
    // InternalXmlParser.g:102:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // InternalXmlParser.g:102:48: (iv_ruleContent= ruleContent EOF )
            // InternalXmlParser.g:103:2: iv_ruleContent= ruleContent EOF
            {
             newCompositeNode(grammarAccess.getContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContent=ruleContent();

            state._fsp--;

             current =iv_ruleContent; 
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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // InternalXmlParser.g:109:1: ruleContent returns [EObject current=null] : ( ( (lv_tag_0_0= ruleTag ) ) | ( (lv_text_1_0= RULE_PCDATA ) ) ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token lv_text_1_0=null;
        EObject lv_tag_0_0 = null;



        	enterRule();

        try {
            // InternalXmlParser.g:115:2: ( ( ( (lv_tag_0_0= ruleTag ) ) | ( (lv_text_1_0= RULE_PCDATA ) ) ) )
            // InternalXmlParser.g:116:2: ( ( (lv_tag_0_0= ruleTag ) ) | ( (lv_text_1_0= RULE_PCDATA ) ) )
            {
            // InternalXmlParser.g:116:2: ( ( (lv_tag_0_0= ruleTag ) ) | ( (lv_text_1_0= RULE_PCDATA ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_TAG_START_OPEN) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_PCDATA) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXmlParser.g:117:3: ( (lv_tag_0_0= ruleTag ) )
                    {
                    // InternalXmlParser.g:117:3: ( (lv_tag_0_0= ruleTag ) )
                    // InternalXmlParser.g:118:4: (lv_tag_0_0= ruleTag )
                    {
                    // InternalXmlParser.g:118:4: (lv_tag_0_0= ruleTag )
                    // InternalXmlParser.g:119:5: lv_tag_0_0= ruleTag
                    {

                    					newCompositeNode(grammarAccess.getContentAccess().getTagTagParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_tag_0_0=ruleTag();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getContentRule());
                    					}
                    					set(
                    						current,
                    						"tag",
                    						lv_tag_0_0,
                    						"org.eclipse.xtext.ui.tests.xmleditor.Xml.Tag");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXmlParser.g:137:3: ( (lv_text_1_0= RULE_PCDATA ) )
                    {
                    // InternalXmlParser.g:137:3: ( (lv_text_1_0= RULE_PCDATA ) )
                    // InternalXmlParser.g:138:4: (lv_text_1_0= RULE_PCDATA )
                    {
                    // InternalXmlParser.g:138:4: (lv_text_1_0= RULE_PCDATA )
                    // InternalXmlParser.g:139:5: lv_text_1_0= RULE_PCDATA
                    {
                    lv_text_1_0=(Token)match(input,RULE_PCDATA,FOLLOW_2); 

                    					newLeafNode(lv_text_1_0, grammarAccess.getContentAccess().getTextPCDATATerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContentRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"text",
                    						lv_text_1_0,
                    						"org.eclipse.xtext.ui.tests.xmleditor.Xml.PCDATA");
                    				

                    }


                    }


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
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleTag"
    // InternalXmlParser.g:159:1: entryRuleTag returns [EObject current=null] : iv_ruleTag= ruleTag EOF ;
    public final EObject entryRuleTag() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTag = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalXmlParser.g:161:2: (iv_ruleTag= ruleTag EOF )
            // InternalXmlParser.g:162:2: iv_ruleTag= ruleTag EOF
            {
             newCompositeNode(grammarAccess.getTagRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTag=ruleTag();

            state._fsp--;

             current =iv_ruleTag; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTag"


    // $ANTLR start "ruleTag"
    // InternalXmlParser.g:171:1: ruleTag returns [EObject current=null] : (this_TAG_START_OPEN_0= RULE_TAG_START_OPEN ( (lv_name_1_0= RULE_ID ) ) ( (lv_attributes_2_0= ruleAttribute ) )* (this_TAG_EMPTY_CLOSE_3= RULE_TAG_EMPTY_CLOSE | (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE ) ) ) ;
    public final EObject ruleTag() throws RecognitionException {
        EObject current = null;

        Token this_TAG_START_OPEN_0=null;
        Token lv_name_1_0=null;
        Token this_TAG_EMPTY_CLOSE_3=null;
        Token this_TAG_CLOSE_4=null;
        Token this_TAG_END_OPEN_6=null;
        Token lv_closeName_7_0=null;
        Token this_TAG_CLOSE_8=null;
        EObject lv_attributes_2_0 = null;

        EObject lv_contents_5_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalXmlParser.g:178:2: ( (this_TAG_START_OPEN_0= RULE_TAG_START_OPEN ( (lv_name_1_0= RULE_ID ) ) ( (lv_attributes_2_0= ruleAttribute ) )* (this_TAG_EMPTY_CLOSE_3= RULE_TAG_EMPTY_CLOSE | (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE ) ) ) )
            // InternalXmlParser.g:179:2: (this_TAG_START_OPEN_0= RULE_TAG_START_OPEN ( (lv_name_1_0= RULE_ID ) ) ( (lv_attributes_2_0= ruleAttribute ) )* (this_TAG_EMPTY_CLOSE_3= RULE_TAG_EMPTY_CLOSE | (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE ) ) )
            {
            // InternalXmlParser.g:179:2: (this_TAG_START_OPEN_0= RULE_TAG_START_OPEN ( (lv_name_1_0= RULE_ID ) ) ( (lv_attributes_2_0= ruleAttribute ) )* (this_TAG_EMPTY_CLOSE_3= RULE_TAG_EMPTY_CLOSE | (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE ) ) )
            // InternalXmlParser.g:180:3: this_TAG_START_OPEN_0= RULE_TAG_START_OPEN ( (lv_name_1_0= RULE_ID ) ) ( (lv_attributes_2_0= ruleAttribute ) )* (this_TAG_EMPTY_CLOSE_3= RULE_TAG_EMPTY_CLOSE | (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE ) )
            {
            this_TAG_START_OPEN_0=(Token)match(input,RULE_TAG_START_OPEN,FOLLOW_4); 

            			newLeafNode(this_TAG_START_OPEN_0, grammarAccess.getTagAccess().getTAG_START_OPENTerminalRuleCall_0());
            		
            // InternalXmlParser.g:184:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXmlParser.g:185:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXmlParser.g:185:4: (lv_name_1_0= RULE_ID )
            // InternalXmlParser.g:186:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTagAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTagRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.ui.tests.xmleditor.Xml.ID");
            				

            }


            }

            // InternalXmlParser.g:202:3: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalXmlParser.g:203:4: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalXmlParser.g:203:4: (lv_attributes_2_0= ruleAttribute )
            	    // InternalXmlParser.g:204:5: lv_attributes_2_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getTagAccess().getAttributesAttributeParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_attributes_2_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTagRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_2_0,
            	    						"org.eclipse.xtext.ui.tests.xmleditor.Xml.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalXmlParser.g:221:3: (this_TAG_EMPTY_CLOSE_3= RULE_TAG_EMPTY_CLOSE | (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_TAG_EMPTY_CLOSE) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_TAG_CLOSE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXmlParser.g:222:4: this_TAG_EMPTY_CLOSE_3= RULE_TAG_EMPTY_CLOSE
                    {
                    this_TAG_EMPTY_CLOSE_3=(Token)match(input,RULE_TAG_EMPTY_CLOSE,FOLLOW_2); 

                    				newLeafNode(this_TAG_EMPTY_CLOSE_3, grammarAccess.getTagAccess().getTAG_EMPTY_CLOSETerminalRuleCall_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalXmlParser.g:227:4: (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE )
                    {
                    // InternalXmlParser.g:227:4: (this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE )
                    // InternalXmlParser.g:228:5: this_TAG_CLOSE_4= RULE_TAG_CLOSE ( (lv_contents_5_0= ruleContent ) )* this_TAG_END_OPEN_6= RULE_TAG_END_OPEN ( (lv_closeName_7_0= RULE_ID ) ) this_TAG_CLOSE_8= RULE_TAG_CLOSE
                    {
                    this_TAG_CLOSE_4=(Token)match(input,RULE_TAG_CLOSE,FOLLOW_6); 

                    					newLeafNode(this_TAG_CLOSE_4, grammarAccess.getTagAccess().getTAG_CLOSETerminalRuleCall_3_1_0());
                    				
                    // InternalXmlParser.g:232:5: ( (lv_contents_5_0= ruleContent ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_TAG_START_OPEN||LA4_0==RULE_PCDATA) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalXmlParser.g:233:6: (lv_contents_5_0= ruleContent )
                    	    {
                    	    // InternalXmlParser.g:233:6: (lv_contents_5_0= ruleContent )
                    	    // InternalXmlParser.g:234:7: lv_contents_5_0= ruleContent
                    	    {

                    	    							newCompositeNode(grammarAccess.getTagAccess().getContentsContentParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_6);
                    	    lv_contents_5_0=ruleContent();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTagRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"contents",
                    	    								lv_contents_5_0,
                    	    								"org.eclipse.xtext.ui.tests.xmleditor.Xml.Content");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    this_TAG_END_OPEN_6=(Token)match(input,RULE_TAG_END_OPEN,FOLLOW_4); 

                    					newLeafNode(this_TAG_END_OPEN_6, grammarAccess.getTagAccess().getTAG_END_OPENTerminalRuleCall_3_1_2());
                    				
                    // InternalXmlParser.g:255:5: ( (lv_closeName_7_0= RULE_ID ) )
                    // InternalXmlParser.g:256:6: (lv_closeName_7_0= RULE_ID )
                    {
                    // InternalXmlParser.g:256:6: (lv_closeName_7_0= RULE_ID )
                    // InternalXmlParser.g:257:7: lv_closeName_7_0= RULE_ID
                    {
                    lv_closeName_7_0=(Token)match(input,RULE_ID,FOLLOW_7); 

                    							newLeafNode(lv_closeName_7_0, grammarAccess.getTagAccess().getCloseNameIDTerminalRuleCall_3_1_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTagRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"closeName",
                    								lv_closeName_7_0,
                    								"org.eclipse.xtext.ui.tests.xmleditor.Xml.ID");
                    						

                    }


                    }

                    this_TAG_CLOSE_8=(Token)match(input,RULE_TAG_CLOSE,FOLLOW_2); 

                    					newLeafNode(this_TAG_CLOSE_8, grammarAccess.getTagAccess().getTAG_CLOSETerminalRuleCall_3_1_4());
                    				

                    }


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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTag"


    // $ANTLR start "entryRuleAttribute"
    // InternalXmlParser.g:286:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalXmlParser.g:286:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalXmlParser.g:287:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalXmlParser.g:293:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_ATTR_EQ_1= RULE_ATTR_EQ ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_ATTR_EQ_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalXmlParser.g:299:2: ( ( ( (lv_name_0_0= RULE_ID ) ) this_ATTR_EQ_1= RULE_ATTR_EQ ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalXmlParser.g:300:2: ( ( (lv_name_0_0= RULE_ID ) ) this_ATTR_EQ_1= RULE_ATTR_EQ ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalXmlParser.g:300:2: ( ( (lv_name_0_0= RULE_ID ) ) this_ATTR_EQ_1= RULE_ATTR_EQ ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalXmlParser.g:301:3: ( (lv_name_0_0= RULE_ID ) ) this_ATTR_EQ_1= RULE_ATTR_EQ ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalXmlParser.g:301:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalXmlParser.g:302:4: (lv_name_0_0= RULE_ID )
            {
            // InternalXmlParser.g:302:4: (lv_name_0_0= RULE_ID )
            // InternalXmlParser.g:303:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.ui.tests.xmleditor.Xml.ID");
            				

            }


            }

            this_ATTR_EQ_1=(Token)match(input,RULE_ATTR_EQ,FOLLOW_9); 

            			newLeafNode(this_ATTR_EQ_1, grammarAccess.getAttributeAccess().getATTR_EQTerminalRuleCall_1());
            		
            // InternalXmlParser.g:323:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalXmlParser.g:324:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalXmlParser.g:324:4: (lv_value_2_0= RULE_STRING )
            // InternalXmlParser.g:325:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.ui.tests.xmleditor.Xml.STRING");
            				

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
    // $ANTLR end "ruleAttribute"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000400L});

}