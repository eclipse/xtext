/*******************************************************************************
 * Copyright (c) 2020 Karakun GmbH (http://www.karakun.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide;

import org.osgi.framework.BundleContext;

/**
 * @author Karsten Thoms - Initial contribution and API
 */
public class XtendActivator extends org.eclipse.xtend.ide.internal.XtendActivator {

	// private XtendThemeManager themeManager;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		/* disabled due to issue#1173
		getEventBroker().ifPresent(eventBroker -> {
			themeManager = new XtendThemeManager();
			eventBroker.subscribe(IThemeEngine.Events.THEME_CHANGED, themeManager);
			Display.getCurrent().asyncExec(() -> 
				themeManager.handleEvent(new Event(IThemeEngine.Events.THEME_CHANGED, emptyMap()))
			);
		});
		*/
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		/* disabled due to issue#1173
		getEventBroker().ifPresent(eventBroker -> {
			if (themeManager != null) {
				eventBroker.unsubscribe(themeManager);
			}
		});
		*/
		super.stop(context);
	}

	/* disabled due to issue#1173
	private Optional<IEventBroker> getEventBroker() {
		return Optional.ofNullable(PlatformUI.getWorkbench().getService(IEventBroker.class));
	}
	*/

}
