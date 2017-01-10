/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
