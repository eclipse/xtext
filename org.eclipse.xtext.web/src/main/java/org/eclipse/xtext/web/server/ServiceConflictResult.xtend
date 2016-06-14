/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import org.eclipse.xtend.lib.annotations.Data

/**
 * A service result object indicating that a conflict has occurred an thus the original
 * request could not be completed. This result type is used to avoid responses with
 * error codes for conflict situations that can happen relatively often, e.g. when
 * multiple requests are sent within a short amount of time.
 */
@Data
class ServiceConflictResult implements IServiceResult {
	
	/**
	 * A descriptor of the reason for the conflict. Commonly used values are "invalidStateId"
	 * for cases when the <i>requiredStateId</i> parameter does not match the current document state,
	 * and "canceled" when the service has been interrupted by another service request.
	 */
	String conflict
	
}