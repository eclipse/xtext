/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmMemberRenameStrategy implements IRenameStrategy {
	
	protected URI targetMemberOriginalURI;
	protected URI targetMemberNewURI;
	protected String originalName;

	public JvmMemberRenameStrategy(JvmMember targetMember) {
		targetMemberOriginalURI = EcoreUtil.getURI(targetMember);
		originalName = targetMember.getSimpleName();
	}

	public void applyDeclarationChange(final String newName, ResourceSet resourceSet) {
		JvmMember member = setName(targetMemberOriginalURI, resourceSet, newName);
		targetMemberNewURI = EcoreUtil.getURI(member);
	}

	public void revertDeclarationChange(ResourceSet resourceSet) {
		setName(targetMemberNewURI, resourceSet, originalName);
	}

	protected JvmMember setName(URI targetURI, ResourceSet resourceSet, final String newName) {
		JvmMember member = (JvmMember) resourceSet.getEObject(targetURI, true);
		member.internalSetIdentifier(null);
		member.setSimpleName(newName);
		if (member instanceof JvmGenericType && ((InternalEObject) member).eDirectResource() != null) {
			Resource typeResource = member.eResource();
			if (typeResource instanceof TypeResource) {
				String originalURI = typeResource.getURI().toString();
				int lastIndexOf = Math.max(originalURI.lastIndexOf('.'), originalURI.lastIndexOf('/') + 1);
				URI typeResourceNewURI = URI.createURI(originalURI.substring(0, lastIndexOf) + newName);
				typeResource.setURI(typeResourceNewURI);
				// disconnect the mirrored IJavaElement as it is invalid now
				((TypeResource) typeResource).setMirror(null);
			}
		}
		return member;
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
	}

	public String getOriginalName() {
		return originalName;
	}

	public RefactoringStatus validateNewName(String newName) {
		return new RefactoringStatus();
	}
	
	public static class Provider implements IRenameStrategy.Provider {

		public IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) {
			if (targetEObject instanceof JvmMember) {
				return new JvmMemberRenameStrategy((JvmMember) targetEObject);
			}
			return null;
		}
		
	}

}
