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
    // InternalXmlParser.g:55:1: entryRuleXmlDocument : ruleXmlDocument EOF ;
    public final void entryRuleXmlDocument() throws RecognitionException {
        try {
            // InternalXmlParser.g:56:1: ( ruleXmlDocument EOF )
            // InternalXmlParser.g:57:1: ruleXmlDocument EOF
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
    // InternalXmlParser.g:64:1: ruleXmlDocument : ( ( rule__XmlDocument__Group__0 ) ) ;
    public final void ruleXmlDocument() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:68:2: ( ( ( rule__XmlDocument__Group__0 ) ) )
            // InternalXmlParser.g:69:2: ( ( rule__XmlDocument__Group__0 ) )
            {
            // InternalXmlParser.g:69:2: ( ( rule__XmlDocument__Group__0 ) )
            // InternalXmlParser.g:70:3: ( rule__XmlDocument__Group__0 )
            {
             before(grammarAccess.getXmlDocumentAccess().getGroup()); 
            // InternalXmlParser.g:71:3: ( rule__XmlDocument__Group__0 )
            // InternalXmlParser.g:71:4: rule__XmlDocument__Group__0
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
    // InternalXmlParser.g:80:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // InternalXmlParser.g:81:1: ( ruleContent EOF )
            // InternalXmlParser.g:82:1: ruleContent EOF
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
    // InternalXmlParser.g:89:1: ruleContent : ( ( rule__Content__Alternatives ) ) ;
    public final void ruleContent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:93:2: ( ( ( rule__Content__Alternatives ) ) )
            // InternalXmlParser.g:94:2: ( ( rule__Content__Alternatives ) )
            {
            // InternalXmlParser.g:94:2: ( ( rule__Content__Alternatives ) )
            // InternalXmlParser.g:95:3: ( rule__Content__Alternatives )
            {
             before(grammarAccess.getContentAccess().getAlternatives()); 
            // InternalXmlParser.g:96:3: ( rule__Content__Alternatives )
            // InternalXmlParser.g:96:4: rule__Content__Alternatives
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
    // InternalXmlParser.g:105:1: entryRuleTag : ruleTag EOF ;
    public final void entryRuleTag() throws RecognitionException {
         
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // InternalXmlParser.g:109:1: ( ruleTag EOF )
            // InternalXmlParser.g:110:1: ruleTag EOF
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
    // InternalXmlParser.g:120:1: ruleTag : ( ( rule__Tag__Group__0 ) ) ;
    public final void ruleTag() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:125:2: ( ( ( rule__Tag__Group__0 ) ) )
            // InternalXmlParser.g:126:2: ( ( rule__Tag__Group__0 ) )
            {
            // InternalXmlParser.g:126:2: ( ( rule__Tag__Group__0 ) )
            // InternalXmlParser.g:127:3: ( rule__Tag__Group__0 )
            {
             before(grammarAccess.getTagAccess().getGroup()); 
            // InternalXmlParser.g:128:3: ( rule__Tag__Group__0 )
            // InternalXmlParser.g:128:4: rule__Tag__Group__0
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
    // InternalXmlParser.g:138:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalXmlParser.g:139:1: ( ruleAttribute EOF )
            // InternalXmlParser.g:140:1: ruleAttribute EOF
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
    // InternalXmlParser.g:147:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:151:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalXmlParser.g:152:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalXmlParser.g:152:2: ( ( rule__Attribute__Group__0 ) )
            // InternalXmlParser.g:153:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalXmlParser.g:154:3: ( rule__Attribute__Group__0 )
            // InternalXmlParser.g:154:4: rule__Attribute__Group__0
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
    // InternalXmlParser.g:162:1: rule__Content__Alternatives : ( ( ( rule__Content__TagAssignment_0 ) ) | ( ( rule__Content__TextAssignment_1 ) ) );
    public final void rule__Content__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:166:1: ( ( ( rule__Content__TagAssignment_0 ) ) | ( ( rule__Content__TextAssignment_1 ) ) )
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
                    // InternalXmlParser.g:167:2: ( ( rule__Content__TagAssignment_0 ) )
                    {
                    // InternalXmlParser.g:167:2: ( ( rule__Content__TagAssignment_0 ) )
                    // InternalXmlParser.g:168:3: ( rule__Content__TagAssignment_0 )
                    {
                     before(grammarAccess.getContentAccess().getTagAssignment_0()); 
                    // InternalXmlParser.g:169:3: ( rule__Content__TagAssignment_0 )
                    // InternalXmlParser.g:169:4: rule__Content__TagAssignment_0
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
                    // InternalXmlParser.g:173:2: ( ( rule__Content__TextAssignment_1 ) )
                    {
                    // InternalXmlParser.g:173:2: ( ( rule__Content__TextAssignment_1 ) )
                    // InternalXmlParser.g:174:3: ( rule__Content__TextAssignment_1 )
                    {
                     before(grammarAccess.getContentAccess().getTextAssignment_1()); 
                    // InternalXmlParser.g:175:3: ( rule__Content__TextAssignment_1 )
                    // InternalXmlParser.g:175:4: rule__Content__TextAssignment_1
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
    // InternalXmlParser.g:183:1: rule__Tag__Alternatives_3 : ( ( RULE_TAG_EMPTY_CLOSE ) | ( ( rule__Tag__Group_3_1__0 ) ) );
    public final void rule__Tag__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:187:1: ( ( RULE_TAG_EMPTY_CLOSE ) | ( ( rule__Tag__Group_3_1__0 ) ) )
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
                    // InternalXmlParser.g:188:2: ( RULE_TAG_EMPTY_CLOSE )
                    {
                    // InternalXmlParser.g:188:2: ( RULE_TAG_EMPTY_CLOSE )
                    // InternalXmlParser.g:189:3: RULE_TAG_EMPTY_CLOSE
                    {
                     before(grammarAccess.getTagAccess().getTAG_EMPTY_CLOSETerminalRuleCall_3_0()); 
                    match(input,RULE_TAG_EMPTY_CLOSE,FOLLOW_2); 
                     after(grammarAccess.getTagAccess().getTAG_EMPTY_CLOSETerminalRuleCall_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXmlParser.g:194:2: ( ( rule__Tag__Group_3_1__0 ) )
                    {
                    // InternalXmlParser.g:194:2: ( ( rule__Tag__Group_3_1__0 ) )
                    // InternalXmlParser.g:195:3: ( rule__Tag__Group_3_1__0 )
                    {
                     before(grammarAccess.getTagAccess().getGroup_3_1()); 
                    // InternalXmlParser.g:196:3: ( rule__Tag__Group_3_1__0 )
                    // InternalXmlParser.g:196:4: rule__Tag__Group_3_1__0
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
    // InternalXmlParser.g:204:1: rule__XmlDocument__Group__0 : rule__XmlDocument__Group__0__Impl rule__XmlDocument__Group__1 ;
    public final void rule__XmlDocument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:208:1: ( rule__XmlDocument__Group__0__Impl rule__XmlDocument__Group__1 )
            // InternalXmlParser.g:209:2: rule__XmlDocument__Group__0__Impl rule__XmlDocument__Group__1
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
    // InternalXmlParser.g:216:1: rule__XmlDocument__Group__0__Impl : ( () ) ;
    public final void rule__XmlDocument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:220:1: ( ( () ) )
            // InternalXmlParser.g:221:1: ( () )
            {
            // InternalXmlParser.g:221:1: ( () )
            // InternalXmlParser.g:222:2: ()
            {
             before(grammarAccess.getXmlDocumentAccess().getXmlDocumentAction_0()); 
            // InternalXmlParser.g:223:2: ()
            // InternalXmlParser.g:223:3: 
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
    // InternalXmlParser.g:231:1: rule__XmlDocument__Group__1 : rule__XmlDocument__Group__1__Impl ;
    public final void rule__XmlDocument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:235:1: ( rule__XmlDocument__Group__1__Impl )
            // InternalXmlParser.g:236:2: rule__XmlDocument__Group__1__Impl
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
    // InternalXmlParser.g:242:1: rule__XmlDocument__Group__1__Impl : ( ( rule__XmlDocument__ContentsAssignment_1 )* ) ;
    public final void rule__XmlDocument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:246:1: ( ( ( rule__XmlDocument__ContentsAssignment_1 )* ) )
            // InternalXmlParser.g:247:1: ( ( rule__XmlDocument__ContentsAssignment_1 )* )
            {
            // InternalXmlParser.g:247:1: ( ( rule__XmlDocument__ContentsAssignment_1 )* )
            // InternalXmlParser.g:248:2: ( rule__XmlDocument__ContentsAssignment_1 )*
            {
             before(grammarAccess.getXmlDocumentAccess().getContentsAssignment_1()); 
            // InternalXmlParser.g:249:2: ( rule__XmlDocument__ContentsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_TAG_START_OPEN||LA3_0==RULE_PCDATA) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalXmlParser.g:249:3: rule__XmlDocument__ContentsAssignment_1
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
    // InternalXmlParser.g:258:1: rule__Tag__Group__0 : rule__Tag__Group__0__Impl rule__Tag__Group__1 ;
    public final void rule__Tag__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:262:1: ( rule__Tag__Group__0__Impl rule__Tag__Group__1 )
            // InternalXmlParser.g:263:2: rule__Tag__Group__0__Impl rule__Tag__Group__1
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
    // InternalXmlParser.g:270:1: rule__Tag__Group__0__Impl : ( RULE_TAG_START_OPEN ) ;
    public final void rule__Tag__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:274:1: ( ( RULE_TAG_START_OPEN ) )
            // InternalXmlParser.g:275:1: ( RULE_TAG_START_OPEN )
            {
            // InternalXmlParser.g:275:1: ( RULE_TAG_START_OPEN )
            // InternalXmlParser.g:276:2: RULE_TAG_START_OPEN
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
    // InternalXmlParser.g:285:1: rule__Tag__Group__1 : rule__Tag__Group__1__Impl rule__Tag__Group__2 ;
    public final void rule__Tag__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:289:1: ( rule__Tag__Group__1__Impl rule__Tag__Group__2 )
            // InternalXmlParser.g:290:2: rule__Tag__Group__1__Impl rule__Tag__Group__2
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
    // InternalXmlParser.g:297:1: rule__Tag__Group__1__Impl : ( ( rule__Tag__NameAssignment_1 ) ) ;
    public final void rule__Tag__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:301:1: ( ( ( rule__Tag__NameAssignment_1 ) ) )
            // InternalXmlParser.g:302:1: ( ( rule__Tag__NameAssignment_1 ) )
            {
            // InternalXmlParser.g:302:1: ( ( rule__Tag__NameAssignment_1 ) )
            // InternalXmlParser.g:303:2: ( rule__Tag__NameAssignment_1 )
            {
             before(grammarAccess.getTagAccess().getNameAssignment_1()); 
            // InternalXmlParser.g:304:2: ( rule__Tag__NameAssignment_1 )
            // InternalXmlParser.g:304:3: rule__Tag__NameAssignment_1
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
    // InternalXmlParser.g:312:1: rule__Tag__Group__2 : rule__Tag__Group__2__Impl rule__Tag__Group__3 ;
    public final void rule__Tag__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:316:1: ( rule__Tag__Group__2__Impl rule__Tag__Group__3 )
            // InternalXmlParser.g:317:2: rule__Tag__Group__2__Impl rule__Tag__Group__3
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
    // InternalXmlParser.g:324:1: rule__Tag__Group__2__Impl : ( ( rule__Tag__AttributesAssignment_2 )* ) ;
    public final void rule__Tag__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:328:1: ( ( ( rule__Tag__AttributesAssignment_2 )* ) )
            // InternalXmlParser.g:329:1: ( ( rule__Tag__AttributesAssignment_2 )* )
            {
            // InternalXmlParser.g:329:1: ( ( rule__Tag__AttributesAssignment_2 )* )
            // InternalXmlParser.g:330:2: ( rule__Tag__AttributesAssignment_2 )*
            {
             before(grammarAccess.getTagAccess().getAttributesAssignment_2()); 
            // InternalXmlParser.g:331:2: ( rule__Tag__AttributesAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalXmlParser.g:331:3: rule__Tag__AttributesAssignment_2
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
    // InternalXmlParser.g:339:1: rule__Tag__Group__3 : rule__Tag__Group__3__Impl ;
    public final void rule__Tag__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:343:1: ( rule__Tag__Group__3__Impl )
            // InternalXmlParser.g:344:2: rule__Tag__Group__3__Impl
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
    // InternalXmlParser.g:350:1: rule__Tag__Group__3__Impl : ( ( rule__Tag__Alternatives_3 ) ) ;
    public final void rule__Tag__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:354:1: ( ( ( rule__Tag__Alternatives_3 ) ) )
            // InternalXmlParser.g:355:1: ( ( rule__Tag__Alternatives_3 ) )
            {
            // InternalXmlParser.g:355:1: ( ( rule__Tag__Alternatives_3 ) )
            // InternalXmlParser.g:356:2: ( rule__Tag__Alternatives_3 )
            {
             before(grammarAccess.getTagAccess().getAlternatives_3()); 
            // InternalXmlParser.g:357:2: ( rule__Tag__Alternatives_3 )
            // InternalXmlParser.g:357:3: rule__Tag__Alternatives_3
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
    // InternalXmlParser.g:366:1: rule__Tag__Group_3_1__0 : rule__Tag__Group_3_1__0__Impl rule__Tag__Group_3_1__1 ;
    public final void rule__Tag__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:370:1: ( rule__Tag__Group_3_1__0__Impl rule__Tag__Group_3_1__1 )
            // InternalXmlParser.g:371:2: rule__Tag__Group_3_1__0__Impl rule__Tag__Group_3_1__1
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
    // InternalXmlParser.g:378:1: rule__Tag__Group_3_1__0__Impl : ( RULE_TAG_CLOSE ) ;
    public final void rule__Tag__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:382:1: ( ( RULE_TAG_CLOSE ) )
            // InternalXmlParser.g:383:1: ( RULE_TAG_CLOSE )
            {
            // InternalXmlParser.g:383:1: ( RULE_TAG_CLOSE )
            // InternalXmlParser.g:384:2: RULE_TAG_CLOSE
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
    // InternalXmlParser.g:393:1: rule__Tag__Group_3_1__1 : rule__Tag__Group_3_1__1__Impl rule__Tag__Group_3_1__2 ;
    public final void rule__Tag__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:397:1: ( rule__Tag__Group_3_1__1__Impl rule__Tag__Group_3_1__2 )
            // InternalXmlParser.g:398:2: rule__Tag__Group_3_1__1__Impl rule__Tag__Group_3_1__2
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
    // InternalXmlParser.g:405:1: rule__Tag__Group_3_1__1__Impl : ( ( rule__Tag__ContentsAssignment_3_1_1 )* ) ;
    public final void rule__Tag__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:409:1: ( ( ( rule__Tag__ContentsAssignment_3_1_1 )* ) )
            // InternalXmlParser.g:410:1: ( ( rule__Tag__ContentsAssignment_3_1_1 )* )
            {
            // InternalXmlParser.g:410:1: ( ( rule__Tag__ContentsAssignment_3_1_1 )* )
            // InternalXmlParser.g:411:2: ( rule__Tag__ContentsAssignment_3_1_1 )*
            {
             before(grammarAccess.getTagAccess().getContentsAssignment_3_1_1()); 
            // InternalXmlParser.g:412:2: ( rule__Tag__ContentsAssignment_3_1_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_TAG_START_OPEN||LA5_0==RULE_PCDATA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalXmlParser.g:412:3: rule__Tag__ContentsAssignment_3_1_1
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
    // InternalXmlParser.g:420:1: rule__Tag__Group_3_1__2 : rule__Tag__Group_3_1__2__Impl rule__Tag__Group_3_1__3 ;
    public final void rule__Tag__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:424:1: ( rule__Tag__Group_3_1__2__Impl rule__Tag__Group_3_1__3 )
            // InternalXmlParser.g:425:2: rule__Tag__Group_3_1__2__Impl rule__Tag__Group_3_1__3
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
    // InternalXmlParser.g:432:1: rule__Tag__Group_3_1__2__Impl : ( RULE_TAG_END_OPEN ) ;
    public final void rule__Tag__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:436:1: ( ( RULE_TAG_END_OPEN ) )
            // InternalXmlParser.g:437:1: ( RULE_TAG_END_OPEN )
            {
            // InternalXmlParser.g:437:1: ( RULE_TAG_END_OPEN )
            // InternalXmlParser.g:438:2: RULE_TAG_END_OPEN
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
    // InternalXmlParser.g:447:1: rule__Tag__Group_3_1__3 : rule__Tag__Group_3_1__3__Impl rule__Tag__Group_3_1__4 ;
    public final void rule__Tag__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:451:1: ( rule__Tag__Group_3_1__3__Impl rule__Tag__Group_3_1__4 )
            // InternalXmlParser.g:452:2: rule__Tag__Group_3_1__3__Impl rule__Tag__Group_3_1__4
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
    // InternalXmlParser.g:459:1: rule__Tag__Group_3_1__3__Impl : ( ( rule__Tag__CloseNameAssignment_3_1_3 ) ) ;
    public final void rule__Tag__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:463:1: ( ( ( rule__Tag__CloseNameAssignment_3_1_3 ) ) )
            // InternalXmlParser.g:464:1: ( ( rule__Tag__CloseNameAssignment_3_1_3 ) )
            {
            // InternalXmlParser.g:464:1: ( ( rule__Tag__CloseNameAssignment_3_1_3 ) )
            // InternalXmlParser.g:465:2: ( rule__Tag__CloseNameAssignment_3_1_3 )
            {
             before(grammarAccess.getTagAccess().getCloseNameAssignment_3_1_3()); 
            // InternalXmlParser.g:466:2: ( rule__Tag__CloseNameAssignment_3_1_3 )
            // InternalXmlParser.g:466:3: rule__Tag__CloseNameAssignment_3_1_3
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
    // InternalXmlParser.g:474:1: rule__Tag__Group_3_1__4 : rule__Tag__Group_3_1__4__Impl ;
    public final void rule__Tag__Group_3_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:478:1: ( rule__Tag__Group_3_1__4__Impl )
            // InternalXmlParser.g:479:2: rule__Tag__Group_3_1__4__Impl
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
    // InternalXmlParser.g:485:1: rule__Tag__Group_3_1__4__Impl : ( RULE_TAG_CLOSE ) ;
    public final void rule__Tag__Group_3_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:489:1: ( ( RULE_TAG_CLOSE ) )
            // InternalXmlParser.g:490:1: ( RULE_TAG_CLOSE )
            {
            // InternalXmlParser.g:490:1: ( RULE_TAG_CLOSE )
            // InternalXmlParser.g:491:2: RULE_TAG_CLOSE
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
    // InternalXmlParser.g:501:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:505:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalXmlParser.g:506:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
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
    // InternalXmlParser.g:513:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:517:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // InternalXmlParser.g:518:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // InternalXmlParser.g:518:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // InternalXmlParser.g:519:2: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // InternalXmlParser.g:520:2: ( rule__Attribute__NameAssignment_0 )
            // InternalXmlParser.g:520:3: rule__Attribute__NameAssignment_0
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
    // InternalXmlParser.g:528:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:532:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalXmlParser.g:533:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
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
    // InternalXmlParser.g:540:1: rule__Attribute__Group__1__Impl : ( RULE_ATTR_EQ ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:544:1: ( ( RULE_ATTR_EQ ) )
            // InternalXmlParser.g:545:1: ( RULE_ATTR_EQ )
            {
            // InternalXmlParser.g:545:1: ( RULE_ATTR_EQ )
            // InternalXmlParser.g:546:2: RULE_ATTR_EQ
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
    // InternalXmlParser.g:555:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:559:1: ( rule__Attribute__Group__2__Impl )
            // InternalXmlParser.g:560:2: rule__Attribute__Group__2__Impl
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
    // InternalXmlParser.g:566:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:570:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // InternalXmlParser.g:571:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // InternalXmlParser.g:571:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // InternalXmlParser.g:572:2: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // InternalXmlParser.g:573:2: ( rule__Attribute__ValueAssignment_2 )
            // InternalXmlParser.g:573:3: rule__Attribute__ValueAssignment_2
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
    // InternalXmlParser.g:582:1: rule__XmlDocument__ContentsAssignment_1 : ( ruleContent ) ;
    public final void rule__XmlDocument__ContentsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:586:1: ( ( ruleContent ) )
            // InternalXmlParser.g:587:2: ( ruleContent )
            {
            // InternalXmlParser.g:587:2: ( ruleContent )
            // InternalXmlParser.g:588:3: ruleContent
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
    // InternalXmlParser.g:597:1: rule__Content__TagAssignment_0 : ( ruleTag ) ;
    public final void rule__Content__TagAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:601:1: ( ( ruleTag ) )
            // InternalXmlParser.g:602:2: ( ruleTag )
            {
            // InternalXmlParser.g:602:2: ( ruleTag )
            // InternalXmlParser.g:603:3: ruleTag
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
    // InternalXmlParser.g:612:1: rule__Content__TextAssignment_1 : ( RULE_PCDATA ) ;
    public final void rule__Content__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:616:1: ( ( RULE_PCDATA ) )
            // InternalXmlParser.g:617:2: ( RULE_PCDATA )
            {
            // InternalXmlParser.g:617:2: ( RULE_PCDATA )
            // InternalXmlParser.g:618:3: RULE_PCDATA
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
    // InternalXmlParser.g:627:1: rule__Tag__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Tag__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:631:1: ( ( RULE_ID ) )
            // InternalXmlParser.g:632:2: ( RULE_ID )
            {
            // InternalXmlParser.g:632:2: ( RULE_ID )
            // InternalXmlParser.g:633:3: RULE_ID
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
    // InternalXmlParser.g:642:1: rule__Tag__AttributesAssignment_2 : ( ruleAttribute ) ;
    public final void rule__Tag__AttributesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:646:1: ( ( ruleAttribute ) )
            // InternalXmlParser.g:647:2: ( ruleAttribute )
            {
            // InternalXmlParser.g:647:2: ( ruleAttribute )
            // InternalXmlParser.g:648:3: ruleAttribute
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
    // InternalXmlParser.g:657:1: rule__Tag__ContentsAssignment_3_1_1 : ( ruleContent ) ;
    public final void rule__Tag__ContentsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:661:1: ( ( ruleContent ) )
            // InternalXmlParser.g:662:2: ( ruleContent )
            {
            // InternalXmlParser.g:662:2: ( ruleContent )
            // InternalXmlParser.g:663:3: ruleContent
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
    // InternalXmlParser.g:672:1: rule__Tag__CloseNameAssignment_3_1_3 : ( RULE_ID ) ;
    public final void rule__Tag__CloseNameAssignment_3_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:676:1: ( ( RULE_ID ) )
            // InternalXmlParser.g:677:2: ( RULE_ID )
            {
            // InternalXmlParser.g:677:2: ( RULE_ID )
            // InternalXmlParser.g:678:3: RULE_ID
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
    // InternalXmlParser.g:687:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:691:1: ( ( RULE_ID ) )
            // InternalXmlParser.g:692:2: ( RULE_ID )
            {
            // InternalXmlParser.g:692:2: ( RULE_ID )
            // InternalXmlParser.g:693:3: RULE_ID
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
    // InternalXmlParser.g:702:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXmlParser.g:706:1: ( ( RULE_STRING ) )
            // InternalXmlParser.g:707:2: ( RULE_STRING )
            {
            // InternalXmlParser.g:707:2: ( RULE_STRING )
            // InternalXmlParser.g:708:3: RULE_STRING
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