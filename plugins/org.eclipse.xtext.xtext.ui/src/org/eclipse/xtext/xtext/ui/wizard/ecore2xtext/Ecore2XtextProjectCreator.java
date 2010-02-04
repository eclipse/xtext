/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import java.util.Collection;

import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
public class Ecore2XtextProjectCreator extends XtextProjectCreator {

	@Override
	protected String getDslProjectTemplateName() {
		return "org::eclipse::xtext::xtext::ui::wizard::ecore2xtext::Ecore2XtextDslProject::main";
	}
	
	@Override
	protected Collection<String> getAdditionalRequiredBundles() {
		Ecore2XtextProjectInfo ecore2xtextProjectInfo = (Ecore2XtextProjectInfo) getXtextProjectInfo();
		return Lists.newArrayList(Iterables.transform(ecore2xtextProjectInfo.getEPackageInfos(), new Function<EPackageInfo, String>() {
			public String apply(EPackageInfo from) {
				return from.getBundleID();
			}
		}));
	}
	
}
