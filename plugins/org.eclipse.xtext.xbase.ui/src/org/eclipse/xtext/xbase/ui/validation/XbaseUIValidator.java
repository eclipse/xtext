/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.validation;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.core.search.BasicSearchEngine;
import org.eclipse.jdt.internal.core.search.IRestrictedAccessTypeRequestor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.4
 */
public class XbaseUIValidator extends AbstractDeclarativeValidator {

	@Inject
	private IJavaProjectProvider projectProvider;

	@Inject
	private IJavaElementFinder javaElementFinder;
	
	@Inject
	private OnChangeEvictingCache cache;

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(TypesPackage.eINSTANCE, XtypePackage.eINSTANCE, XbasePackage.eINSTANCE);
	}
	
	@Check
	public void checkRestrictedType(XImportDeclaration importDeclaration){
		if (shouldCheckRestriction())
			return;
		JvmType importedType = importDeclaration.getImportedType();
		if(importedType instanceof JvmDeclaredType)
			checkRestrictedType(importDeclaration, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, (JvmDeclaredType) importedType);
	}

	@Check
	public void checkRestrictedType(XConstructorCall constructorCall) {
		if (shouldCheckRestriction())
			return;
		JvmDeclaredType declaringType = constructorCall.getConstructor().getDeclaringType();
		checkRestrictedType(constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, declaringType);
	}

	@Check
	public void checkRestrictedType(JvmTypeReference typeReference) {
		if (shouldCheckRestriction())
			return;
		if (typeReference != null && typeReference.eResource() != null
				&& typeReference.eResource().getResourceSet() != null) {
			JvmType type = typeReference.getType();
			if (type instanceof JvmDeclaredType) {
				if (typeReference instanceof JvmParameterizedTypeReference)
					checkRestrictedType(typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE,
							(JvmDeclaredType) type);
				else
					checkRestrictedType(typeReference, null, (JvmDeclaredType) type);
			}
		}
	}

	protected boolean shouldCheckRestriction() {
		return isIgnored(DISCOURAGED_REFERENCE) && isIgnored(FORBIDDEN_REFERENCE);
	}

	private static enum RestrictionKind {
		FORBIDDEN, DISCOURAGED, VALID
	}

	protected void checkRestrictedType(final EObject context, final EStructuralFeature feature, final JvmDeclaredType typeToCheck) {
		final IJavaProject javaProject = projectProvider.getJavaProject(context.eResource().getResourceSet());
		if(javaProject == null)
			return;
		RestrictionKind kind = cache.get("restriction", typeToCheck.eResource(), new Provider<RestrictionKind>() {
			public RestrictionKind get() {
				IJavaElement javaElement = javaElementFinder.findElementFor(typeToCheck);
				if(javaElement == null)
					return RestrictionKind.VALID;
				final IJavaProject declaringJavaProject = javaElement.getJavaProject();
				if(declaringJavaProject == null)
					return RestrictionKind.VALID;
				String packageName = typeToCheck.getPackageName();
				final String simpleName = typeToCheck.getSimpleName();
				if(!getContext().containsKey(typeToCheck)){
					IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { javaProject });
					BasicSearchEngine searchEngine = new BasicSearchEngine();
					try {
						final RestrictionKind[] result = new RestrictionKind[1];
						searchEngine.searchAllTypeNames(packageName != null ? packageName.toCharArray() : CharOperation.NO_CHAR, SearchPattern.R_EXACT_MATCH,
								simpleName.toCharArray(), SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE,
								searchScope, new IRestrictedAccessTypeRequestor() {
									public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName,
											char[][] enclosingTypeNames, String path, AccessRestriction access) {
										if(access != null){
											if (access.getProblemId() == IProblem.ForbiddenReference) {
												result[0] = RestrictionKind.FORBIDDEN;
											} else if (access.getProblemId() == IProblem.DiscouragedReference) {
												result[0] = RestrictionKind.DISCOURAGED;
											} else
												result[0] = RestrictionKind.VALID;
										} else
											result[0] = RestrictionKind.VALID;
									}
								}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
						return result[0];
					} catch (JavaModelException e) {
						// Ignore
					}
				}
				return RestrictionKind.VALID;
			}
		});
		
		if (kind == RestrictionKind.FORBIDDEN) {
			addIssue(context, IssueCodes.FORBIDDEN_REFERENCE,
					"Access restriction: The type " + typeToCheck.getSimpleName()
							+ " is not accessible due to restriction on required project "
							+ javaProject.getElementName(), feature);
		} else if (kind == RestrictionKind.DISCOURAGED) {
			addIssue(context,
					IssueCodes.DISCOURAGED_REFERENCE,
					"Discouraged access: The type " + typeToCheck.getSimpleName()
							+ " is not accessible due to restriction on required project "
							+ javaProject.getElementName(), feature);
		}
	}
}
