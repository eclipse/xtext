/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import org.eclipse.osgi.util.NLS;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.xtext.ui.wizard.releng.messages"; //$NON-NLS-1$
	public static String ProjectInfoBinder_errorFeatureNotExists;
	public static String ProjectInfoBinder_errorFeatureNotSelected;
	public static String ProjectInfoBinder_warnBuckyHeadlessNotSet;
	public static String ProjectInfoBinder_warnNotBucky;
	public static String WizardNewRelengProjectCreationPage_addTestButton;
	public static String WizardNewRelengProjectCreationPage_browseButton;
	public static String WizardNewRelengProjectCreationPage_buckyGroupLbl;
	public static String WizardNewRelengProjectCreationPage_buckminsteInstallText;
	public static String WizardNewRelengProjectCreationPage_buckyInstallFieldLbl;
	public static String WizardNewRelengProjectCreationPage_buckyControlInfo;
	public static String WizardNewRelengProjectCreationPage_featFieldLbl;
	public static String WizardNewRelengProjectCreationPage_pageDescr;
	public static String WizardNewRelengProjectCreationPage_pageTitle;
	public static String WizardNewRelengProjectCreationPage_prjGroupLbl;
	public static String WizardNewRelengProjectCreationPage_relPrjFieldLbl;
	public static String WizardNewRelengProjectCreationPage_removeTestButton;
	public static String WizardNewRelengProjectCreationPage_selectButton;
	public static String WizardNewRelengProjectCreationPage_sitePrjFieldLbl;
	public static String WizardNewRelengProjectCreationPage_testsListLbl;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
