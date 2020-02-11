/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.xtext.JvmMemberInitializableResource;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver;

import com.google.common.collect.Lists;

/**
 * A type resolver that takes broken models into account, e.g. it will also traverse the source
 * model to find {@link XtendTypeDeclaration type declarations} that are not associated with {@link org.eclipse.xtext.common.types.JvmType JvmTypes}. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeDeclarationAwareBatchTypeResolver extends LogicalContainerAwareBatchTypeResolver {

	/**
	 * Checks the internal state of the resource and logs if type resolution was triggered unexpectedly.
	 * If such a condition is detected, an {@link IllegalStateException exception} is thrown.
	 * 
	 * @throws IllegalStateException if the resource is in an unexpected state.
	 */
	@Override
	protected void validateResourceState(Resource resource) {
		if (resource instanceof StorageAwareResource && ((StorageAwareResource) resource).isLoadedFromStorage()) {
			throw new IllegalStateException("Discouraged attempt to compute types for resource that was loaded from storage. Resource was : "+resource.getURI());
		}
		if (resource instanceof DerivedStateAwareResource && ((DerivedStateAwareResource) resource).isInitializing()) {
			throw new IllegalStateException("Discouraged attempt to compute types during model inference. Resource was : "+resource.getURI());
		}
		if (resource instanceof JvmMemberInitializableResource && ((JvmMemberInitializableResource) resource).isInitializingJvmMembers()) {
			throw new IllegalStateException("Discouraged attempt to compute types during JvmMember initialization. Resource was : "+resource.getURI());
		}
	}
	
	@Override
	protected List<EObject> getEntryPoints(EObject object) {
		 List<EObject> result = super.getEntryPoints(object);
		 EObject rootContainer = EcoreUtil.getRootContainer(object);
		 if (rootContainer instanceof XtendFile) {
			 result = Lists.newArrayList(result);
			 List<XtendTypeDeclaration> typeDeclarations = ((XtendFile) rootContainer).getXtendTypes();
			 for(XtendTypeDeclaration declaration: typeDeclarations) {
				 addXtendTypes(declaration, result);
			 }
			 return result;
		 }
		 return result;
	}

	/**
	 * Collects all Xtend type declarations and adds them to the list. The types are added
	 * from the innermost to the outermost type declaration. That is, nested classes are 
	 * added before their declarators are added. This greatly simplifies the implementation of
	 * {@code isHandled} in the concrete {@link org.eclipse.xtext.xbase.typesystem.internal.AbstractRootedReentrantTypeResolver}.
	 */
	private void addXtendTypes(XtendTypeDeclaration declaration, List<EObject> result) {
		for(XtendMember member: declaration.getMembers()) {
			TreeIterator<EObject> iterator = EcoreUtil2.getAllNonDerivedContents(member, true);
			while(iterator.hasNext()) {
				EObject next = iterator.next();
				if (next instanceof XtendTypeDeclaration) {
					addXtendTypes((XtendTypeDeclaration) next, result);
					iterator.prune();
				}
			}
		}
		result.add(declaration);
	}
	
}
