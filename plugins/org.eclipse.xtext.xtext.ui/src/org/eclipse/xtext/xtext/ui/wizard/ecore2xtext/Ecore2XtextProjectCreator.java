/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import java.util.Collection;
import java.util.Set;

import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;

import com.google.common.collect.Sets;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Ecore2XtextProjectCreator extends XtextProjectCreator {

	@Override
	protected IProjectFactoryContributor createDslProjectContributor() {
		Ecore2XtextDslProjectContributor contributor = new Ecore2XtextDslProjectContributor(getXtextProjectInfo());
		contributor.setModelFolder(getModelFolderName());
		return contributor;
	}

	@Override
	protected Collection<String> getAdditionalRequiredBundles() {
		Ecore2XtextProjectInfo ecore2xtextProjectInfo = getXtextProjectInfo();
		Set<String> result = Sets.newHashSet();
		for (EPackageInfo packageInfo : ecore2xtextProjectInfo.getEPackageInfos()) {
			result.add(packageInfo.getBundleID());
			if (packageInfo.getGenmodelURI().fileExtension().equals("xcore")) {
				result.add("org.eclipse.emf.ecore.xcore");
			}
		}
		return result;
	}

	@Override
	protected Ecore2XtextProjectInfo getXtextProjectInfo() {
		return (Ecore2XtextProjectInfo) super.getXtextProjectInfo();
	}
}
