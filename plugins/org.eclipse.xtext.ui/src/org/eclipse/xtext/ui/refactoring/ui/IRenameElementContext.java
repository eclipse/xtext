/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.refactoring.IChangeRedirector;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;

/**
 * The context information of a rename element refactoring. Based on this information a
 * {@link IRenameRefactoringProvider} chooses the implementation of the refactoring processor.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public interface IRenameElementContext {

	URI getTargetElementURI();

	URI getContextResourceURI();

	EClass getTargetElementEClass();

	IEditorPart getTriggeringEditor();

	ISelection getTriggeringEditorSelection();

	class Impl implements IRenameElementContext, IChangeRedirector.Aware {

		private URI targetElementURI;

		private URI contextResourceURI;

		private EClass targetElementEClass;

		private IEditorPart triggeringEditor;

		private final ISelection triggeringEditorSelection;

		private IChangeRedirector changeRedirector = IChangeRedirector.NULL;

		public Impl(URI targetElementURI, EClass targetElementEClass) {
			this(targetElementURI, targetElementEClass, null, null, null);
		}

		public Impl(URI targetElementURI, EClass targetElementEClass, IEditorPart triggeringEditor,
				ISelection triggeringEditorSelection, URI contextResourceURI) {
			this.targetElementURI = targetElementURI;
			this.targetElementEClass = targetElementEClass;
			this.triggeringEditor = triggeringEditor;
			this.triggeringEditorSelection = triggeringEditorSelection;
			this.contextResourceURI = contextResourceURI;
		}

		public URI getContextResourceURI() {
			return contextResourceURI;
		}

		public URI getTargetElementURI() {
			return targetElementURI;
		}

		public EClass getTargetElementEClass() {
			return targetElementEClass;
		}

		public IEditorPart getTriggeringEditor() {
			return triggeringEditor;
		}

		public ISelection getTriggeringEditorSelection() {
			return triggeringEditorSelection;
		}

		public IChangeRedirector getChangeRedirector() {
			return changeRedirector;
		}

		public void setChangeRedirector(IChangeRedirector changeRedirector) {
			this.changeRedirector = changeRedirector;
		}

	}
}
