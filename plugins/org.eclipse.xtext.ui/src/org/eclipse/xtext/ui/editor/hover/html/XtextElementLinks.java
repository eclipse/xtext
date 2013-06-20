/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Inject;

// Clone of org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks
// Removed all java specific parts

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class XtextElementLinks {

	/**
	 * A handler is asked to handle links to targets.
	 *
	 * @see XtextElementLinks#createLocationListener(XtextElementLinks.ILinkHandler)
	 */
	public interface ILinkHandler {

		/**
		 * Handle normal kind of link to given target.
		 *
		 * @param uri the target to show
		 */
		void handleInlineXtextdocLink(org.eclipse.emf.common.util.URI  uri);

		/**
		 * Handle link to given target to open in Xtextdoc view.
		 *
		 * @param uri the target to show
		 */
		void handleXtextdocViewLink(org.eclipse.emf.common.util.URI  uri);

		/**
		 * Handle link to given target to open its declaration
		 *
		 * @param uri the target to show
		 */
		void handleDeclarationLink(org.eclipse.emf.common.util.URI  uri);

		/**
		 * Handle link to given link to open in external browser
		 *
		 * @param url the url to show
		 * @param display the current display
		 * @return <code>true</code> if the handler could open the link
		 *         <code>false</code> if the browser should follow the link
		 */
		boolean handleExternalLink(URL url, Display display);

		/**
		 * Informs the handler that the text of the browser was set.
		 */
		void handleTextSet();
	}	
	
	@Inject
	ILabelProvider labelProvider;
	
	private static final Logger log = Logger.getLogger(XtextElementLinks.class);
	
	// should be all lower case (Internet Explorer issue)
	public static final String OPEN_LINK_SCHEME= "eclipse-xtext-open"; //$NON-NLS-1$
	public static final String XTEXTDOC_SCHEME= "eclipse-xtext-doc"; //$NON-NLS-1$
	public static final String XTEXTDOC_VIEW_SCHEME= "eclipse-xtext-doc-view"; //$NON-NLS-1$
	
	public LocationListener createLocationListener(final ILinkHandler handler) {
		return new XtextLinkAdapter(handler);
	}

	public String createLink (EObject o) {
		return createLink (XTEXTDOC_SCHEME, o);
	}

	public String createLink (String scheme, EObject o) {
		return createLink (scheme, o, labelProvider.getText (o));
	}
	
	public String createLink (String scheme, EObject o, String elementName) {
		try {
			return createLink (createURI (scheme, o), elementName);
		} catch (URISyntaxException e) {
			log.warn("Could not create Link for "+elementName, e);
		} 
		return elementName;
	}	
	
	public String createLink (String uri, String elementName) {
		return "<a class='header' href='" + uri + ("'>" + elementName + "</a>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	public String createURI(String scheme, EObject o) throws URISyntaxException {
		return new URI (scheme, createURI(o).toString(), null).toASCIIString();
	}
	
	public org.eclipse.emf.common.util.URI parseURI(URI uri) {
		return org.eclipse.emf.common.util.URI.createURI(uri.getSchemeSpecificPart());
	}

	private org.eclipse.emf.common.util.URI createURI(EObject o) {
		return o.eResource().getURI().appendFragment(o.eResource().getURIFragment(o));
	}
	/**
	 * @since 2.3
	 */
	protected class XtextLinkAdapter extends LocationAdapter {
		protected ILinkHandler handler;

		protected XtextLinkAdapter(ILinkHandler handler) {
			this.handler = handler;
		}
		
		@Override
		public void changing(LocationEvent event) {
			String loc= event.location;
			URI uri = initURI(event);
			if(uri == null)
				return;
			String scheme= uri.getScheme();
			if (XtextElementLinks.XTEXTDOC_VIEW_SCHEME.equals(scheme)) {
				org.eclipse.emf.common.util.URI linkTarget= parseURI(uri);
				if (linkTarget == null)
					return;

				handler.handleXtextdocViewLink(linkTarget);
			} else if (XtextElementLinks.XTEXTDOC_SCHEME.equals(scheme)) {
				org.eclipse.emf.common.util.URI linkTarget= parseURI(uri);
				if (linkTarget == null)
					return;

				handler.handleInlineXtextdocLink(linkTarget);
			} else if (XtextElementLinks.OPEN_LINK_SCHEME.equals(scheme)) {
				org.eclipse.emf.common.util.URI linkTarget= parseURI(uri);
				if (linkTarget == null)
					return;

				handler.handleDeclarationLink(linkTarget);
			} else {
				try {
					if (handler.handleExternalLink(new URL(loc), event.display))
						return;

					event.doit= true;
				} catch (MalformedURLException e) {
					log.warn("Could not handle location"+loc, e);
				}
			}
		}
		
		protected URI initURI(LocationEvent event){
			String loc= event.location;
			if ("about:blank".equals(loc)) { //$NON-NLS-1$
				/*
				 * Using the Browser.setText API triggers a location change to "about:blank".
				 * remove this code once https://bugs.eclipse.org/bugs/show_bug.cgi?id=130314 is fixed
				 */
				//input set with setText
				handler.handleTextSet();
				return null;
			}

			event.doit= false;

			if (loc.startsWith("about:")) { //$NON-NLS-1$
				// Relative links should be handled via head > base tag.
				// If no base is available, links just won't work.
				return null;
			}

			URI uri;
			try {
				uri= new URI(loc);
			} catch (URISyntaxException e) {
				// try it with a file (workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=237903 ):
				File file= new File(loc);
				if (! file.exists()) {
					log.warn("Could not handle location"+loc, e);
					return null;
				}
				uri= file.toURI();
			}
			return uri;

		}
	}
	
}
