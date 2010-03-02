/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import java.util.Collection;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalFactory;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypesProposalProvider extends AbstractTypesProposalProvider {

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private IJavaProjectProvider projectProvider;
	
	public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory, 
			ContentAssistContext context, Filter filter, ICompletionProposalAcceptor acceptor) {
		if (superType == null || superType.eIsProxy())
			return;
		// final type
		if (superType instanceof JvmGenericType  && ((JvmGenericType)superType).isFinal()) {
			// ignore filter since this is the only possible proposal
			createTypeProposal(superType.getCanonicalName(), proposalFactory, context, acceptor);
			return;
		}
		if (superType.eResource() == null || superType.eResource().getResourceSet() == null)
			return;
		IJavaProject project = getProjectProvider().getJavaProject(superType.eResource().getResourceSet());
		if (project == null)
			return;
		
		String fqn = superType.getCanonicalName();
		// java.lang.Object - no need to create hierarchy scope
		if (Object.class.getName().equals(fqn)) {
			createTypeProposals(project, proposalFactory, context, filter, acceptor);
			return;
		} 
		
		final Collection<String> superTypes = superTypeCollector.collectSuperTypeNames(superType);
		try {
			IType type = project.findType(fqn);
			if (type != null) {
				IJavaSearchScope scope = SearchEngine.createHierarchyScope(type);
				searchAndCreateProposals(scope, proposalFactory, context, TypeMatchFilters.and(filter, new ITypesProposalProvider.Filter() {
					public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
							char[][] enclosingTypeNames, String path) {
						StringBuilder fqName = new StringBuilder(packageName.length + simpleTypeName.length + 1);
						if (packageName.length != 0) {
							fqName.append(packageName);
							fqName.append('.');
						}
						for(char[] enclosingType: enclosingTypeNames) {
							fqName.append(enclosingType);
							fqName.append('$');
						}
						fqName.append(simpleTypeName);
						String fqNameAsString = fqName.toString();
						return !superTypes.contains(fqNameAsString);
					}
					
					
				}), acceptor);
			}
		} catch(JavaModelException ex) {
			// ignore
		}
	}

	protected void searchAndCreateProposals(IJavaSearchScope scope, final ICompletionProposalFactory proposalFactory,
			final ContentAssistContext context, final Filter filter, final ICompletionProposalAcceptor acceptor) throws JavaModelException {
		String prefix = context.getPrefix();
		String[] split = prefix.split("\\.");
		char[] typeName = null;
		char[] packageName = null;
		if (prefix.length() > 0 && split.length > 0) {
			if (Character.isUpperCase(split[split.length - 1].charAt(0))) {
				typeName = split[split.length - 1].toCharArray();
				if (split.length > 1)
					packageName = prefix.substring(0, prefix.length() - (typeName.length + 1)).toCharArray();
			} else {
				if (prefix.endsWith("."))
					prefix = prefix.substring(0, prefix.length() - 1);
				packageName = prefix.toCharArray();
			}
		}
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.searchAllTypeNames(
				packageName, SearchPattern.R_PREFIX_MATCH, 
				typeName, SearchPattern.R_PREFIX_MATCH, 
				IJavaSearchConstants.TYPE, scope, 
				new TypeNameRequestor() {
					@Override
					public void acceptType(int modifiers,
							char[] packageName, char[] simpleTypeName,
							char[][] enclosingTypeNames, String path) {
						if (filter.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)) {
							StringBuilder fqName = new StringBuilder(packageName.length + simpleTypeName.length + 1);
							if (packageName.length != 0) {
								fqName.append(packageName);
								fqName.append('.');
							}
							for(char[] enclosingType: enclosingTypeNames) {
								fqName.append(enclosingType);
								fqName.append('$');
							}
							fqName.append(simpleTypeName);
							createTypeProposal(fqName.toString(), proposalFactory, context, acceptor);
						}
					}
				}, 
				IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, 
				new NullProgressMonitor() {
					@Override
					public boolean isCanceled() {
						return !acceptor.canAcceptMoreProposals();
					}
				});
	}

	public void createTypeProposals(ICompletionProposalFactory proposalFactory, ContentAssistContext context, 
			Filter filter, ICompletionProposalAcceptor acceptor) {
		EObject model = context.getCurrentModel();
		if (model == null || model.eResource() == null || model.eResource().getResourceSet() == null)
			return;
		IJavaProject javaProject = projectProvider.getJavaProject(model.eResource().getResourceSet());
		createTypeProposals(javaProject, proposalFactory, context, filter, acceptor);
	}
	
	public void createTypeProposals(IJavaProject project, ICompletionProposalFactory proposalFactory, ContentAssistContext context,
			Filter filter, ICompletionProposalAcceptor acceptor) {
		try {
			IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { project });
			searchAndCreateProposals(searchScope, proposalFactory, context, filter, acceptor);
		}
		catch (JavaModelException e) {
			// ignore
		}
	}

	protected void createTypeProposal(String typeName, ICompletionProposalFactory proposalFactory, 
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (acceptor.canAcceptMoreProposals()) {
			int lastDot = typeName.lastIndexOf('.');
			String displayString = typeName;
			if (lastDot != -1)
				displayString = typeName.substring(lastDot + 1) + " - " + typeName.substring(0, lastDot);
			ICompletionProposal proposal = proposalFactory.createCompletionProposal(typeName, displayString, null, context);
			acceptor.accept(proposal);
		}
	}

	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
	}

	public SuperTypeCollector getSuperTypeCollector() {
		return superTypeCollector;
	}

	public void setProjectProvider(IJavaProjectProvider projectProvider) {
		this.projectProvider = projectProvider;
	}

	public IJavaProjectProvider getProjectProvider() {
		return projectProvider;
	}

}
