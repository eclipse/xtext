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
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.IssueCodes;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Inject;

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
	private IssueCodes issueCodes;

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(TypesPackage.eINSTANCE, XtypePackage.eINSTANCE, XbasePackage.eINSTANCE);
	}

	@Check
	public void checkRestrictedType(XConstructorCall constructorCall) {
		JvmDeclaredType declaringType = constructorCall.getConstructor().getDeclaringType();
		checkRestrictedType(constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, declaringType);
	}

	@Check
	public void checkRestrictedType(JvmTypeReference typeReference) {
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

	private static final int FORBIDDENREFERENCEID = 1;
	private static final int DISCOURAGEDREFERENCEID = 2;
	private static final int VALIDREFERENCEID = 0;

	protected void checkRestrictedType(EObject context, final EStructuralFeature feature, final JvmDeclaredType typeToCheck) {
		IJavaProject javaProject = projectProvider.getJavaProject(context.eResource().getResourceSet());
		
		if(javaProject == null)
			return;
		IJavaElement javaElement = javaElementFinder.findElementFor(typeToCheck);
		if(javaElement == null)
			return;
		final IJavaProject declaringJavaProject = javaElement.getJavaProject();
		if(declaringJavaProject == null)
			return;
		String packageName = typeToCheck.getPackageName();
		final String simpleName = typeToCheck.getSimpleName();
		if(!getContext().containsKey(typeToCheck)){
			IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { javaProject });
			BasicSearchEngine searchEngine = new BasicSearchEngine();
			try {
				searchEngine.searchAllTypeNames(packageName != null ? packageName.toCharArray() : CharOperation.NO_CHAR, SearchPattern.R_EXACT_MATCH,
						simpleName.toCharArray(), SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE,
						searchScope, new IRestrictedAccessTypeRequestor() {
							public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName,
									char[][] enclosingTypeNames, String path, AccessRestriction access) {
								if(access != null){
									if (access.getProblemId() == IProblem.ForbiddenReference) {
										getContext().put(typeToCheck, FORBIDDENREFERENCEID);
									} else if (access.getProblemId() == IProblem.DiscouragedReference) {
										getContext().put(typeToCheck, DISCOURAGEDREFERENCEID);
									} else
										getContext().put(typeToCheck, VALIDREFERENCEID);
								} else
									getContext().put(typeToCheck, VALIDREFERENCEID);
							}
						}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
			} catch (JavaModelException e) {
				// Ignore
			}
		}
		Object element = getContext().get(typeToCheck);
		if(element != null){
			if(element.equals(FORBIDDENREFERENCEID)){
				notification(issueCodes.forbiddenReference, "Access restriction: The type " + simpleName + " is not accessible due to restriction on required project " + declaringJavaProject.getElementName(), feature);
			} else if(element.equals(DISCOURAGEDREFERENCEID)){
				warning("Discouraged access: The type " + simpleName + " is not accessible due to restriction on required project " + declaringJavaProject.getElementName(), feature, DISCOURAGED_REFERENCE);
			}
		}
	}
}
