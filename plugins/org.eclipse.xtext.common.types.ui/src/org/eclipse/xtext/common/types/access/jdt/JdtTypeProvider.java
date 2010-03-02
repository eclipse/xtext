/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypeProvider extends AbstractTypeProvider {

	private final IJavaProject javaProject;

	private final TypeURIHelper typeUriHelper;

	private final JdtBasedTypeFactory typeFactory;
	
	public JdtTypeProvider(IJavaProject javaProject, ResourceSet resourceSet) {
		super(resourceSet);
		if (javaProject == null)
			throw new IllegalArgumentException("javaProject may not be null");
		this.javaProject = javaProject;
		this.typeUriHelper = createTypeURIHelper();
		this.typeFactory = createTypeFactory();
	}

	protected JdtBasedTypeFactory createTypeFactory() {
		return new JdtBasedTypeFactory(typeUriHelper);
	}

	protected TypeURIHelper createTypeURIHelper() {
		return new TypeURIHelper();
	}
	
	@Override
	public JvmType findTypeByName(String name) throws TypeNotFoundException {
		try {
			String signature = name.startsWith("[") ? name : Signature.createTypeSignature(name, true);
			URI resourceURI = typeUriHelper.createResourceURI(signature);
			TypeResource resource = (TypeResource) getResourceSet().getResource(resourceURI, true);
			JvmType result = findTypeBySignature(signature, resource);
			return result;
		} catch(JavaModelException ex) {
			 throw new TypeNotFoundException("Type: '" + name + "' is not available.", ex);
		}
	}

	public JvmType findTypeBySignature(String signature, TypeResource resource) throws TypeNotFoundException {
		// TODO: Maybe iterate the resource without computing a fragment
		try {
			String fragment = typeUriHelper.getFragment(signature);
			JvmType result = (JvmType) resource.getEObject(fragment);
			if (result == null) {
				throw new TypeNotFoundException("Type: '" + signature + "' is not available.");
			}
			return result;
		} catch(JavaModelException ex) {
			throw new TypeNotFoundException("Type: '" + signature + "' is not available.", ex);
		}
	}

	@Override
	protected IMirror createMirrorForFQN(String name) throws TypeNotFoundException {
		try {
			IType type = javaProject.findType(name);
			if (type == null)
				throw new TypeNotFoundException("No such type available '" + name + "'");
			return new JdtTypeMirror(type, typeFactory);
		}
		catch (JavaModelException e) {
			throw new TypeNotFoundException(name, e);
		}
	}
	
	public IJavaProject getJavaProject() {
		return javaProject;
	}
	
	public TypeURIHelper getTypeUriHelper() {
		return typeUriHelper;
	}
	
	public JdtBasedTypeFactory getJdtBasedTypeFactory() {
		return typeFactory;
	}

}
