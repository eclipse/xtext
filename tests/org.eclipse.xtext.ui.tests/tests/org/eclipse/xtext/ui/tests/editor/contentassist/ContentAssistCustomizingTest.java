/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.junit.editor.contentassist.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.ContentAssistCustomizingTestLanguageUiModule;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.ContentAssistCustomizingTestLanguageProposalProvider;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistCustomizingTest extends AbstractContentAssistProcessorTest {

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
	
	private int completeModel_Types;
	private int completeType_Name;
	private int completeType_SuperType;
	private int completeTypeRef_Type;
	private int complete_Model;
	private int complete_Type;
	private int complete_TypeRef;
	private int complete_FQN;
	
	public ISetup getSetup() {
		return new ContentAssistCustomizingTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(
						new ContentAssistCustomizingTestLanguageRuntimeModule(),
						new ContentAssistCustomizingTestLanguageUiModule(Activator.getInstance()) {
							@Override
							public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
								return TestableProposalProvider.class;
							}
							@SuppressWarnings("unused")
							public ContentAssistCustomizingTest bindTestClass() {
								return ContentAssistCustomizingTest.this;
							}
						}, new SharedStateModule()));
			}
		};
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		complete_FQN = 0;
		complete_Model = 0;
		complete_Type = 0;
		complete_TypeRef = 0;
		
		completeModel_Types = 0;
		completeType_Name = 0;
		completeType_SuperType = 0;
		completeTypeRef_Type = 0;
	}
	
	public void testEmptyModel_01() throws Exception {
		newBuilder().assertCount(0);
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(1, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);		
	}
	
	public void testEmptyModel_02() throws Exception {
		newBuilder().append("/* comment */").assertCount(0);
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(1, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);		
	}
	
	public void testFirstEntityName_01() throws Exception {
		newBuilder().append("name").assertText(";");
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(1, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);		
	}
	
	public void testFirstEntityName_02() throws Exception {
		newBuilder().append("/* comment */ name").assertText(";");
		assertEquals(1, complete_Model);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(1, completeType_Name);
		
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);		
	}
	
	public void testFirstEntityExtends_02() throws Exception {
		newBuilder().append("/* comment */ name ").assertText(";", "extends");
		assertEquals(0, complete_Model);
		assertEquals(0, complete_Type);
		assertEquals(0, complete_FQN);
		assertEquals(0, completeModel_Types);
		assertEquals(0, completeType_Name);
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);		
	}
	
	public void testFirstSuperType_01() throws Exception {
		newBuilder().append("name extends").assertText("extends");
		assertEquals(1, complete_TypeRef);
		assertEquals(1, completeType_SuperType);
		assertEquals(1, completeTypeRef_Type);
		
		assertEquals(0, complete_Model);
		assertEquals(0, complete_Type);
		assertEquals(0, completeModel_Types);
		assertEquals(0, completeType_Name);
		assertEquals(0, complete_FQN);
	}
	
	public void testFirstSuperType_02() throws Exception {
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
	
	public void testFirstSuperType_03() throws Exception {
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
	
	public void testSecondEntityName_01() throws Exception {
		newBuilder().append("name;").assertText(";");
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(1, completeType_Name);
		
		assertEquals(0, complete_Model);
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);		
	}
	
	public void testSecondEntityName_02() throws Exception {
		newBuilder().append("name; /* comment */").assertCount(0);
		assertEquals(1, complete_Type);
		assertEquals(1, complete_FQN);
		
		assertEquals(1, completeModel_Types);
		assertEquals(1, completeType_Name);
		
		assertEquals(0, complete_Model);
		assertEquals(0, complete_TypeRef);
		assertEquals(0, completeType_SuperType);
		assertEquals(0, completeTypeRef_Type);		
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return super.newBuilder(getSetup());
	}
	
}
