/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeDeclarationAwareBatchTypeResolver extends LogicalContainerAwareBatchTypeResolver {

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
			TreeIterator<EObject> iterator = EcoreUtil2.eAll(member);
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
