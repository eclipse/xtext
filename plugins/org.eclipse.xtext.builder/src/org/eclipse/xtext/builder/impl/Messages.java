/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.osgi.util.NLS;

/**
 * @author koehnlein - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.builder.impl.messages"; //$NON-NLS-1$
	public static String BuildScheduler_0;
	public static String BuildScheduler_1;
	public static String BuildScheduler_2;
	public static String ProjectOpenedOrClosedListener_0;
	public static String ProjectOpenedOrClosedListener_1;
	public static String RegistryBuilderParticipant_2;
	public static String ToBeBuiltComputer_0;
	public static String XtextBuilder_0;
	public static String XtextBuilder_1;
	public static String XtextBuilder_2;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
