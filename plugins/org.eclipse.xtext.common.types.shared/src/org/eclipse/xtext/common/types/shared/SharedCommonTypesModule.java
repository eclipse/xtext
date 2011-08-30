package org.eclipse.xtext.common.types.shared;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.ui.refactoring.JvmRefactoringResourceSetProvider;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JvmIdentifiableQualifiedNameProvider;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameProcessor;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameStrategy;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
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

@SuppressWarnings("restriction")
public class SharedCommonTypesModule implements Module {

	public void configure(Binder binder) {
		binder.bind(IEObjectHoverProvider.class).to(JdtHoverProvider.class);
		binder.bind(IResourceServiceProvider.class).to(SharedCommonTypesResourceServiceProvider.class);
		binder.bind(IResourceSetProvider.class).to(XtextResourceSetProvider.class);
		binder.bindConstant().annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).to("java");
		
		binder.bind(IQualifiedNameProvider.class).to(JvmIdentifiableQualifiedNameProvider.class);
		binder.bind(IJvmTypeProvider.Factory.class).to(JdtTypeProviderFactory.class);
		binder.bind(IRenameRefactoringProvider.class).to(DefaultRenameRefactoringProvider.class);
		binder.bind(AbstractRenameProcessor.class).to(JvmMemberRenameProcessor.class);
		binder.bind(IRenameStrategy.Provider.class).to(JvmMemberRenameStrategy.Provider.class);
		binder.bind(RefactoringResourceSetProvider.class).to(JvmRefactoringResourceSetProvider.class);
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("Java");
	}

}
