/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionTraceMissingException extends RuntimeException {

	private static final long serialVersionUID = -1151660462702454003L;

	public RegionTraceMissingException(Throwable cause) {
		super(cause);
	}

}
