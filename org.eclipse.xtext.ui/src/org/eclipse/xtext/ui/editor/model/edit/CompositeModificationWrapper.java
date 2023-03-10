/*******************************************************************************
< * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ICompositeModificationContext.IModificationPart;
import org.eclipse.xtext.validation.Issue;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CompositeModificationWrapper implements IModification, BatchModification.IBatchableModification {

	public static class ModificationPart<T extends Notifier> implements IChangeSerializer.IModification<T> {
		private final T element;
		private final ICompositeModificationContext.IModificationPart<T> part;

		public ModificationPart(IModificationPart<T> part, T element) {
			super();
			this.part = part;
			this.element = element;
		}

		public void apply() {
			part.apply(element);
		}

		@Override
		public void modify(T context) {
			part.apply(context);
		}

	}

	protected class MultiModificationContext implements ICompositeModificationContext<EObject> {
		private final EObject element;
		private final IChangeSerializer serializer;

		public MultiModificationContext(EObject element, IChangeSerializer serializer) {
			this.element = element;
			this.serializer = serializer;
		}

		@Override
		public <N extends Notifier> void addModification(N toModify, IModificationPart<N> modification) {
			serializer.addModification(toModify, new ModificationPart<N>(modification, toModify));
		}

		@Override
		public EObject getElement() {
			return this.element;
		}

		@Override
		public Issue getIssue() {
			return CompositeModificationWrapper.this.getIssue();
		}

		@Override
		public ITextRegionDiffBuilder getModifiableDocument(XtextResource resource) {
			return serializer.getModifiableDocument(resource);
		}

		@Override
		public boolean isUpdateCrossReferences() {
			return CompositeModificationWrapper.this.isUpdateCrossReferences();
		}

		@Override
		public boolean isUpdateRelatedFiles() {
			return CompositeModificationWrapper.this.isUpdateRelatedFiles();
		}

		@Override
		public void setUpdateCrossReferences(boolean value) {
			CompositeModificationWrapper.this.setUpdateCrossReferences(value);
		}

		@Override
		public void setUpdateRelatedFiles(boolean value) {
			CompositeModificationWrapper.this.setUpdateRelatedFiles(value);
		}
	}

	private final Issue issue;
	private final ICompositeModification<EObject> modification;
	private boolean updateCrossReferences = true;
	private boolean updateRelatedFiles = true;

	@SuppressWarnings("unchecked")
	public CompositeModificationWrapper(Issue issue, ICompositeModification<?> modification) {
		this.issue = issue;
		this.modification = (ICompositeModification<EObject>) modification;
	}

	@Override
	public void apply(EObject object, IChangeSerializer serializer) {
		modification.apply(object, new MultiModificationContext(object, serializer));
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

	@Override
	public URI getEObjectURI() {
		return issue.getUriToProblem();
	}

	public Issue getIssue() {
		return issue;
	}

	@Override
	public boolean isUpdateCrossReferences() {
		return updateCrossReferences;
	}

	@Override
	public boolean isUpdateRelatedFiles() {
		return updateRelatedFiles;
	}

	public void setUpdateCrossReferences(boolean updateCrossReferences) {
		this.updateCrossReferences = updateCrossReferences;
	}

	public void setUpdateRelatedFiles(boolean updateRelatedFiles) {
		this.updateRelatedFiles = updateRelatedFiles;
	}

}