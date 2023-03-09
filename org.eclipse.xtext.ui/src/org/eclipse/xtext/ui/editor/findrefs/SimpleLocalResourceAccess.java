/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class SimpleLocalResourceAccess implements IReferenceFinder.ILocalResourceAccess {

	private ResourceSet resourceSet;

	public SimpleLocalResourceAccess(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	@Override
	public <R> R readOnly(URI targetURI, IUnitOfWork<R, ResourceSet> work) {
		try {
			return work.exec(resourceSet);
		} catch(OperationCanceledException e) {
			throw e;
		} catch(Exception exc) {
			throw new WrappedException(exc);
		}
	}

}
