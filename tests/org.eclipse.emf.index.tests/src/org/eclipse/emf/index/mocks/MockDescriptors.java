/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.mocks;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface MockDescriptors {

	public static final String EPACKAGE_NAME = "testPackage";

	public static final String EPACKAGE_NS_URI = "http://www.eclipse.org/emft/emfindex/test";

	public static final EPackageDescriptor ePackageDescriptor = new EPackageDescriptor() {

		private static final long serialVersionUID = -8319081858704627304L;

		public String getNsURI() {
			return EPACKAGE_NS_URI;
		}

		public String getName() {
			return EPACKAGE_NAME;
		}

		public long getIndexingDate() {
			return System.currentTimeMillis();
		}
		
		public EPackage getEPackage() {
			return null;
		};
	};

	public static final String SUPER_ECLASS_NAME = "SuperTestEClass";

	public static final EClassDescriptor superClassDescriptor = new EClassDescriptor() {

		private static final long serialVersionUID = 4637438945378827431L;

		public String getDisplayName() {
			return SUPER_ECLASS_NAME;
		}

		public EPackageDescriptor getEPackageDescriptor() {
			return ePackageDescriptor;
		}

		public String getName() {
			return SUPER_ECLASS_NAME;
		}

		public EClassDescriptor[] getSuperClasses() {
			return null;
		}

		public EClass getEClass() {
			return null;
		}
	};

	public static final String ECLASS_NAME = "TestEClass";

	public static final EClassDescriptor eClassDescriptor = new EClassDescriptor() {

		private static final long serialVersionUID = -5409945758036893934L;

		public String getDisplayName() {
			return ECLASS_NAME;
		}

		public EPackageDescriptor getEPackageDescriptor() {
			return ePackageDescriptor;
		}

		public String getName() {
			return ECLASS_NAME;
		}

		public EClassDescriptor[] getSuperClasses() {
			return new EClassDescriptor[] { superClassDescriptor };
		}

		public EClass getEClass() {
			return null;
		}
	};

	public static final String RESOURCE_URI = "http://www.eclipse.org/emft/emfindex/test";

	public static final ResourceDescriptor resourceDescriptor = new ResourceDescriptor() {

		private static final long serialVersionUID = 3428062491611406998L;

		public long getIndexingDate() {
			return System.currentTimeMillis();
		}

		public String getURI() {
			return RESOURCE_URI;
		}

		public Map<String, Serializable> getUserData() {
			return null;
		}

		public Serializable getUserData(String key) {
			return null;
		}
	};

	public static final String EOBJECT_NAME = "TestEObject";

	public static final String EOBJECT_FRAGMENT = "/";

	public static final String USER_DATA_VALUE = "someValue";

	public static final String USER_DATA_KEY = "someKey";

	public static final EObjectDescriptor eObjectDescriptor = new EObjectDescriptor() {

		private static final long serialVersionUID = 9196198411930423964L;

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

		public Serializable getUserData(String key) {
			if (USER_DATA_KEY.equals(key))
				return USER_DATA_VALUE;
			return null;
		}

		public Map<String, Serializable> getUserData() {
			Map<String,Serializable> userData = new HashMap<String,Serializable>();
			userData.put(USER_DATA_KEY, USER_DATA_VALUE);
			return userData;
		}

	};

	public static final String ECROSS_REFERENCE_NAME = "someReference";

	public static final EReferenceDescriptor eReferenceDescriptor = new EReferenceDescriptor() {

		private static final long serialVersionUID = 7536329101355343725L;

		public String getReferenceName() {
			return ECROSS_REFERENCE_NAME;
		}

		public String getSourceFragment() {
			return EOBJECT_FRAGMENT;
		}

		public String getTargetFragment() {
			return EOBJECT_FRAGMENT;
		}

		public int getIndex() {
			return 0;
		}

		public ResourceDescriptor getSourceResourceDescriptor() {
			return resourceDescriptor;
		}

		public URI getSourceURI() {
			return eObjectDescriptor.getFragmentURI();
		}

		public ResourceDescriptor getTargetResourceDescriptor() {
			return resourceDescriptor;
		}

		public URI getTargetURI() {
			return eObjectDescriptor.getFragmentURI();
		}

	};

}
