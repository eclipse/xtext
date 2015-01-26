/*******************************************************************************
 * Copyright (c) 2009-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.access.jdt.AbstractJdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JavaProjectAccessTypeProvider extends AbstractJdtTypeProvider implements IJdtTypeProvider {
	
	private final JavaProjectAccessBasedTypeFactory typeFactory;
	
	private final JavaProjectAccess javaProjectAccess;

	public JavaProjectAccessTypeProvider(JavaProject javaProject, ResourceSet resourceSet) {
		this(javaProject, resourceSet, null, null, null);
	}
	
	/**
	 * @since 2.8
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public JavaProjectAccessTypeProvider(
			JavaProject javaProject,
			ResourceSet resourceSet,
			IndexedJvmTypeAccess indexedJvmTypeAccess,
			WorkingCopyOwner workingCopyOwner,
			TypeResourceServices services) {
		super(javaProject, resourceSet, indexedJvmTypeAccess, services);
		if (javaProject == null)
			throw new IllegalArgumentException("javaProjectAccess may not be null");
		this.javaProjectAccess = createJavaProjectAccess(javaProject, workingCopyOwner);
		this.typeFactory = createTypeFactory();
	}

	private JavaProjectAccess createJavaProjectAccess(JavaProject javaProject, WorkingCopyOwner owner) {
		if (isBuilderScope()) {
			return new JavaProjectAccess(javaProject, new BuilderWorkingCopies(owner));
		} else {
			return new EditorJavaProjectAccess(javaProject, new EditorWorkingCopies(owner));
		}
	}

	protected JavaProjectAccessBasedTypeFactory createTypeFactory() {
		return new JavaProjectAccessBasedTypeFactory(getTypeUriHelper(), javaProjectAccess);
	}

	@Override
	protected IType findObjectTypeInJavaProject(String packageName, String typeName) throws JavaModelException {
		IType type = javaProjectAccess.findType(packageName, typeName);
		if (type != null && !canLink(type)) {
			return null;
		}
		return type;
	}

	@Override
	protected IPackageFragmentRoot[] getPackageFragmentRoots() throws JavaModelException {
		return javaProjectAccess.getPackageFragmentRoots();
	}

	@Override
	public JavaProjectAccessBasedTypeFactory getJdtBasedTypeFactory() {
		return typeFactory;
	}

}
