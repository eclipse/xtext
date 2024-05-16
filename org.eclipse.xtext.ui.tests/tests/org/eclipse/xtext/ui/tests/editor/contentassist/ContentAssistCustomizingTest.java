/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.testing.util.ResourceLoadHelper;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistCustomizingTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.ContentAssistCustomizingTestLanguageUiModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.ContentAssistCustomizingTestLanguageProposalProvider;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class ContentAssistCustomizingTest extends AbstractXtextTests implements ResourceLoadHelper {
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		with(getSetup());
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}

	public static class TestableProposalProvider extends ContentAssistCustomizingTestLanguageProposalProvider {
		
		@Inject
		ContentAssistCustomizingTest test;
		
		@Override
		public void completeModel_Types(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.completeModel_Types(model, assignment, context, acceptor);
			test.completeModel_Types++;
		}
		@Override
		public void completeType_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.completeType_Name(model, assignment, context, acceptor);
			test.completeType_Name++;
		}
		@Override
		public void completeType_SuperType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.completeType_SuperType(model, assignment, context, acceptor);
			test.completeType_SuperType++;
		}
		@Override
		public void completeTypeRef_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.completeTypeRef_Type(model, assignment, context, acceptor);
			test.completeTypeRef_Type++;
		}
	    
		@Override
		public void complete_Model(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.complete_Model(model, ruleCall, context, acceptor);
			test.complete_Model++;
		}
		@Override
		public void complete_Type(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.complete_Type(model, ruleCall, context, acceptor);
			test.complete_Type++;
		}
		@Override
		public void complete_TypeRef(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.complete_TypeRef(model, ruleCall, context, acceptor);
			test.complete_TypeRef++;
		}
		@Override
		public void complete_FQN(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			super.complete_FQN(model, ruleCall, context, acceptor);
			test.complete_FQN++;
		}
	}
	
	public static class TestableTemplateProposalProvider extends DefaultTemplateProposalProvider {

		@Inject
		ContentAssistCustomizingTest test;
		
		@Inject
		public TestableTemplateProposalProvider(TemplateStore templateStore, ContextTypeRegistry registry, ContextTypeIdHelper helper) {
			super(templateStore, registry, helper);
		}
	
		@Override
		protected IFollowElementAcceptor createFollowElementAcceptor(final Collection<TemplateContextType> result) {
			return new TestableFollowElementAcceptor(result);
		}
		
		public class TestableFollowElementAcceptor extends FollowElementAcceptor {

			public TestableFollowElementAcceptor(Collection<TemplateContextType> result) {
				super(result);
			}
			
			@Override
			protected void addContextType(Keyword keyword) {
				super.addContextType(keyword);
				test.keywords.add(keyword.getValue());
			}
			
			@Override
			protected void addContextType(ParserRule rule) {
				super.addContextType(rule);
				test.parserRules.add(rule);
			}
			
		}
	}
	
	private int completeModel_Types;
	private int completeType_Name;
	private int completeType_SuperType;
	private int completeTypeRef_Type;
	private int complete_Model;
	private int complete_Type;
	private int complete_TypeRef;
	private int complete_FQN;
	
	private Set<ParserRule> parserRules;
	private Set<String> keywords;
	
	protected ISetup getSetup() {
		return doGetSetup();
	}
	
	public ISetup doGetSetup() {
		return new ContentAssistCustomizingTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new ContentAssistCustomizingTestLanguageRuntimeModule(),
						new ContentAssistCustomizingTestLanguageUiModule(TestsActivator.getInstance()) {
							@Override
							public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
								return TestableProposalProvider.class;
							}
							@SuppressWarnings("unused")
							public ContentAssistCustomizingTest bindTestClass() {
								return ContentAssistCustomizingTest.this;
							}
							@Override
							public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
								return TestableTemplateProposalProvider.class;
							}
						}, new SharedStateModule()));
			}
		};
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		complete_FQN = 0;
		complete_Model = 0;
		complete_Type = 0;
		complete_TypeRef = 0;
		
		completeModel_Types = 0;
		completeType_Name = 0;
		completeType_SuperType = 0;
		completeTypeRef_Type = 0;
		
		parserRules = Sets.newHashSet();
		keywords = Sets.newHashSet();
	}
	
	@Override
	public void tearDown() throws Exception {
		parserRules = null;
		keywords = null;
		super.tearDown();
	}
	
	@Override
	protected ContentAssistCustomizingTestLanguageGrammarAccess getGrammarAccess() {
		return (ContentAssistCustomizingTestLanguageGrammarAccess) super.getGrammarAccess();
	}
	
	@Test public void testEmptyModel_01() throws Exception {
		newBuilder().assertCount(1);
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(2, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);
		
		assertEquals(parserRules.toString(), 3, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getModelRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getFQNRule()));
		
		assertEquals(keywords.toString(), 1, keywords.size());
	}
	
	@Test public void testEmptyModel_02() throws Exception {
		newBuilder().append("/* comment */").assertCount(1);
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(2, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);
		
		assertEquals(parserRules.toString(), 3, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getModelRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getFQNRule()));
		
		assertEquals(keywords.toString(), 1, keywords.size());
	}
	
	@Test public void testFirstEntityName_01() throws Exception {
		newBuilder().append("name").assertText(";");
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(2, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);
		
		assertEquals(keywords.toString(), 3, keywords.size());
		assertTrue(keywords.contains(";"));
		assertTrue(keywords.contains("extends"));
		
		assertEquals(parserRules.toString(), 3, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getModelRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getFQNRule()));
	}
	
	@Test public void testFirstEntityName_02() throws Exception {
		newBuilder().append("/* comment */ name").assertText(";");
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(2, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);
		
		assertEquals(keywords.toString(), 3, keywords.size());
		assertTrue(keywords.contains(";"));
		assertTrue(keywords.contains("extends"));
		
		assertEquals(parserRules.toString(), 3, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getModelRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getFQNRule()));
	}
	
	@Test public void testFirstEntityExtends_02() throws Exception {
		newBuilder().append("/* comment */ name ").assertText(";", "extends");
		assertEquals(0, complete_Model);
		assertEquals(0, complete_Type);
		assertEquals(0, complete_FQN);
		assertEquals(0, completeModel_Types);
		assertEquals(0, completeType_Name);
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);
		
		assertEquals(keywords.toString(), 2, keywords.size());
		assertTrue(keywords.contains(";"));
		assertTrue(keywords.contains("extends"));
		
		assertTrue(parserRules.isEmpty());
	}
	
	@Test public void testFirstSuperType_01() throws Exception {
		newBuilder().append("name extends").assertText("extends");
		assertEquals(1, complete_TypeRef);
		assertEquals(1, completeType_SuperType);
		assertEquals(1, completeTypeRef_Type);
		
		assertEquals(0, complete_Model);
		assertEquals(0, complete_Type);
		assertEquals(0, completeModel_Types);
		assertEquals(0, completeType_Name);
		assertEquals(0, complete_FQN);
		
		assertEquals(keywords.toString(), 2, keywords.size());
		assertTrue(keywords.contains(";"));
		assertTrue(keywords.contains("extends"));
		
		assertEquals(parserRules.toString(), 1, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRefRule()));
	}
	
	@Test public void testFirstSuperType_02() throws Exception {
		newBuilder().append("name extends ").assertText("name");
		assertEquals(1, complete_TypeRef);
		assertEquals(1, completeType_SuperType);
		assertEquals(1, completeTypeRef_Type);		

		assertEquals(0, complete_FQN);
		assertEquals(0, complete_Model);
		assertEquals(0, complete_Type);
		assertEquals(0, completeModel_Types);
		assertEquals(0, completeType_Name);
	}
	
	@Test public void testFirstSuperType_03() throws Exception {
		newBuilder().append("/* comment */ name extends name").assertText("name", ";");
		assertEquals(1, complete_TypeRef);
		assertEquals(1, completeType_SuperType);
		assertEquals(1, completeTypeRef_Type);		

		assertEquals(0, complete_FQN);
		assertEquals(0, complete_Model);
		assertEquals(0, complete_Type);
		assertEquals(0, completeModel_Types);
		assertEquals(0, completeType_Name);
	}
	
	@Test public void testSecondEntityName_01() throws Exception {
		newBuilder().append("name;").assertText(";","FQN");
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(2, completeType_Name);
		
		assertEquals(0, complete_Model);
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);
		
		assertEquals(keywords.toString(), 3, keywords.size());
		assertTrue(keywords.contains(";"));
		assertTrue(keywords.contains("extends"));
		assertTrue(keywords.contains("FQN"));
		
		assertEquals(parserRules.toString(), 2, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getFQNRule()));
	}
	
	@Test public void testSecondEntityName_02() throws Exception {
		newBuilder().append("name; /* comment */").assertCount(1);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(2, completeType_Name);
		
		assertEquals(0, complete_Model);
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);	
		
		assertEquals(1, keywords.size());
		assertTrue(keywords.contains("FQN"));
		
		assertEquals(parserRules.toString(), 2, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getFQNRule()));
	}

	@Test public void testAfterDot() throws Exception {
		newBuilder().append("name.").assertText();
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(2, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);
		
		assertEquals(1, keywords.size());
		
		assertEquals(parserRules.toString(), 3, parserRules.size());
		assertTrue(parserRules.contains(getGrammarAccess().getModelRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getTypeRule()));
		assertTrue(parserRules.contains(getGrammarAccess().getFQNRule()));
	}
}
