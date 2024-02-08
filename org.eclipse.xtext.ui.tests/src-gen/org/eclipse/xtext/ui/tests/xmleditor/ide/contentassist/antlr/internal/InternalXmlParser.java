package org.eclipse.xtext.ui.tests.xmleditor.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.xmleditor.services.XmlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalXmlParser extends AbstractInternalContentAssistParser {
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
    	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
    	
    	{
    	}

    	public void setGrammarAccess(XmlGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		String result = tokenNameToValue.get(tokenName);
    		if (result == null)
    			result = tokenName;
    		return result;
    	}



    // $ANTLR start "entryRuleXmlDocument"
    // InternalXmlParser.g:60:1: entryRuleXmlDocument : ruleXmlDocument EOF ;
    public final void entryRuleXmlDocument() throws RecognitionException {
        try {
            // InternalXmlParser.g:61:1: ( ruleXmlDocument EOF )
            // InternalXmlParser.g:62:1: ruleXmlDocument EOF
            {
             before(grammarAccess.getXmlDocumentRule()); 
            pushFollow(FOLLOW_1);
            ruleXmlDocument();

            state._fsp--;

             after(grammarAccess.getXmlDocumentRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleXmlDocument"


    // $ANTLR start "ruleXmlDocument"
    // InternalXmlParser.g:69:1: ruleXmlDocument : ( ( rule__XmlDocument__Group__0 ) ) ;
    public final void ruleXmlDocument() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:73:2: ( ( ( rule__XmlDocument__Group__0 ) ) )
            // InternalXmlParser.g:74:2: ( ( rule__XmlDocument__Group__0 ) )
            {
            // InternalXmlParser.g:74:2: ( ( rule__XmlDocument__Group__0 ) )
            // InternalXmlParser.g:75:3: ( rule__XmlDocument__Group__0 )
            {
             before(grammarAccess.getXmlDocumentAccess().getGroup()); 
            // InternalXmlParser.g:76:3: ( rule__XmlDocument__Group__0 )
            // InternalXmlParser.g:76:4: rule__XmlDocument__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XmlDocument__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXmlDocumentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXmlDocument"


    // $ANTLR start "entryRuleContent"
    // InternalXmlParser.g:85:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // InternalXmlParser.g:86:1: ( ruleContent EOF )
            // InternalXmlParser.g:87:1: ruleContent EOF
            {
             before(grammarAccess.getContentRule()); 
            pushFollow(FOLLOW_1);
            ruleContent();

            state._fsp--;

             after(grammarAccess.getContentRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // InternalXmlParser.g:94:1: ruleContent : ( ( rule__Content__Alternatives ) ) ;
    public final void ruleContent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:98:2: ( ( ( rule__Content__Alternatives ) ) )
            // InternalXmlParser.g:99:2: ( ( rule__Content__Alternatives ) )
            {
            // InternalXmlParser.g:99:2: ( ( rule__Content__Alternatives ) )
            // InternalXmlParser.g:100:3: ( rule__Content__Alternatives )
            {
             before(grammarAccess.getContentAccess().getAlternatives()); 
            // InternalXmlParser.g:101:3: ( rule__Content__Alternatives )
            // InternalXmlParser.g:101:4: rule__Content__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Content__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleTag"
    // InternalXmlParser.g:110:1: entryRuleTag : ruleTag EOF ;
    public final void entryRuleTag() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalXmlParser.g:114:1: ( ruleTag EOF )
            // InternalXmlParser.g:115:1: ruleTag EOF
            {
             before(grammarAccess.getTagRule()); 
            pushFollow(FOLLOW_1);
            ruleTag();

            state._fsp--;

             after(grammarAccess.getTagRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleTag"


    // $ANTLR start "ruleTag"
    // InternalXmlParser.g:125:1: ruleTag : ( ( rule__Tag__Group__0 ) ) ;
    public final void ruleTag() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:130:2: ( ( ( rule__Tag__Group__0 ) ) )
            // InternalXmlParser.g:131:2: ( ( rule__Tag__Group__0 ) )
            {
            // InternalXmlParser.g:131:2: ( ( rule__Tag__Group__0 ) )
            // InternalXmlParser.g:132:3: ( rule__Tag__Group__0 )
            {
             before(grammarAccess.getTagAccess().getGroup()); 
            // InternalXmlParser.g:133:3: ( rule__Tag__Group__0 )
            // InternalXmlParser.g:133:4: rule__Tag__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Tag__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTagAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleTag"


    // $ANTLR start "entryRuleAttribute"
    // InternalXmlParser.g:143:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalXmlParser.g:144:1: ( ruleAttribute EOF )
            // InternalXmlParser.g:145:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalXmlParser.g:152:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:156:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalXmlParser.g:157:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalXmlParser.g:157:2: ( ( rule__Attribute__Group__0 ) )
            // InternalXmlParser.g:158:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalXmlParser.g:159:3: ( rule__Attribute__Group__0 )
            // InternalXmlParser.g:159:4: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "rule__Content__Alternatives"
    // InternalXmlParser.g:167:1: rule__Content__Alternatives : ( ( ( rule__Content__TagAssignment_0 ) ) | ( ( rule__Content__TextAssignment_1 ) ) );
    public final void rule__Content__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:171:1: ( ( ( rule__Content__TagAssignment_0 ) ) | ( ( rule__Content__TextAssignment_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_TAG_START_OPEN) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_PCDATA) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalXmlParser.g:172:2: ( ( rule__Content__TagAssignment_0 ) )
                    {
                    // InternalXmlParser.g:172:2: ( ( rule__Content__TagAssignment_0 ) )
                    // InternalXmlParser.g:173:3: ( rule__Content__TagAssignment_0 )
                    {
                     before(grammarAccess.getContentAccess().getTagAssignment_0()); 
                    // InternalXmlParser.g:174:3: ( rule__Content__TagAssignment_0 )
                    // InternalXmlParser.g:174:4: rule__Content__TagAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Content__TagAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getContentAccess().getTagAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXmlParser.g:178:2: ( ( rule__Content__TextAssignment_1 ) )
                    {
                    // InternalXmlParser.g:178:2: ( ( rule__Content__TextAssignment_1 ) )
                    // InternalXmlParser.g:179:3: ( rule__Content__TextAssignment_1 )
                    {
                     before(grammarAccess.getContentAccess().getTextAssignment_1()); 
                    // InternalXmlParser.g:180:3: ( rule__Content__TextAssignment_1 )
                    // InternalXmlParser.g:180:4: rule__Content__TextAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Content__TextAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getContentAccess().getTextAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Alternatives"


    // $ANTLR start "rule__Tag__Alternatives_3"
    // InternalXmlParser.g:188:1: rule__Tag__Alternatives_3 : ( ( RULE_TAG_EMPTY_CLOSE ) | ( ( rule__Tag__Group_3_1__0 ) ) );
    public final void rule__Tag__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:192:1: ( ( RULE_TAG_EMPTY_CLOSE ) | ( ( rule__Tag__Group_3_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_TAG_EMPTY_CLOSE) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_TAG_CLOSE) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXmlParser.g:193:2: ( RULE_TAG_EMPTY_CLOSE )
                    {
                    // InternalXmlParser.g:193:2: ( RULE_TAG_EMPTY_CLOSE )
                    // InternalXmlParser.g:194:3: RULE_TAG_EMPTY_CLOSE
                    {
                     before(grammarAccess.getTagAccess().getTAG_EMPTY_CLOSETerminalRuleCall_3_0()); 
                    match(input,RULE_TAG_EMPTY_CLOSE,FOLLOW_2); 
                     after(grammarAccess.getTagAccess().getTAG_EMPTY_CLOSETerminalRuleCall_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXmlParser.g:199:2: ( ( rule__Tag__Group_3_1__0 ) )
                    {
                    // InternalXmlParser.g:199:2: ( ( rule__Tag__Group_3_1__0 ) )
                    // InternalXmlParser.g:200:3: ( rule__Tag__Group_3_1__0 )
                    {
                     before(grammarAccess.getTagAccess().getGroup_3_1()); 
                    // InternalXmlParser.g:201:3: ( rule__Tag__Group_3_1__0 )
                    // InternalXmlParser.g:201:4: rule__Tag__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Tag__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTagAccess().getGroup_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Alternatives_3"


    // $ANTLR start "rule__XmlDocument__Group__0"
    // InternalXmlParser.g:209:1: rule__XmlDocument__Group__0 : rule__XmlDocument__Group__0__Impl rule__XmlDocument__Group__1 ;
    public final void rule__XmlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:213:1: ( rule__XmlDocument__Group__0__Impl rule__XmlDocument__Group__1 )
            // InternalXmlParser.g:214:2: rule__XmlDocument__Group__0__Impl rule__XmlDocument__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__XmlDocument__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XmlDocument__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XmlDocument__Group__0"


    // $ANTLR start "rule__XmlDocument__Group__0__Impl"
    // InternalXmlParser.g:221:1: rule__XmlDocument__Group__0__Impl : ( () ) ;
    public final void rule__XmlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:225:1: ( ( () ) )
            // InternalXmlParser.g:226:1: ( () )
            {
            // InternalXmlParser.g:226:1: ( () )
            // InternalXmlParser.g:227:2: ()
            {
             before(grammarAccess.getXmlDocumentAccess().getXmlDocumentAction_0()); 
            // InternalXmlParser.g:228:2: ()
            // InternalXmlParser.g:228:3: 
            {
            }

             after(grammarAccess.getXmlDocumentAccess().getXmlDocumentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XmlDocument__Group__0__Impl"


    // $ANTLR start "rule__XmlDocument__Group__1"
    // InternalXmlParser.g:236:1: rule__XmlDocument__Group__1 : rule__XmlDocument__Group__1__Impl ;
    public final void rule__XmlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:240:1: ( rule__XmlDocument__Group__1__Impl )
            // InternalXmlParser.g:241:2: rule__XmlDocument__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XmlDocument__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XmlDocument__Group__1"


    // $ANTLR start "rule__XmlDocument__Group__1__Impl"
    // InternalXmlParser.g:247:1: rule__XmlDocument__Group__1__Impl : ( ( rule__XmlDocument__ContentsAssignment_1 )* ) ;
    public final void rule__XmlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:251:1: ( ( ( rule__XmlDocument__ContentsAssignment_1 )* ) )
            // InternalXmlParser.g:252:1: ( ( rule__XmlDocument__ContentsAssignment_1 )* )
            {
            // InternalXmlParser.g:252:1: ( ( rule__XmlDocument__ContentsAssignment_1 )* )
            // InternalXmlParser.g:253:2: ( rule__XmlDocument__ContentsAssignment_1 )*
            {
             before(grammarAccess.getXmlDocumentAccess().getContentsAssignment_1()); 
            // InternalXmlParser.g:254:2: ( rule__XmlDocument__ContentsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_TAG_START_OPEN||LA3_0==RULE_PCDATA) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalXmlParser.g:254:3: rule__XmlDocument__ContentsAssignment_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__XmlDocument__ContentsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getXmlDocumentAccess().getContentsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XmlDocument__Group__1__Impl"


    // $ANTLR start "rule__Tag__Group__0"
    // InternalXmlParser.g:263:1: rule__Tag__Group__0 : rule__Tag__Group__0__Impl rule__Tag__Group__1 ;
    public final void rule__Tag__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:267:1: ( rule__Tag__Group__0__Impl rule__Tag__Group__1 )
            // InternalXmlParser.g:268:2: rule__Tag__Group__0__Impl rule__Tag__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Tag__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tag__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__0"


    // $ANTLR start "rule__Tag__Group__0__Impl"
    // InternalXmlParser.g:275:1: rule__Tag__Group__0__Impl : ( RULE_TAG_START_OPEN ) ;
    public final void rule__Tag__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:279:1: ( ( RULE_TAG_START_OPEN ) )
            // InternalXmlParser.g:280:1: ( RULE_TAG_START_OPEN )
            {
            // InternalXmlParser.g:280:1: ( RULE_TAG_START_OPEN )
            // InternalXmlParser.g:281:2: RULE_TAG_START_OPEN
            {
             before(grammarAccess.getTagAccess().getTAG_START_OPENTerminalRuleCall_0()); 
            match(input,RULE_TAG_START_OPEN,FOLLOW_2); 
             after(grammarAccess.getTagAccess().getTAG_START_OPENTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__0__Impl"


    // $ANTLR start "rule__Tag__Group__1"
    // InternalXmlParser.g:290:1: rule__Tag__Group__1 : rule__Tag__Group__1__Impl rule__Tag__Group__2 ;
    public final void rule__Tag__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:294:1: ( rule__Tag__Group__1__Impl rule__Tag__Group__2 )
            // InternalXmlParser.g:295:2: rule__Tag__Group__1__Impl rule__Tag__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Tag__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tag__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__1"


    // $ANTLR start "rule__Tag__Group__1__Impl"
    // InternalXmlParser.g:302:1: rule__Tag__Group__1__Impl : ( ( rule__Tag__NameAssignment_1 ) ) ;
    public final void rule__Tag__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:306:1: ( ( ( rule__Tag__NameAssignment_1 ) ) )
            // InternalXmlParser.g:307:1: ( ( rule__Tag__NameAssignment_1 ) )
            {
            // InternalXmlParser.g:307:1: ( ( rule__Tag__NameAssignment_1 ) )
            // InternalXmlParser.g:308:2: ( rule__Tag__NameAssignment_1 )
            {
             before(grammarAccess.getTagAccess().getNameAssignment_1()); 
            // InternalXmlParser.g:309:2: ( rule__Tag__NameAssignment_1 )
            // InternalXmlParser.g:309:3: rule__Tag__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Tag__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTagAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__1__Impl"


    // $ANTLR start "rule__Tag__Group__2"
    // InternalXmlParser.g:317:1: rule__Tag__Group__2 : rule__Tag__Group__2__Impl rule__Tag__Group__3 ;
    public final void rule__Tag__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:321:1: ( rule__Tag__Group__2__Impl rule__Tag__Group__3 )
            // InternalXmlParser.g:322:2: rule__Tag__Group__2__Impl rule__Tag__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Tag__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tag__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__2"


    // $ANTLR start "rule__Tag__Group__2__Impl"
    // InternalXmlParser.g:329:1: rule__Tag__Group__2__Impl : ( ( rule__Tag__AttributesAssignment_2 )* ) ;
    public final void rule__Tag__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:333:1: ( ( ( rule__Tag__AttributesAssignment_2 )* ) )
            // InternalXmlParser.g:334:1: ( ( rule__Tag__AttributesAssignment_2 )* )
            {
            // InternalXmlParser.g:334:1: ( ( rule__Tag__AttributesAssignment_2 )* )
            // InternalXmlParser.g:335:2: ( rule__Tag__AttributesAssignment_2 )*
            {
             before(grammarAccess.getTagAccess().getAttributesAssignment_2()); 
            // InternalXmlParser.g:336:2: ( rule__Tag__AttributesAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalXmlParser.g:336:3: rule__Tag__AttributesAssignment_2
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Tag__AttributesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTagAccess().getAttributesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__2__Impl"


    // $ANTLR start "rule__Tag__Group__3"
    // InternalXmlParser.g:344:1: rule__Tag__Group__3 : rule__Tag__Group__3__Impl ;
    public final void rule__Tag__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:348:1: ( rule__Tag__Group__3__Impl )
            // InternalXmlParser.g:349:2: rule__Tag__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tag__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__3"


    // $ANTLR start "rule__Tag__Group__3__Impl"
    // InternalXmlParser.g:355:1: rule__Tag__Group__3__Impl : ( ( rule__Tag__Alternatives_3 ) ) ;
    public final void rule__Tag__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:359:1: ( ( ( rule__Tag__Alternatives_3 ) ) )
            // InternalXmlParser.g:360:1: ( ( rule__Tag__Alternatives_3 ) )
            {
            // InternalXmlParser.g:360:1: ( ( rule__Tag__Alternatives_3 ) )
            // InternalXmlParser.g:361:2: ( rule__Tag__Alternatives_3 )
            {
             before(grammarAccess.getTagAccess().getAlternatives_3()); 
            // InternalXmlParser.g:362:2: ( rule__Tag__Alternatives_3 )
            // InternalXmlParser.g:362:3: rule__Tag__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__Tag__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getTagAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group__3__Impl"


    // $ANTLR start "rule__Tag__Group_3_1__0"
    // InternalXmlParser.g:371:1: rule__Tag__Group_3_1__0 : rule__Tag__Group_3_1__0__Impl rule__Tag__Group_3_1__1 ;
    public final void rule__Tag__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:375:1: ( rule__Tag__Group_3_1__0__Impl rule__Tag__Group_3_1__1 )
            // InternalXmlParser.g:376:2: rule__Tag__Group_3_1__0__Impl rule__Tag__Group_3_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Tag__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tag__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__0"


    // $ANTLR start "rule__Tag__Group_3_1__0__Impl"
    // InternalXmlParser.g:383:1: rule__Tag__Group_3_1__0__Impl : ( RULE_TAG_CLOSE ) ;
    public final void rule__Tag__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:387:1: ( ( RULE_TAG_CLOSE ) )
            // InternalXmlParser.g:388:1: ( RULE_TAG_CLOSE )
            {
            // InternalXmlParser.g:388:1: ( RULE_TAG_CLOSE )
            // InternalXmlParser.g:389:2: RULE_TAG_CLOSE
            {
             before(grammarAccess.getTagAccess().getTAG_CLOSETerminalRuleCall_3_1_0()); 
            match(input,RULE_TAG_CLOSE,FOLLOW_2); 
             after(grammarAccess.getTagAccess().getTAG_CLOSETerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__0__Impl"


    // $ANTLR start "rule__Tag__Group_3_1__1"
    // InternalXmlParser.g:398:1: rule__Tag__Group_3_1__1 : rule__Tag__Group_3_1__1__Impl rule__Tag__Group_3_1__2 ;
    public final void rule__Tag__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:402:1: ( rule__Tag__Group_3_1__1__Impl rule__Tag__Group_3_1__2 )
            // InternalXmlParser.g:403:2: rule__Tag__Group_3_1__1__Impl rule__Tag__Group_3_1__2
            {
            pushFollow(FOLLOW_8);
            rule__Tag__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tag__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__1"


    // $ANTLR start "rule__Tag__Group_3_1__1__Impl"
    // InternalXmlParser.g:410:1: rule__Tag__Group_3_1__1__Impl : ( ( rule__Tag__ContentsAssignment_3_1_1 )* ) ;
    public final void rule__Tag__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:414:1: ( ( ( rule__Tag__ContentsAssignment_3_1_1 )* ) )
            // InternalXmlParser.g:415:1: ( ( rule__Tag__ContentsAssignment_3_1_1 )* )
            {
            // InternalXmlParser.g:415:1: ( ( rule__Tag__ContentsAssignment_3_1_1 )* )
            // InternalXmlParser.g:416:2: ( rule__Tag__ContentsAssignment_3_1_1 )*
            {
             before(grammarAccess.getTagAccess().getContentsAssignment_3_1_1()); 
            // InternalXmlParser.g:417:2: ( rule__Tag__ContentsAssignment_3_1_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_TAG_START_OPEN||LA5_0==RULE_PCDATA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalXmlParser.g:417:3: rule__Tag__ContentsAssignment_3_1_1
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Tag__ContentsAssignment_3_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getTagAccess().getContentsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__1__Impl"


    // $ANTLR start "rule__Tag__Group_3_1__2"
    // InternalXmlParser.g:425:1: rule__Tag__Group_3_1__2 : rule__Tag__Group_3_1__2__Impl rule__Tag__Group_3_1__3 ;
    public final void rule__Tag__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:429:1: ( rule__Tag__Group_3_1__2__Impl rule__Tag__Group_3_1__3 )
            // InternalXmlParser.g:430:2: rule__Tag__Group_3_1__2__Impl rule__Tag__Group_3_1__3
            {
            pushFollow(FOLLOW_5);
            rule__Tag__Group_3_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tag__Group_3_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__2"


    // $ANTLR start "rule__Tag__Group_3_1__2__Impl"
    // InternalXmlParser.g:437:1: rule__Tag__Group_3_1__2__Impl : ( RULE_TAG_END_OPEN ) ;
    public final void rule__Tag__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:441:1: ( ( RULE_TAG_END_OPEN ) )
            // InternalXmlParser.g:442:1: ( RULE_TAG_END_OPEN )
            {
            // InternalXmlParser.g:442:1: ( RULE_TAG_END_OPEN )
            // InternalXmlParser.g:443:2: RULE_TAG_END_OPEN
            {
             before(grammarAccess.getTagAccess().getTAG_END_OPENTerminalRuleCall_3_1_2()); 
            match(input,RULE_TAG_END_OPEN,FOLLOW_2); 
             after(grammarAccess.getTagAccess().getTAG_END_OPENTerminalRuleCall_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__2__Impl"


    // $ANTLR start "rule__Tag__Group_3_1__3"
    // InternalXmlParser.g:452:1: rule__Tag__Group_3_1__3 : rule__Tag__Group_3_1__3__Impl rule__Tag__Group_3_1__4 ;
    public final void rule__Tag__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:456:1: ( rule__Tag__Group_3_1__3__Impl rule__Tag__Group_3_1__4 )
            // InternalXmlParser.g:457:2: rule__Tag__Group_3_1__3__Impl rule__Tag__Group_3_1__4
            {
            pushFollow(FOLLOW_9);
            rule__Tag__Group_3_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Tag__Group_3_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__3"


    // $ANTLR start "rule__Tag__Group_3_1__3__Impl"
    // InternalXmlParser.g:464:1: rule__Tag__Group_3_1__3__Impl : ( ( rule__Tag__CloseNameAssignment_3_1_3 ) ) ;
    public final void rule__Tag__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:468:1: ( ( ( rule__Tag__CloseNameAssignment_3_1_3 ) ) )
            // InternalXmlParser.g:469:1: ( ( rule__Tag__CloseNameAssignment_3_1_3 ) )
            {
            // InternalXmlParser.g:469:1: ( ( rule__Tag__CloseNameAssignment_3_1_3 ) )
            // InternalXmlParser.g:470:2: ( rule__Tag__CloseNameAssignment_3_1_3 )
            {
             before(grammarAccess.getTagAccess().getCloseNameAssignment_3_1_3()); 
            // InternalXmlParser.g:471:2: ( rule__Tag__CloseNameAssignment_3_1_3 )
            // InternalXmlParser.g:471:3: rule__Tag__CloseNameAssignment_3_1_3
            {
            pushFollow(FOLLOW_2);
            rule__Tag__CloseNameAssignment_3_1_3();

            state._fsp--;


            }

             after(grammarAccess.getTagAccess().getCloseNameAssignment_3_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__3__Impl"


    // $ANTLR start "rule__Tag__Group_3_1__4"
    // InternalXmlParser.g:479:1: rule__Tag__Group_3_1__4 : rule__Tag__Group_3_1__4__Impl ;
    public final void rule__Tag__Group_3_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:483:1: ( rule__Tag__Group_3_1__4__Impl )
            // InternalXmlParser.g:484:2: rule__Tag__Group_3_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Tag__Group_3_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__4"


    // $ANTLR start "rule__Tag__Group_3_1__4__Impl"
    // InternalXmlParser.g:490:1: rule__Tag__Group_3_1__4__Impl : ( RULE_TAG_CLOSE ) ;
    public final void rule__Tag__Group_3_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:494:1: ( ( RULE_TAG_CLOSE ) )
            // InternalXmlParser.g:495:1: ( RULE_TAG_CLOSE )
            {
            // InternalXmlParser.g:495:1: ( RULE_TAG_CLOSE )
            // InternalXmlParser.g:496:2: RULE_TAG_CLOSE
            {
             before(grammarAccess.getTagAccess().getTAG_CLOSETerminalRuleCall_3_1_4()); 
            match(input,RULE_TAG_CLOSE,FOLLOW_2); 
             after(grammarAccess.getTagAccess().getTAG_CLOSETerminalRuleCall_3_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__Group_3_1__4__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalXmlParser.g:506:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:510:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalXmlParser.g:511:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalXmlParser.g:518:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:522:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // InternalXmlParser.g:523:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // InternalXmlParser.g:523:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // InternalXmlParser.g:524:2: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // InternalXmlParser.g:525:2: ( rule__Attribute__NameAssignment_0 )
            // InternalXmlParser.g:525:3: rule__Attribute__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalXmlParser.g:533:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:537:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalXmlParser.g:538:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalXmlParser.g:545:1: rule__Attribute__Group__1__Impl : ( RULE_ATTR_EQ ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:549:1: ( ( RULE_ATTR_EQ ) )
            // InternalXmlParser.g:550:1: ( RULE_ATTR_EQ )
            {
            // InternalXmlParser.g:550:1: ( RULE_ATTR_EQ )
            // InternalXmlParser.g:551:2: RULE_ATTR_EQ
            {
             before(grammarAccess.getAttributeAccess().getATTR_EQTerminalRuleCall_1()); 
            match(input,RULE_ATTR_EQ,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getATTR_EQTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalXmlParser.g:560:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:564:1: ( rule__Attribute__Group__2__Impl )
            // InternalXmlParser.g:565:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalXmlParser.g:571:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:575:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // InternalXmlParser.g:576:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // InternalXmlParser.g:576:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // InternalXmlParser.g:577:2: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // InternalXmlParser.g:578:2: ( rule__Attribute__ValueAssignment_2 )
            // InternalXmlParser.g:578:3: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__XmlDocument__ContentsAssignment_1"
    // InternalXmlParser.g:587:1: rule__XmlDocument__ContentsAssignment_1 : ( ruleContent ) ;
    public final void rule__XmlDocument__ContentsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:591:1: ( ( ruleContent ) )
            // InternalXmlParser.g:592:2: ( ruleContent )
            {
            // InternalXmlParser.g:592:2: ( ruleContent )
            // InternalXmlParser.g:593:3: ruleContent
            {
             before(grammarAccess.getXmlDocumentAccess().getContentsContentParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleContent();

            state._fsp--;

             after(grammarAccess.getXmlDocumentAccess().getContentsContentParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XmlDocument__ContentsAssignment_1"


    // $ANTLR start "rule__Content__TagAssignment_0"
    // InternalXmlParser.g:602:1: rule__Content__TagAssignment_0 : ( ruleTag ) ;
    public final void rule__Content__TagAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:606:1: ( ( ruleTag ) )
            // InternalXmlParser.g:607:2: ( ruleTag )
            {
            // InternalXmlParser.g:607:2: ( ruleTag )
            // InternalXmlParser.g:608:3: ruleTag
            {
             before(grammarAccess.getContentAccess().getTagTagParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTag();

            state._fsp--;

             after(grammarAccess.getContentAccess().getTagTagParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__TagAssignment_0"


    // $ANTLR start "rule__Content__TextAssignment_1"
    // InternalXmlParser.g:617:1: rule__Content__TextAssignment_1 : ( RULE_PCDATA ) ;
    public final void rule__Content__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:621:1: ( ( RULE_PCDATA ) )
            // InternalXmlParser.g:622:2: ( RULE_PCDATA )
            {
            // InternalXmlParser.g:622:2: ( RULE_PCDATA )
            // InternalXmlParser.g:623:3: RULE_PCDATA
            {
             before(grammarAccess.getContentAccess().getTextPCDATATerminalRuleCall_1_0()); 
            match(input,RULE_PCDATA,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getTextPCDATATerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__TextAssignment_1"


    // $ANTLR start "rule__Tag__NameAssignment_1"
    // InternalXmlParser.g:632:1: rule__Tag__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Tag__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:636:1: ( ( RULE_ID ) )
            // InternalXmlParser.g:637:2: ( RULE_ID )
            {
            // InternalXmlParser.g:637:2: ( RULE_ID )
            // InternalXmlParser.g:638:3: RULE_ID
            {
             before(grammarAccess.getTagAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTagAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__NameAssignment_1"


    // $ANTLR start "rule__Tag__AttributesAssignment_2"
    // InternalXmlParser.g:647:1: rule__Tag__AttributesAssignment_2 : ( ruleAttribute ) ;
    public final void rule__Tag__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:651:1: ( ( ruleAttribute ) )
            // InternalXmlParser.g:652:2: ( ruleAttribute )
            {
            // InternalXmlParser.g:652:2: ( ruleAttribute )
            // InternalXmlParser.g:653:3: ruleAttribute
            {
             before(grammarAccess.getTagAccess().getAttributesAttributeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getTagAccess().getAttributesAttributeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__AttributesAssignment_2"


    // $ANTLR start "rule__Tag__ContentsAssignment_3_1_1"
    // InternalXmlParser.g:662:1: rule__Tag__ContentsAssignment_3_1_1 : ( ruleContent ) ;
    public final void rule__Tag__ContentsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:666:1: ( ( ruleContent ) )
            // InternalXmlParser.g:667:2: ( ruleContent )
            {
            // InternalXmlParser.g:667:2: ( ruleContent )
            // InternalXmlParser.g:668:3: ruleContent
            {
             before(grammarAccess.getTagAccess().getContentsContentParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleContent();

            state._fsp--;

             after(grammarAccess.getTagAccess().getContentsContentParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__ContentsAssignment_3_1_1"


    // $ANTLR start "rule__Tag__CloseNameAssignment_3_1_3"
    // InternalXmlParser.g:677:1: rule__Tag__CloseNameAssignment_3_1_3 : ( RULE_ID ) ;
    public final void rule__Tag__CloseNameAssignment_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:681:1: ( ( RULE_ID ) )
            // InternalXmlParser.g:682:2: ( RULE_ID )
            {
            // InternalXmlParser.g:682:2: ( RULE_ID )
            // InternalXmlParser.g:683:3: RULE_ID
            {
             before(grammarAccess.getTagAccess().getCloseNameIDTerminalRuleCall_3_1_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTagAccess().getCloseNameIDTerminalRuleCall_3_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tag__CloseNameAssignment_3_1_3"


    // $ANTLR start "rule__Attribute__NameAssignment_0"
    // InternalXmlParser.g:692:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:696:1: ( ( RULE_ID ) )
            // InternalXmlParser.g:697:2: ( RULE_ID )
            {
            // InternalXmlParser.g:697:2: ( RULE_ID )
            // InternalXmlParser.g:698:3: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_0"


    // $ANTLR start "rule__Attribute__ValueAssignment_2"
    // InternalXmlParser.g:707:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:711:1: ( ( RULE_STRING ) )
            // InternalXmlParser.g:712:2: ( RULE_STRING )
            {
            // InternalXmlParser.g:712:2: ( RULE_STRING )
            // InternalXmlParser.g:713:3: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ValueAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000002C0L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000400L});

}