/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NameBasedFilter implements UriFilter {

	private String extension;
	
	private Pattern regularExpression;
	
	@Override
	public boolean matches(URI uri) {
		if (uri == null)
			return false;
		if (extension != null) {
			if (!extension.equalsIgnoreCase(uri.fileExtension()))
				return false;
		}
		if (regularExpression != null) {
			if (!regularExpression.matcher(uri.toString()).find())
				return false;
		}
		return true;
	}

	/**
	 * Filter based on the URI-attribute 'fileExtension'. The filter is applied ignore-case.
	 * Can be combined with an additional regular expression.
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}

	/**
	 * Filter the URI based on a regular expression.
	 * Can be combined with an additional file-extension filter.
	 */
	public void setRegularExpression(String regularExpression) {
		if (regularExpression != null)
			this.regularExpression = Pattern.compile(regularExpression);
		else
			this.regularExpression = null;
	}

	public Pattern getRegularExpression() {
		return regularExpression;
	}

}
