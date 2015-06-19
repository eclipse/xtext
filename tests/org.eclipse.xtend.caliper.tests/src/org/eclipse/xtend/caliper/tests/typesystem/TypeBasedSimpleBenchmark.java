/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.caliper.SimpleBenchmark;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class TypeBasedSimpleBenchmark extends SimpleBenchmark {

	public enum Type {
		CLONEABLE {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Cloneable");
				return owner.newParameterizedTypeReference(type);
			}
		},
		DOUBLE {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("double");
				return owner.newParameterizedTypeReference(type);
			}
		},
		ELIST_SUBTYPE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("org.eclipse.emf.ecore.util.EcoreEMap$Unsettable$UnsettableDelegateEObjectContainmentWithInverseEList");
				ParameterizedTypeReference result = owner.newParameterizedTypeReference(type);
				result.addTypeArgument(STRING.getReference(typeProvider, owner));
				return result;
			}
		},
		INT {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("int");
				return owner.newParameterizedTypeReference(type);
			}
		},
		INT_ARRAY {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("int");
				ParameterizedTypeReference componentType = owner.newParameterizedTypeReference(type);
				return owner.newArrayTypeReference(componentType);
			}
		},
		INT_ARRAY_ARRAY_ARRAY {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("int");
				ParameterizedTypeReference componentType = owner.newParameterizedTypeReference(type);
				return owner.newArrayTypeReference(owner.newArrayTypeReference(owner.newArrayTypeReference(componentType)));
			}
		},
		OBJECT {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Object");
				return owner.newParameterizedTypeReference(type);
			}
		},
		OBJECT_ARRAY {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Object");
				ParameterizedTypeReference componentType = owner.newParameterizedTypeReference(type);
				return owner.newArrayTypeReference(componentType);
			}
		},
		RAW_ARRAYLIST {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.util.ArrayList");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_COMPARABLE {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Comparable");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_ELIST_SUBTYPE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("org.eclipse.emf.ecore.util.EcoreEMap$Unsettable$UnsettableDelegateEObjectContainmentWithInverseEList");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_ITERABLE {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Iterable");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_MAP {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.util.Map");
				return owner.newParameterizedTypeReference(type);
			}
		},
		STRING {
			@Override
			LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.String");
				return owner.newParameterizedTypeReference(type);
			}
		},
		XMEMBER_FEATURE_CALL_IMPL_CUSTOM {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("org.eclipse.xtext.xbase.impl.XMemberFeatureCallImplCustom");
				return owner.newParameterizedTypeReference(type);
			}
		},
		;
		abstract LightweightTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner);
	}
	
	private IndexedJvmTypeAccess indexedAccess = new IndexedJvmTypeAccess() {
		@Override
		public EObject getIndexedJvmType(QualifiedName qualifiedName, String fragment, ResourceSet resourceSet) {
			return null;
		}

		@Override
		public EObject getIndexedJvmType(URI javaObjectURI, ResourceSet resourceSet) {
			return null;
		}
	};

	private StandardTypeReferenceOwner owner;
	private ClasspathTypeProvider typeProvider;
	
	protected LightweightTypeReference getTypeReference(Type type) {
		LightweightTypeReference result = type.getReference(typeProvider, owner);
		if (isResolveAll()) {
			EcoreUtil.resolveAll(owner.getContextResourceSet());
		}
		return result;
	}
	
	protected boolean isResolveAll() {
		return true;
	}
	
	@Override
	protected void setUp() throws Exception {
		Injector injector = new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = new XtextResourceSet();
		ClassLoader loader = getClass().getClassLoader();
		resourceSet.setClasspathURIContext(loader);
		typeProvider = new ClasspathTypeProvider(loader, resourceSet, indexedAccess, null);
		CommonTypeComputationServices services = injector.getInstance(CommonTypeComputationServices.class);
		owner = new StandardTypeReferenceOwner(services, resourceSet);
	}
	
}
