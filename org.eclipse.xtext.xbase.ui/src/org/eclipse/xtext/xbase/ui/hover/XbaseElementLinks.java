/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.net.URI;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseElementLinks extends XtextElementLinks {

	public interface IXbaseLinkHandler extends ILinkHandler {
		
		/**
		 * Handle normal kind of link to given target.
		 *
		 * @param target the target to show
		 */
		void handleInlineJavadocLink(IJavaElement target);
	}
	
	public LocationListener createLocationListener(IXbaseLinkHandler handler) {
		return new XbaseLinkAdapter(handler);
	}
	
	protected class XbaseLinkAdapter extends XtextLinkAdapter{
		protected  IXbaseLinkHandler handler;
		protected XbaseLinkAdapter(IXbaseLinkHandler handler) {
			super(handler);
			this.handler = handler;
		}
		
		@SuppressWarnings("restriction")
		@Override
		public void changing(LocationEvent event) {
			URI uri = initURI(event);
			if(uri == null)
				return;
			String scheme= uri.getScheme();
			if (org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks.JAVADOC_SCHEME.equals(scheme)) {
				IJavaElement linkTarget= org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks.parseURI(uri);
				if (linkTarget == null)
					return;
				handler.handleInlineJavadocLink(linkTarget);
				return;
			}
			super.changing(event);
			
		}
		
	}
	
}
