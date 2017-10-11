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
 * @since 2.13
 * @author Dennis Huebner - Initial contribution and API
 */
public interface IMultiModification {

	void apply(EObject element);

	public class PreInitializedModification implements IModification, IMultiModification {
		private IMultiModificationWithContext modification;
		private MultiModificationContext context;
		private URI uriToProblem;

		public PreInitializedModification(URI uri, IMultiModificationWithContext modification) {
			this.uriToProblem = uri;
			this.modification = modification;
		}

		public void init(EObject element) {
			context = new MultiModificationContext(element);
			modification.apply(context);
		}

		public MultiModificationContext getContext() {
			return context;
		}

		@Override
		public void apply(IModificationContext ctx) throws Exception {
			// TODO should throw an unsupported operation exception
			ctx.getXtextDocument().modify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					ctx.getXtextDocument().modify(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							EObject eObject = state.getEObject(uriToProblem.fragment());
							init(eObject);
							apply(eObject);
						}
					});
				}
			});
		}

		@Override
		public void apply(EObject element) {
			if (context == null) {
				throw new IllegalStateException("Context is not initialized. Call init() before calling apply()");
			}
			context.applyModification();
		}

	}

	static class Wrapper implements IModification, IMultiModification {
		private final IMultiModification modification;
		private final URI uriToProblem;

		public Wrapper(URI uriToProblem, IMultiModification modification) {
			this.uriToProblem = uriToProblem;
			this.modification = modification;
		}

		@Override
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

}
