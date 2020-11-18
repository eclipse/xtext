/*******************************************************************************
 * Copyright (c) 2020 Karakun GmbH (http://www.karakun.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide;

import static java.util.Collections.*;

import java.util.Optional;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.ide.highlighting.XtendThemeManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;

/**
 * @author Karsten Thoms - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtendActivator extends org.eclipse.xtend.ide.internal.XtendActivator {

	private XtendThemeManager themeManager;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		getEventBroker().ifPresent(eventBroker -> {
			themeManager = new XtendThemeManager();
			eventBroker.subscribe(IThemeEngine.Events.THEME_CHANGED, themeManager);
			Display.getCurrent().asyncExec(() -> 
				themeManager.handleEvent(new Event(IThemeEngine.Events.THEME_CHANGED, emptyMap()))
			);
		});
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		getEventBroker().ifPresent(eventBroker -> {
			if (themeManager != null) {
				eventBroker.unsubscribe(themeManager);
			}
		});
		super.stop(context);
	}

	private Optional<IEventBroker> getEventBroker() {
		return Optional.ofNullable(PlatformUI.getWorkbench().getService(IEventBroker.class));
	}

}
