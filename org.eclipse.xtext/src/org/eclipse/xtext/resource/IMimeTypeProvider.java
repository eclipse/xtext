/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import static java.util.Collections.*;

import java.util.List;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IMimeTypeProvider.DefaultImpl.class)
public interface IMimeTypeProvider {
	List<String> getMimeTypes();

	class DefaultImpl implements IMimeTypeProvider {
		@Override
		public List<String> getMimeTypes() {
			return emptyList();
		}
	}
}
