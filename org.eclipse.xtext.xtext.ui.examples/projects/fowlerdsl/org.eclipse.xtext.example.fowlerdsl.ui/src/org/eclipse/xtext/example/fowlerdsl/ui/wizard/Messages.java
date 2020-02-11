/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.example.fowlerdsl.ui.wizard.messages"; //$NON-NLS-1$
	
	public static String StatemachineProject_Label;
	public static String StatemachineProject_Description;
	public static String MrsGrantsSecretCompartments_Label;
	public static String MrsGrantsSecretCompartments_Description;
	public static String MrsGrantsSecretCompartmentsFile_Label;
	public static String MrsGrantsSecretCompartmentsFile_Description;
	public static String MrsGrantsSecretCompartmentsProject_Label;
	public static String MrsGrantsSecretCompartmentsProject_Description;
	public static String EmptyFile_Label;
	public static String EmptyFile_Description;
	
	static {
	// initialize resource bundle
	NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
