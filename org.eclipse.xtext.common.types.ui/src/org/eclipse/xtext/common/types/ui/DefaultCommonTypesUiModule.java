/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.ui.editor.JvmTypesAwareDirtyStateEditorSupport;
import org.eclipse.xtext.common.types.ui.query.IJavaSearchParticipation;
import org.eclipse.xtext.common.types.ui.refactoring.JvmRefactoringResourceSetProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtTypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtValidationJobScheduler;
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareHyperlinkHelper;
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareReferenceProposalCreator;
import org.eclipse.xtext.common.types.xtext.ui.XtextResourceSetBasedProjectProvider;
import org.eclipse.xtext.ui.DefaultUiModule;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.ui.editor.IValidationJobScheduler;
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
public class DefaultCommonTypesUiModule extends DefaultUiModule {

	public DefaultCommonTypesUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public java.lang.ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}

	public Class<? extends IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory.class;
	}

	public Class<? extends AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return JdtBasedSimpleTypeScopeProvider.class;
	}

	public Class<? extends ITypesProposalProvider> bindITypesProposalProvider() {
		return JdtTypesProposalProvider.class;
	}

	public Class<? extends IJavaProjectProvider> bindIJavaProjectProvider() {
		return XtextResourceSetBasedProjectProvider.class;
	}

	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return TypeAwareHyperlinkHelper.class;
	}

	public Class<? extends AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator> bindAbstractJavaBasedContentProposalProvider$ReferenceProposalCreator() {
		return TypeAwareReferenceProposalCreator.class;
	}

	public Class<? extends IValidationJobScheduler> bindIValidationJobScheduler() {
		return JdtValidationJobScheduler.class;
	}

	public Class<? extends RefactoringResourceSetProvider> bindRefactoringResourceSetProvider() {
		return JvmRefactoringResourceSetProvider.class;
	}

	public Class<? extends IJavaSearchParticipation> bindIJavaSearchParticipation() {
		return IJavaSearchParticipation.Yes.class;
	}
	
	public Class<? extends DirtyStateEditorSupport> bindDirtyStateEditorSupport(){
		return JvmTypesAwareDirtyStateEditorSupport.class;
	}
}
