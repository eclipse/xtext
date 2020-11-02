/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.editor.quickfix;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.tests.serializer.ChangeSerializerTestHelper;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Iterators;

/**
 * 
 * @author Heinrich Weichert
 */
class QuickFixTestHelper extends ChangeSerializerTestHelper {

	@Override
	public <T extends Object> T findFirstOfTypeInFile(ResourceSet rs, String fileName, Class<T> type) {
		// iterating over all contents to find first nested element of type T
		URI uri = URI.createURI(fileName);
		T root = IteratorExtensions.<T> head(Iterators.<T> filter(rs.getResource(uri, true).getAllContents(), type));

		return root;
	}
}
