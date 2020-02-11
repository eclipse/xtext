/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import java.net.URL;

import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

// cloned from org.eclipse.jdt.internal.ui.actions.OpenBrowserUtil,
// does not differ from the original class

/**
 * This is a clone from JDT's JavadocHover class
 * 
 * @author Christoph Kulla - Initial contribution and API
 */
public class OpenBrowserUtil {

	public static void open(final URL url, Display display) {
		display.syncExec(new Runnable() {
			@Override
			public void run() {
				internalOpen(url, false);
			}
		});
	}

	public static void openExternal(final URL url, Display display) {
		display.syncExec(new Runnable() {
			@Override
			public void run() {
				internalOpen(url, true);
			}
		});
	}

	private static void internalOpen(final URL url, final boolean useExternalBrowser) {
		BusyIndicator.showWhile(null, new Runnable() {
			@Override
			public void run() {
				URL helpSystemUrl= PlatformUI.getWorkbench().getHelpSystem().resolve(url.toExternalForm(), true);
				try {
					IWorkbenchBrowserSupport browserSupport = PlatformUI.getWorkbench().getBrowserSupport();
					IWebBrowser browser;
					if (useExternalBrowser)
						browser= browserSupport.getExternalBrowser();
					else
						browser= browserSupport.createBrowser(null);
					browser.openURL(helpSystemUrl);
				} catch (PartInitException ex) {
				}
			}
		});
	}

}
