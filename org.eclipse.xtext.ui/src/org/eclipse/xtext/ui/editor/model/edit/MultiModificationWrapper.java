/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.BatchModification.IBatchableModification;
import org.eclipse.xtext.validation.Issue;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MultiModificationWrapper implements IModification, IBatchableModification {

	private final Issue issue;

	private final IMultiModification<EObject> modification;

	@SuppressWarnings("unchecked")
	public MultiModificationWrapper(Issue issue, IMultiModification<?> modification) {
		this.issue = issue;
		this.modification = (IMultiModification<EObject>) modification;
	}

	@Override
	public void apply(EObject object, IChangeSerializer serializer) {
		serializer.addModification(object.eResource(), r -> modification.apply(object));
	}

	@Override
	public void apply(IModificationContext ctx) throws Exception {
		IXtextDocument document = ctx.getXtextDocument();
		BatchModification batch = document.tryReadOnly(r -> r.getResourceServiceProvider().get(BatchModification.class));
		if (batch != null) {
			batch.setDocument(document);
			batch.apply(Collections.singleton(this), new NullProgressMonitor());
		}
	}

	public Issue getIssue() {
		return issue;
	}

	@Override
	public URI getEObjectURI() {
		return issue.getUriToProblem();
	}

	@Override
	public boolean isUpdateCrossReferences() {
		return true;
	}

	@Override
	public boolean isUpdateRelatedFiles() {
		return true;
	}

}
