/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.validator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.ResourceSetContext
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtend.core.validation.CachingResourceValidatorImpl
import org.eclipse.xtend.ide.macro.JdtBasedProcessorProvider.ProcessorClassloaderAdapter
import org.eclipse.xtext.service.OperationCanceledError

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendResourceValidator extends CachingResourceValidatorImpl {
	
	override validate(Resource resource, CheckMode mode, CancelIndicator mon) throws OperationCanceledError {
		try {
			super.validate(resource, mode, mon)
		} finally {
			// if validation was called in the editor, we want to close the URLClassloader
			if (ResourceSetContext.get(resource).isEditor) {
				val adapter = resource.eAdapters.filter(ProcessorClassloaderAdapter).head;
				resource.eAdapters.remove(adapter)
			}
		}
	}
	
}