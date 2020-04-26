/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.imports;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

/**
 * @author dhuebner - Initial contribution and API
 */
public interface ImportsAcceptor {
	class DefaultImportsAcceptor implements ImportsAcceptor {
		private Set<String> types = new HashSet<>();

		private Set<String> staticImport = new HashSet<>();

		private Set<String> extensions = new HashSet<>();

		@Override
		public void acceptTypeImport(JvmType typeImport) {
			types.add(qualifiedNameWithout$(typeImport));
		}

		@Override
		public void acceptStaticImport(XAbstractFeatureCall statImport) {
			staticImport.add(qualifiedNameWithout$(statImport.getFeature()));
		}

		@Override
		public void acceptStaticExtensionImport(XAbstractFeatureCall extImport) {
			extensions.add(qualifiedNameWithout$(extImport.getFeature()));
		}

		private String qualifiedNameWithout$(JvmIdentifiableElement ele) {
			return ele.getQualifiedName('.');
		}

		public Set<String> getTypes() {
			return types;
		}

		public Set<String> getStaticImport() {
			return staticImport;
		}

		public Set<String> getExtensions() {
			return extensions;
		}
	}

	void acceptTypeImport(JvmType typeImport);

	void acceptStaticImport(XAbstractFeatureCall staticImport);

	void acceptStaticExtensionImport(XAbstractFeatureCall staticExtImport);
}
