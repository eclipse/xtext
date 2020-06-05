/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A service result object indicating that a conflict has occurred and thus the
 * original request could not be completed. This result type is used to avoid
 * responses with error codes for conflict situations that can happen relatively
 * often, e.g. when multiple requests are sent within a short amount of time.
 */
public class ServiceConflictResult implements IServiceResult {
	/**
	 * A descriptor of the reason for the conflict. Commonly used values are
	 * "invalidStateId" for cases when the <i>requiredStateId</i> parameter does not
	 * match the current document state, and "canceled" when the service has been
	 * interrupted by another service request.
	 */
	private final String conflict;

	public ServiceConflictResult(String conflict) {
		this.conflict = conflict;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conflict == null) ? 0 : conflict.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceConflictResult other = (ServiceConflictResult) obj;
		if (conflict == null) {
			if (other.conflict != null)
				return false;
		} else if (!conflict.equals(other.conflict))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("conflict", this.conflict);
		return b.toString();
	}

	public String getConflict() {
		return conflict;
	}
}
