/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tests;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;

import com.google.common.base.Strings;

/**
 * @author spoenemann - Initial contribution and API
 */
public class TestsEMFGeneratorFragment extends EMFGeneratorFragment2 {
	private String ecoreModel;

	private String genModel;

	public TestsEMFGeneratorFragment() {
		setUpdateBuildProperties(false);
	}

	@Override
	public void setGenModel(String genModel) {
		this.genModel = genModel;
		super.setGenModel(genModel);
	}

	@Override
	protected String getEcoreFilePath(Grammar grammar) {
		if (!Strings.isNullOrEmpty(ecoreModel)) {
			return ecoreModel;
		} else {
			return getJavaModelDirectory() + "/"
					+ grammar.getName().substring(0, grammar.getName().lastIndexOf(".")).replace(".", "/") + "/"
					+ getModelName(grammar) + ".ecore";
		}
	}

	@Override
	protected String getGenModelPath(Grammar grammar) {
		if (!Strings.isNullOrEmpty(genModel)) {
			return genModel;
		} else {
			return getJavaModelDirectory() + "/"
					+ grammar.getName().substring(0, grammar.getName().lastIndexOf(".")).replace(".", "/") + "/"
					+ getModelName(grammar) + ".genmodel";
		}
	}

	public void setEcoreModel(String ecoreModel) {
		this.ecoreModel = ecoreModel;
	}
}
