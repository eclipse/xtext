/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.osgi.util.NLS;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.builder.impl.messages"; //$NON-NLS-1$
	public static String BuildScheduler_BuildOf;
	public static String BuildScheduler_FailedEtc;
	public static String BuildScheduler_JobName;
	public static String BuildScheduler_SingleJobName;
	public static String BuildScheduler_TwoJobsName;
	public static String BuildScheduler_ManyJobsName;
	public static String ProjectOpenedOrClosedListener_FromIndex;
	public static String ProjectOpenedOrClosedListener_RemovingProject;
	public static String RegistryBuilderParticipant_InvokingBuildParticipants;
	public static String ToBeBuiltComputer_CollectingResources;
	public static String XtextBuilder_Building;
	public static String XtextBuilder_CollectingResources;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
