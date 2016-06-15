/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.shared;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.ui.refactoring.JvmRefactoringResourceSetProvider;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameProcessor;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameStrategy;
import org.eclipse.xtext.common.types.xtext.JvmIdentifiableQualifiedNameProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverDocumentationProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService;
import org.eclipse.xtext.ui.editor.copyqualifiedname.DefaultCopyQualifiedNameService;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.generator.trace.TraceForStorageProvider;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

@SuppressWarnings({ "restriction" })
public class SharedCommonTypesModule implements Module {

	public void configure(Binder binder) {
		binder.bind(IEObjectHoverProvider.class).to(JdtHoverProvider.class);
		binder.bind(IEObjectHoverDocumentationProvider.class).to(JdtHoverDocumentationProvider.class);
		binder.bind(IResourceServiceProvider.class).to(SharedCommonTypesResourceServiceProvider.class);
		binder.bind(IResourceSetProvider.class).to(XtextResourceSetProvider.class);
		binder.bindConstant().annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).to("java");
		
		binder.bind(IQualifiedNameProvider.class).to(JvmIdentifiableQualifiedNameProvider.class);
		binder.bind(CopyQualifiedNameService.class).to(DefaultCopyQualifiedNameService.class);
		binder.bind(IJvmTypeProvider.Factory.class).to(JdtTypeProviderFactory.class);
		binder.bind(IRenameRefactoringProvider.class).to(DefaultRenameRefactoringProvider.class);
		binder.bind(AbstractRenameProcessor.class).to(JvmMemberRenameProcessor.class);
		binder.bind(IRenameStrategy.Provider.class).to(JvmMemberRenameStrategy.Provider.class);
		binder.bind(RefactoringResourceSetProvider.class).to(JvmRefactoringResourceSetProvider.class);
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("Java");
		
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(LiveShadowedResourceDescriptions.class);
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(CurrentDescriptions.ResourceSetAware.class);
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(IBuilderState.class);
		
		binder.bind(IWorkspaceRoot.class).toInstance(ResourcesPlugin.getWorkspace().getRoot());
		binder.bind(ITraceForStorageProvider.class).to(TraceForStorageProvider.class);
		
		binder.bind(IReferenceUpdater.class).to(NullReferenceUpdater.class);
	}

}
