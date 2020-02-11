/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import static org.junit.Assert.*
import org.junit.Test
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.PartialClassExtractor

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class PartialClassExtractorTest {
	
	@Test
	def void testEnumRules() {
		assertSplitsTo(1, '''
		import org.eclipse.xtext.*;
		import org.eclipse.xtext.parser.*;
		import org.eclipse.xtext.parser.impl.*;
		import org.eclipse.xtext.IGrammarAccess;
		import org.eclipse.emf.common.util.Enumerator;
		import org.eclipse.emf.ecore.util.EcoreUtil;
		import org.eclipse.emf.ecore.EObject;
		import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
		import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
		import org.antlr.runtime.*;
		import java.util.Stack;
		import java.util.List;
		import java.util.ArrayList;
		
		public class InternalMyDslParser extends AbstractInternalAntlrParser {
		    public static final String[] tokenNames = new String[] {
		        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Hello'", "'!'"
		    };
		    // delegates
		    // delegators
		    
		    public InternalMyDslParser(TokenStream input) {
		        this(input, new RecognizerSharedState());
		    }
		    public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
		        super(input, state);
		         
		    }
		    @Override
		    protected String getFirstRuleName() {
		        return "Model";
		    }
		    @Override
		    protected IGrammarAccess getGrammarAccess() {
		        return null;
		    }
		    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
		    // $ANTLR start "ruleMySuperDuperObject"
		    public final EObject ruleMySuperDuperObject() throws RecognitionException {
		        ruleMySuperDuperEnum();
		        return null;
		    }
		    // $ANTLR end "ruleMySuperDuperObject"
		    
		    // $ANTLR start "ruleMySuperDuperEnum"
		    public final Enumerator ruleMySuperDuperEnum() throws RecognitionException {
		        return null;
		    }
		    // $ANTLR end "ruleMySuperDuperEnum"
		    
		    // $ANTLR start "ruleSuperDuperFragment"
		    // InternalMyDsl.g:17296:1: ruleSuperDuperFragment[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '{' ( ( (lv_parameters_1_0= ruleCallParameter ) ) otherlv_2= ';' )* otherlv_3= '}' ) ;
		    public final EObject ruleSuperDuperFragment(EObject in_current) throws RecognitionException {
		        return null;
		    }
		    // $ANTLR end "ruleSuperDuperFragment"
		    // Delegated rules
		}
		''', 
		'''
		import org.eclipse.xtext.*;
		import org.eclipse.xtext.parser.*;
		import org.eclipse.xtext.parser.impl.*;
		import org.eclipse.xtext.IGrammarAccess;
		import org.eclipse.emf.common.util.Enumerator;
		import org.eclipse.emf.ecore.util.EcoreUtil;
		import org.eclipse.emf.ecore.EObject;
		import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
		import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
		import org.antlr.runtime.*;
		import java.util.Stack;
		import java.util.List;
		import java.util.ArrayList;
		
		@SuppressWarnings("all")
		interface InternalMyDslParserSignatures {
		     EObject ruleMySuperDuperObject() throws RecognitionException;
		     Enumerator ruleMySuperDuperEnum() throws RecognitionException;
		     EObject ruleSuperDuperFragment(EObject in_current) throws RecognitionException;
		}
		
		@SuppressWarnings("all")
		abstract class InternalMyDslParser1 extends AbstractInternalAntlrParser implements InternalMyDslParserSignatures {
		
		        InternalMyDslParser1(TokenStream input) {
		            this(input, new RecognizerSharedState());
		        }
		
		        InternalMyDslParser1(TokenStream input, RecognizerSharedState state) {
		            super(input, state);
		        }
		
		    public static final String[] tokenNames = new String[] {
		        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Hello'", "'!'"
		    };
		
		    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
		
		    // Delegated rules
		}
		
		
		@SuppressWarnings("all")
		abstract class InternalMyDslParser2 extends InternalMyDslParser1 {
		
		        InternalMyDslParser2(TokenStream input) {
		            this(input, new RecognizerSharedState());
		        }
		
		        InternalMyDslParser2(TokenStream input, RecognizerSharedState state) {
		            super(input, state);
		        }
		
		    // $ANTLR start "ruleMySuperDuperObject"
		    public final EObject ruleMySuperDuperObject() throws RecognitionException {
		        ruleMySuperDuperEnum();
		        return null;
		    }
		    // $ANTLR end "ruleMySuperDuperObject"
		
		}
		
		@SuppressWarnings("all")
		abstract class InternalMyDslParser3 extends InternalMyDslParser2 {
		
		        InternalMyDslParser3(TokenStream input) {
		            this(input, new RecognizerSharedState());
		        }
		
		        InternalMyDslParser3(TokenStream input, RecognizerSharedState state) {
		            super(input, state);
		        }
		
		    // $ANTLR start "ruleMySuperDuperEnum"
		    public final Enumerator ruleMySuperDuperEnum() throws RecognitionException {
		        return null;
		    }
		    // $ANTLR end "ruleMySuperDuperEnum"
		
		}
		
		@SuppressWarnings("all")
		abstract class InternalMyDslParser4 extends InternalMyDslParser3 {
		
		        InternalMyDslParser4(TokenStream input) {
		            this(input, new RecognizerSharedState());
		        }
		
		        InternalMyDslParser4(TokenStream input, RecognizerSharedState state) {
		            super(input, state);
		        }
		
		    // $ANTLR start "ruleSuperDuperFragment"
		    // InternalMyDsl.g:17296:1: ruleSuperDuperFragment[EObject in_current] returns [EObject current=in_current] : (otherlv_0= '{' ( ( (lv_parameters_1_0= ruleCallParameter ) ) otherlv_2= ';' )* otherlv_3= '}' ) ;
		    public final EObject ruleSuperDuperFragment(EObject in_current) throws RecognitionException {
		        return null;
		    }
		    // $ANTLR end "ruleSuperDuperFragment"
		
		}
		
		public class InternalMyDslParser extends InternalMyDslParser4 {
		
		    
		    public InternalMyDslParser(TokenStream input) {
		        this(input, new RecognizerSharedState());
		    }
		    public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
		        super(input, state);
		         
		    }
		    @Override
		    protected String getFirstRuleName() {
		        return "Model";
		    }
		    @Override
		    protected IGrammarAccess getGrammarAccess() {
		        return null;
		    }
		
		}
		''')
	}
	
	protected def assertSplitsTo(int methodsPerClass, String from, String to) {
		assertEquals(to, new PartialClassExtractor(from, methodsPerClass).transform)
	}
	
}