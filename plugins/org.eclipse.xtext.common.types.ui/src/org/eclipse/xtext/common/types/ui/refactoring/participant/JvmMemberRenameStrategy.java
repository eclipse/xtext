/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;

/**
 * Renames a JVM element in a {@link TypeResource} and updates all references to it.
 *  
 * @author Jan Koehnlein - Initial contribution and API
 */
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
		final JvmMember member = (JvmMember) resourceSet.getEObject(targetURI, true);
		/*
		 * This seems to be the only location in Xtext code where a JVM element is changed!
		 */
		// clear all cached identifiers of contained members
		for(JvmMember containedMember: EcoreUtil2.eAllOfType(member, JvmMember.class)) 
			containedMember.internalSetIdentifier(null);
		member.setSimpleName(newName);
		if (member instanceof JvmDeclaredType && ((InternalEObject) member).eDirectResource() != null) {
			Resource typeResource = member.eResource();
			if (typeResource instanceof TypeResource) {
				// rename the resource
				String originalURI = typeResource.getURI().toString();
				int lastIndexOf = Math.max(originalURI.lastIndexOf('.'), originalURI.lastIndexOf('/')) + 1;
				URI typeResourceNewURI = URI.createURI(originalURI.substring(0, lastIndexOf) + newName);
				typeResource.setURI(typeResourceNewURI);
				// disconnect the mirrored IJavaElement as it is invalid now
				((TypeResource) typeResource).setMirror(new AbstractClassMirror() {
					public boolean isSealed() {
						return false;
					}
					
					public void initialize(TypeResource typeResource) {
					}
					
					@Override
					protected String getTypeName() {
						return member.getIdentifier();
					}
				});
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
		@Retention(RetentionPolicy.RUNTIME)
		@BindingAnnotation
		public @interface Delegate {
		}
		
		@Inject(optional=true)@Delegate
		private IRenameStrategy.Provider delegate;

		public IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) {
			if(targetEObject instanceof JvmMember) 
				return new JvmMemberRenameStrategy((JvmMember) targetEObject);
			return delegate == null ? null : delegate.get(targetEObject, renameElementContext);
		}
	}

}
