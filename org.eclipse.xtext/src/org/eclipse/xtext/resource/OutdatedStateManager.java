/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
public class OutdatedStateManager {
	@Inject
	private OperationCanceledManager canceledManager;

	private final ThreadLocal<Boolean> cancelationAllowed = new ThreadLocal<Boolean>() {
		@Override
		public Boolean initialValue() {
			return true;
		}
	};

	/**
	 * Created a fresh CancelIndicator
	 */
	public CancelIndicator newCancelIndicator(ResourceSet rs) {
		if (rs instanceof XtextResourceSet) {
			boolean isCancelationAllowed = cancelationAllowed.get().booleanValue();
			XtextResourceSet xtextRs = (XtextResourceSet) rs;
			int current = xtextRs.getModificationStamp();
			return () -> isCancelationAllowed && (xtextRs.isOutdated() || current != xtextRs.getModificationStamp());
		} else {
			return CancelIndicator.NullImpl;
		}
	}

	/**
	 * Checks whether the given ResourceSet is in an outdated state and throws an {@link OperationCanceledError} if so.
	 */
	public void checkCanceled(ResourceSet rs) {
		if (rs instanceof XtextResourceSet)
			if (((XtextResourceSet) rs).isOutdated() && cancelationAllowed.get().booleanValue())
				canceledManager.throwOperationCanceledException();
	}

	public <R extends Object, P extends Resource> R exec(IUnitOfWork<R, P> work, P param) {
		Boolean wasCancelationAllowed = cancelationAllowed.get();
		try {
			if (work instanceof CancelableUnitOfWork) {
				((CancelableUnitOfWork<?, ?>) work)
						.setCancelIndicator((param == null) ? () -> true : newCancelIndicator(param.getResourceSet()));
			} else {
				cancelationAllowed.set(false);
			}
			return work.exec(param);
		} catch (Throwable e) {
			return Exceptions.throwUncheckedException(e);
		} finally {
			cancelationAllowed.set(wasCancelationAllowed);
		}
	}
}
