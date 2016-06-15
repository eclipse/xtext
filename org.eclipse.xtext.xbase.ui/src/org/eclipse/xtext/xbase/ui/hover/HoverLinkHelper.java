/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class HoverLinkHelper {
	
	public static String createLinkWithLabel(String scheme, org.eclipse.emf.common.util.URI uri, String label) {
		StringBuffer buf = new StringBuffer();
		String emfURI = uri.toString();
		String uriForLink = null;
		buf.append("<a href=\"");
		try {
			uriForLink = new URI(scheme, emfURI, null).toASCIIString();
		} catch (URISyntaxException e) {
			return "";
		}
		buf.append(uriForLink);
		buf.append("\">");
		buf.append(label);
		buf.append("</a>");
		return buf.toString();
	}
}
