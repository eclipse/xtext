/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public interface IContextFreeModification {

	static class Wrapper implements IModification {
		private final IContextFreeModification modification;
		private final URI uriToProblem;

		public Wrapper(URI uriToProblem, IContextFreeModification modification) {
			this.uriToProblem = uriToProblem;
			this.modification = modification;
		}

		public void apply(EObject element) {
			this.modification.apply(element);
		}

		@Override
		public void apply(IModificationContext context) throws Exception {
			// TODO should throw an unsupported operation exception
			context.getXtextDocument().modify(new IUnitOfWork.Void<XtextResource>() {

				@Override
				public void process(XtextResource state) throws Exception {
					EObject eObject = state.getEObject(uriToProblem.fragment());
					modification.apply(eObject);
				}
			});
		}

	}

	void apply(EObject element);
}
