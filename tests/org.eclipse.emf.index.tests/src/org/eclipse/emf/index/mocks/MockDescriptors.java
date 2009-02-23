/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.mocks;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface MockDescriptors {

	public static final String EPACKAGE_NAME = "testPackage";

	public static final String EPACKAGE_NS_URI = "http://www.eclipse.org/emft/emfindex/test";

	public static final EPackageDescriptor ePackageDescriptor = new EPackageDescriptor() {
		public String getNsURI() {
			return EPACKAGE_NS_URI;
		}

		public String getName() {
			return EPACKAGE_NAME;
		}

		public long getIndexingDate() {
			return System.currentTimeMillis();
		}
	};

	public static final String ECLASS_NAME = "TestEClass";

	public static final EClassDescriptor eClassDescriptor = new EClassDescriptor() {
		public String getDisplayName() {
			return ECLASS_NAME;
		}

		public EPackageDescriptor getEPackageDescriptor() {
			return ePackageDescriptor;
		}

		public String getName() {
			return ECLASS_NAME;
		}
	};

	public static final String RESOURCE_URI = "http://www.eclipse.org/emft/emfindex/test";

	public static final ResourceDescriptor resourceDescriptor = new ResourceDescriptor() {

		public long getIndexingDate() {
			return System.currentTimeMillis();
		}

		public String getURI() {
			return RESOURCE_URI;
		}
	};

	public static final String EOBJECT_NAME = "TestEObject";

	public static final String EOBJECT_FRAGMENT = "/";

	public static final String USER_DATA_VALUE = "someValue";

	public static final String USER_DATA_KEY = "someKey";

	public static final EObjectDescriptor eObjectDescriptor = new EObjectDescriptor() {

		public String getDisplayName() {
			return EOBJECT_NAME;
		}

		public EClassDescriptor getEClassDescriptor() {
			return eClassDescriptor;
		}

		public String getFragment() {
			return EOBJECT_FRAGMENT;
		}

		public URI getFragmentURI() {
			return URI.createURI(resourceDescriptor.getURI()).appendFragment(getFragment());
		}

		public String getName() {
			return EOBJECT_NAME;
		}

		public ResourceDescriptor getResourceDescriptor() {
			return resourceDescriptor;
		}

		public String getUserData(String key) {
			if (USER_DATA_KEY.equals(key))
				return USER_DATA_VALUE;
			return null;
		}

	};

	public static final String ECROSS_REFERENCE_NAME = "someReference";

	public static final ECrossReferenceDescriptor eCrossReferenceDescriptor = new ECrossReferenceDescriptor() {

		public String getReferenceName() {
			return ECROSS_REFERENCE_NAME;
		}

		public EObjectDescriptor getSource() {
			return eObjectDescriptor;
		}

		public EObjectDescriptor getTarget() {
			return eObjectDescriptor;
		}

	};

}
