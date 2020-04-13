/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.refactoring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class RenameContext {
	private final List<? extends RenameChange> changes;

	private final ResourceSet resourceSet;

	private final IChangeSerializer changeSerializer;

	private final RefactoringIssueAcceptor issues;

	public RenameContext(List<? extends RenameChange> changes, ResourceSet resourceSet,
			IChangeSerializer changeSerializer, RefactoringIssueAcceptor issues) {
		this.changes = changes;
		this.resourceSet = resourceSet;
		this.changeSerializer = changeSerializer;
		this.issues = issues;
	}

	public void addModification(RenameChange change, IChangeSerializer.IModification<EObject> modification) {
		EObject target = resourceSet.getEObject(change.getTargetURI(), true);
		if (target != null) {
			EcoreUtil.resolveAll(target.eResource());
			changeSerializer.addModification(target, modification);
		} else {
			issues.add(RefactoringIssueAcceptor.Severity.ERROR, "Element cannot be found", change.getTargetURI());
		}
	}

	public List<? extends RenameChange> getChanges() {
		return changes;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public IChangeSerializer getChangeSerializer() {
		return changeSerializer;
	}

	public RefactoringIssueAcceptor getIssues() {
		return issues;
	}
}
