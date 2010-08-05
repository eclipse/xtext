/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.types;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ClasspathBasedTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypesGeneratorFragment extends DefaultGeneratorFragment {

	static {
		TypesPackage.eINSTANCE.getJvmArrayType();
	}
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
		     .addTypeToInstance(ClassLoader.class.getName(), "getClass().getClassLoader()")
			 .addTypeToType(ITypeProvider.Factory.class.getName(), ClasspathTypeProviderFactory.class.getName())
			 .addTypeToType(AbstractTypeScopeProvider.class.getName(), ClasspathBasedTypeScopeProvider.class.getName())
			 .addTypeToType(IGlobalScopeProvider.class.getName(), TypesAwareDefaultGlobalScopeProvider.class.getName())
			 .getBindings();
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			 .addTypeToInstance(ClassLoader.class.getName(), "getClass().getClassLoader()")
			 .addTypeToType(ITypeProvider.Factory.class.getName(), "org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory")
			 .addTypeToType(AbstractTypeScopeProvider.class.getName(), "org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScopeProvider")
			 .addTypeToType("org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider", 
					 	"org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider.IScopableTypesProposalProvider")
			 .addTypeToType("org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider$IScopableTypesProposalProvider", 
					 	"org.eclipse.xtext.common.types.xtext.ui.JdtTypesProposalProvider")		 	
			 .addTypeToType("org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider", 
					 	"org.eclipse.xtext.common.types.xtext.ui.XtextResourceSetBasedProjectProvider")
			 .addTypeToType("org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper", 
					 	"org.eclipse.xtext.common.types.xtext.ui.TypeAwareHyperlinkHelper")
			 .addTypeToType("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher", 
					 	"org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher")
			 .addTypeToType("org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider$ReferenceProposalCreator", 
					 	"org.eclipse.xtext.common.types.xtext.ui.TypeAwareReferenceProposalCreator")
			 .getBindings();
	}
	
	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.common.types" };
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.common.types.ui" };
	}
	
}
