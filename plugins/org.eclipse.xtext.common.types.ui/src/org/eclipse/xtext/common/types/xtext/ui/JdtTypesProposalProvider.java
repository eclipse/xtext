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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal.IReplacementTextApplier;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Builder;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalFactory;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 * @author Christoph Kulla - added support for hovers
 */
@SuppressWarnings("restriction")
public class JdtTypesProposalProvider extends AbstractTypesProposalProvider {

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private IJavaProjectProvider projectProvider;
	
	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private IEObjectHover hover;
	
	@Inject
	private JdtTypeProviderFactory jdtTypeProviderFatory;
	
	public static class FQNShortener extends ReplacementTextApplier {
		private final IScope scope;
		private final Resource context;
		private final IQualifiedNameConverter qualifiedNameConverter;
		
		public FQNShortener(Resource context, IScope scope, IQualifiedNameConverter qualifiedNameConverter) {
			this.context = context;
			this.scope = scope;
			this.qualifiedNameConverter = qualifiedNameConverter;
		}
		
		protected String applyValueConverter(QualifiedName qualifiedName) {
			return qualifiedNameConverter.toString(qualifiedName);
		}
		
		@Override
		public String getActualReplacementString(ConfigurableCompletionProposal proposal) {
			String replacementString = proposal.getReplacementString();
			if (scope != null) {
				IEObjectDescription element = scope.getSingleElement(new ISelector.SelectByName(qualifiedNameConverter.toQualifiedName(replacementString)));
				if (element != null) {
					EObject resolved = EcoreUtil.resolve(element.getEObjectOrProxy(), context);
					if (!resolved.eIsProxy()) {
						IEObjectDescription shortedElement = scope.getSingleElement(new ISelector.SelectByEObject(resolved));
						if (shortedElement != null) {
							replacementString = applyValueConverter(shortedElement.getName());
						}
					}
				}
			}
			return replacementString;
		}
	}
	
	public void createSubTypeProposals(JvmType superType, ICompletionProposalFactory proposalFactory, 
			ContentAssistContext context, EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor) {
		if (superType == null || superType.eIsProxy())
			return;
		if (superType.eResource() == null || superType.eResource().getResourceSet() == null)
			return;
		IJavaProject project = getProjectProvider().getJavaProject(superType.eResource().getResourceSet());
		if (project == null)
			return;
		
		String fqn = superType.getCanonicalName();
		// java.lang.Object - no need to create hierarchy scope
		if (Object.class.getName().equals(fqn)) {
			createTypeProposals(project, proposalFactory, context, typeReference, filter, acceptor);
			return;
		} 
		
		final Collection<String> superTypes = superTypeCollector.collectSuperTypeNames(superType);
		try {
			IType type = project.findType(fqn);
			if (type != null) {
				IJavaSearchScope hierarchyScope = SearchEngine.createHierarchyScope(type);
				IJavaSearchScope projectScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { project });
				IJavaSearchScope scope = new IntersectingJavaSearchScope(projectScope, hierarchyScope);
				searchAndCreateProposals(scope, proposalFactory, context, typeReference, TypeMatchFilters.and(filter, new ITypesProposalProvider.Filter() {
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
			ContentAssistContext context, EReference typeReference, final Filter filter, final ICompletionProposalAcceptor acceptor) throws JavaModelException {
		String prefix = context.getPrefix();
		String[] split = prefix.split("\\.");
		char[] typeName = null;
		char[] packageName = null;
		if (prefix.length() > 0 && split.length > 0) {
			if (Character.isUpperCase(split[split.length - 1].charAt(0))) {
				typeName = split[split.length - 1].toCharArray();
				if (split.length > 1)
					packageName = ("*" + prefix.substring(0, prefix.length() - (typeName.length + 1)).replaceAll("\\.", "*.") + "*").toCharArray();
			} else {
				if (prefix.endsWith("."))
					prefix = prefix.substring(0, prefix.length() - 1);
				packageName = ("*" + prefix.replaceAll("\\.", "*.") + "*").toCharArray();
			}
		}
		IScope typeScope = null;
		if (context.getCurrentModel() != null) {
			typeScope = scopeProvider.getScope(context.getCurrentModel(), typeReference);
		}
		final IReplacementTextApplier textApplier = new FQNShortener(context.getResource(), typeScope, qualifiedNameConverter);
		final ICompletionProposalAcceptor scopeAware = new ICompletionProposalAcceptor.Delegate(acceptor) {
			@Override
			public void accept(ICompletionProposal proposal) {
				if (proposal instanceof ConfigurableCompletionProposal) {
					((ConfigurableCompletionProposal) proposal).setTextApplier(textApplier);
				}
				super.accept(proposal);
			}
		};
		Builder contextBuilder = context.copy();
		final PrefixMatcher original = context.getMatcher();
		contextBuilder.setMatcher(new PrefixMatcher() {
			@Override
			public boolean isCandidateMatchingPrefix(String name, String prefix) {
				if (original.isCandidateMatchingPrefix(name, prefix))
					return true;
				String sub = name;
				int delimiter = sub.indexOf('.');
				while(delimiter != -1) {
					sub = sub.substring(delimiter + 1);
					if (original.isCandidateMatchingPrefix(sub, prefix))
						return true;
					delimiter = sub.indexOf('.');
				}
				return false;
			}
		});
		final ContentAssistContext myContext = contextBuilder.toContext();
		final IJvmTypeProvider jvmTypeProvider = jdtTypeProviderFatory.findOrCreateTypeProvider(context.getResource().getResourceSet());
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.searchAllTypeNames(
				packageName, SearchPattern.R_PATTERN_MATCH, 
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
							String fqNameAsString = fqName.toString();
							createTypeProposal(fqNameAsString, modifiers, enclosingTypeNames.length>0, proposalFactory, myContext, scopeAware, jvmTypeProvider);
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
			EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor) {
		EObject model = context.getCurrentModel();
		if (model == null || model.eResource() == null || model.eResource().getResourceSet() == null)
			return;
		IJavaProject javaProject = projectProvider.getJavaProject(model.eResource().getResourceSet());
		createTypeProposals(javaProject, proposalFactory, context, typeReference, filter, acceptor);
	}
	
	public void createTypeProposals(IJavaProject project, ICompletionProposalFactory proposalFactory, ContentAssistContext context,
			EReference typeReference, Filter filter, ICompletionProposalAcceptor acceptor) {
		try {
			IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { project });
			searchAndCreateProposals(searchScope, proposalFactory, context, typeReference, filter, acceptor);
		}
		catch (JavaModelException e) {
			// ignore
		}
	}

	protected void createTypeProposal(final String typeName, int modifiers, boolean isInnerType, ICompletionProposalFactory proposalFactory, 
			ContentAssistContext context, ICompletionProposalAcceptor acceptor, final IJvmTypeProvider jvmTypeProvider) {
		if (acceptor.canAcceptMoreProposals()) {
			int lastDot = typeName.lastIndexOf('.');
			StyledString displayString = new StyledString(typeName);
			if (lastDot != -1)
				displayString = new StyledString(typeName.substring(lastDot + 1)).append(" - " + typeName.substring(0, lastDot), StyledString.QUALIFIER_STYLER);
			Image img = computeImage(typeName,isInnerType, modifiers);
			ICompletionProposal proposal = proposalFactory.createCompletionProposal(typeName, displayString, img, context);
			if (proposal instanceof ConfigurableCompletionProposal) {
				// calculate the type lazy, as this require a lot of time for large completion lists
				((ConfigurableCompletionProposal) proposal).setAdditionalProposalInfo(new Provider<EObject>(){
					public EObject get() {
						return jvmTypeProvider.findTypeByName(typeName);
					}});
				((ConfigurableCompletionProposal) proposal).setHover(hover);
			}
			acceptor.accept(proposal);
		}
	}

	protected Image computeImage(String typeName, boolean isInnerType, int modifiers) {
		return JavaPlugin.getImageDescriptorRegistry().get(
				JavaElementImageProvider.getTypeImageDescriptor(
						isInnerType, 
						Flags.isAnnotation(modifiers) || Flags.isInterface(modifiers), 
						modifiers, 
						false /* don't use light icons */));
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
