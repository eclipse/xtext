/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.refactoring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * Called to rename an element in the {@link IChangeSerializer} based refactoring.
 * 
 * Clients may extend the {@link DefaultImpl} to customize the behavior or implement this interface directly.
 * 
 * Changes are usually performed in the {@link RenameContext}
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public interface IRenameStrategy2 {
	class DefaultImpl implements IRenameStrategy2 {
		@Inject
		private IResourceServiceProvider resourceServiceProvider;

		public boolean canHandle(RenameChange change) {
			return resourceServiceProvider.canHandle(change.getTargetURI());
		}

		@Override
		public void applyRename(RenameContext context) {
			for (RenameChange change : context.getChanges()) {
				if (canHandle(change)) {
					context.addModification(change, (EObject o) -> doRename(o, change, context));
				}
			}
		}

		protected void doRename(EObject target, RenameChange change, RenameContext context) {
			EAttribute nameAttribute = getNameEAttribute(target);
			if (nameAttribute != null) {
				target.eSet(nameAttribute, change.getNewName());
			} else {
				context.getIssues().add(RefactoringIssueAcceptor.Severity.WARNING, "Element of class " + target.eClass().getName() + " cannot be renamed.");
			}
		}

		protected EAttribute getNameEAttribute(EObject target) {
			for (EAttribute attribute : target.eClass().getEAllAttributes()) {
				if ("name".equals(attribute.getName()) && EcorePackage.Literals.ESTRING == attribute.getEType()) {
					return attribute;
				}
			}
			return null;
		}
	}

	void applyRename(RenameContext context);
}
