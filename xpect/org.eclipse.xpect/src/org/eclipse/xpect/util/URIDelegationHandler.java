/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.XpectConstants;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class URIDelegationHandler {

	public URI getOriginalURI(URI uri) {
		String ext = uri.fileExtension();
		if (ext == null || !"xt".equals(ext))
			return null;
		URI trimmed = uri.trimFileExtension();
		if (trimmed.fileExtension() == null)
			return null;
		return trimmed;
	}

	public String getOriginalFileExtension(String simpleFilename) {
		int end = simpleFilename.lastIndexOf('.');
		if (end > 0) {
			String ext = simpleFilename.substring(end + 1);
			if (ext.equals(XpectConstants.XT_FILE_EXT)) {
				int start = simpleFilename.lastIndexOf('.', end - 1);
				if (start >= 0)
					return simpleFilename.substring(start + 1, end);
			}
			return ext;
		}
		return null;
	}

}
