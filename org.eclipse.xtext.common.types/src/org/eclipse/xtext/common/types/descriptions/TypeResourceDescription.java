/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.descriptions;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * More or less copied from NameBasedResourceDescription and
 * TypeResourceDescription to avoid dependency on common.types.ui
 *
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeResourceDescription extends AbstractResourceDescription {
	public static class ChangedDelta extends ChangedResourceDescriptionDelta {
		public ChangedDelta(QualifiedName javaTypeName) {
			super(null, new TypeResourceDescription(javaTypeName));
		}
	}

	public static class ClassDescription implements IEObjectDescription {
		private final QualifiedName qualifiedName;

		public ClassDescription(QualifiedName qualifiedName) {
			this.qualifiedName = qualifiedName;
		}

		@Override
		public EClass getEClass() {
			return null;
		}

		@Override
		public EObject getEObjectOrProxy() {
			throw new UnsupportedOperationException();
		}

		@Override
		public URI getEObjectURI() {
			throw new UnsupportedOperationException();
		}

		@Override
		public QualifiedName getName() {
			return qualifiedName;
		}

		@Override
		public String getUserData(String key) {
			return null;
		}

		@Override
		public String[] getUserDataKeys() {
			return Strings.EMPTY_ARRAY;
		}

		@Override
		public int hashCode() {
			return Objects.hash(qualifiedName);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ClassDescription other = (ClassDescription) obj;
			if (qualifiedName == null) {
				if (other.qualifiedName != null) {
					return false;
				}
			} else if (!qualifiedName.equals(other.qualifiedName)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("qualifiedName", qualifiedName);
			return b.toString();
		}

		@Override
		public QualifiedName getQualifiedName() {
			return qualifiedName;
		}
	}

	private final List<IEObjectDescription> exportedObjects;
	private final URI uri;

	public TypeResourceDescription(QualifiedName typeName) {
		uri = URIHelperConstants.OBJECTS_URI.appendSegment(typeName.toString("."));
		ClassDescription classDescription = new ClassDescription(
				typeName);
		exportedObjects = Collections.singletonList(classDescription);
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		return exportedObjects;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		return Collections.emptyList();
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Collections.emptyList();
	}

	@Override
	public URI getURI() {
		return uri;
	}
}
