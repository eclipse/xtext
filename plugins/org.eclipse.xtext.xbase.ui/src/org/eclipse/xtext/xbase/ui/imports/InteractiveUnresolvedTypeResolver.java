/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.imports;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.core.search.BasicSearchEngine;
import org.eclipse.jdt.internal.core.search.IRestrictedAccessTypeRequestor;
import org.eclipse.jdt.internal.corext.util.TypeFilter;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.conversion.XbaseQualifiedNameValueConverter;
import org.eclipse.xtext.xbase.imports.IUnresolvedTypeResolver;
import org.eclipse.xtext.xbase.imports.TypeUsage;
import org.eclipse.xtext.xbase.imports.TypeUsages;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class InteractiveUnresolvedTypeResolver implements IUnresolvedTypeResolver {

	private static final Logger LOG = Logger.getLogger(InteractiveUnresolvedTypeResolver.class);

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private IJavaProjectProvider projectProvider;

	@Inject
	private TypeChooser typeChooser;
	
	@Inject
	private IVisibilityHelper visibilityHelper;
	
	@Inject
	private XbaseQualifiedNameValueConverter nameValueConverter;
	
	@Override
	public void resolve(TypeUsages typeUsages, XtextResource resource) {
		if(typeUsages.getUnresolvedTypeUsages().isEmpty() || resource == null)
			return;
		Multimap<String, TypeUsage> name2usage = LinkedHashMultimap.create();
		for (TypeUsage unresolved : typeUsages.getUnresolvedTypeUsages()) {
			String text = unresolved.getUsedTypeName();
			text = nameValueConverter.toValue(text, null);
			name2usage.put(text, unresolved);
		}
		for (String name : name2usage.keySet()) {
			Iterable<TypeUsage> usages = name2usage.get(name);
			JvmDeclaredType resolvedType = resolve(name, usages, resource);
			if (resolvedType != null) {
				for (TypeUsage usage : usages)
					typeUsages.addTypeUsage(
							resolvedType,
							usage.getSuffix(),
							usage.getTextRegion(),
							usage.getContext());
			}
		}
	}

	protected JvmDeclaredType resolve(String name, Iterable<TypeUsage> usages, XtextResource resource) {
		try {
			IJavaSearchScope javaSearchScope = getJavaSearchScope(resource);
			final List<JvmDeclaredType> candidateTypes = newArrayList();
			JvmMember context = usages.iterator().next().getContext();
			JvmDeclaredType contextType = EcoreUtil2.getContainerOfType(context, JvmDeclaredType.class);
			if(contextType != null)
				findCandidateTypes(contextType, name, javaSearchScope, new IAcceptor<JvmDeclaredType>() {
					@Override
					public void accept(JvmDeclaredType t) {
						candidateTypes.add(t);
					}
				});
			if (candidateTypes.isEmpty())
				return null;
			else if (candidateTypes.size() == 1)
				return candidateTypes.get(0);
			else
				return typeChooser.choose(candidateTypes, usages, resource);
		} catch (JavaModelException e) {
			LOG.error("Error searching for type named '" + notNull(name) + "'", e);
		}
		return null;
	}

	protected IJavaSearchScope getJavaSearchScope(XtextResource resource) {
		IJavaProject javaProject = projectProvider.getJavaProject(resource.getResourceSet());
		IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { javaProject });
		return searchScope;
	}

	protected String getQualifiedTypeName(char[] packageName, char[][] enclosingTypeNames, char[] simpleTypeName) {
		StringBuilder fqName = new StringBuilder(packageName.length + simpleTypeName.length + 1);
		if (packageName.length != 0) {
			fqName.append(packageName);
			fqName.append('.');
		}
		for (char[] enclosingType : enclosingTypeNames) {
			fqName.append(enclosingType);
			fqName.append('$');
		}
		fqName.append(simpleTypeName);
		String fqNameAsString = fqName.toString();
		return fqNameAsString;
	}

	protected void findCandidateTypes(final JvmDeclaredType contextType, final String typeSimpleName,
			IJavaSearchScope searchScope, final IAcceptor<JvmDeclaredType> acceptor) throws JavaModelException {
		BasicSearchEngine searchEngine = new BasicSearchEngine();
		final IVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(visibilityHelper, contextType);
		searchEngine.searchAllTypeNames(null, SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE, typeSimpleName.toCharArray(),
				SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE, IJavaSearchConstants.TYPE, searchScope,
				new IRestrictedAccessTypeRequestor() {
					@Override
					public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName,
							char[][] enclosingTypeNames, String path, AccessRestriction access) {
						final String qualifiedTypeName = getQualifiedTypeName(packageName, enclosingTypeNames,
								simpleTypeName);
						if ((access == null
								|| (access.getProblemId() != IProblem.ForbiddenReference && !access.ignoreIfBetter()))
							&& !TypeFilter.isFiltered(packageName, simpleTypeName)) {
							JvmType importType = typeRefs.findDeclaredType(qualifiedTypeName, contextType.eResource());
							if (importType instanceof JvmDeclaredType
									&& contextualVisibilityHelper.isVisible((JvmDeclaredType) importType)) {
								acceptor.accept((JvmDeclaredType) importType);
							}
						}
					}
				}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
	}

}
