/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.formatting2;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;

import com.google.common.collect.Iterables;

public class FileAwareTestLanguageFormatter extends AbstractJavaFormatter {

	protected void format(PackageDeclaration pkg, IFormattableDocument doc) {
		doc.append(regionFor(pkg).feature(FileAwarePackage.Literals.PACKAGE_DECLARATION__NAME), it -> it.setNewLines(2));
		Import last = Iterables.getLast(pkg.getImports(), null);
		for (Import imp : pkg.getImports()) {
			doc.format(imp);
			doc.append(imp, it -> it.setNewLines(imp == last ? 2 : 1));
		}
		for (Element element : pkg.getContents()) {
			doc.format(element);
		}
	}

	protected void format(Element element, IFormattableDocument doc) {
		for (Element ele : element.getContents()) {
			doc.format(ele);
		}
	}
	
}
