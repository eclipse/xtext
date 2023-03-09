/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.UnknownNestedTypeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRuntimeJvmTypeProvider extends AbstractJvmTypeProvider {

	@Deprecated
	protected AbstractRuntimeJvmTypeProvider(ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		super(resourceSet, indexedJvmTypeAccess);
	}
	
	protected AbstractRuntimeJvmTypeProvider(ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess, TypeResourceServices services) {
		super(resourceSet, indexedJvmTypeAccess, services);
	}

	protected static class TypeInResourceSetAdapter extends AdapterImpl {
		
		private Map<String, JvmType> typeByQueryString = Maps.newHashMap();
		
		@Override
		public boolean isAdapterForType(Object type) {
			return TypeInResourceSetAdapter.class.equals(type);
		}
		
		public JvmType tryFindTypeInIndex(String name, AbstractRuntimeJvmTypeProvider typeProvider, boolean binaryNestedTypeDelimiter) throws UnknownNestedTypeException {
			JvmType result = typeByQueryString.get(name);
			if (result != null) {
				if (result.eIsProxy()) {
					typeByQueryString.remove(name);
				} else {
					return result;
				}
			}
			JvmType candidate = typeProvider.doTryFindInIndex(name, binaryNestedTypeDelimiter);
			if (candidate != null) {
				typeByQueryString.put(name, candidate);
				return candidate;
			}
			return null;
		}
		
	}
	
	protected static class ClassNotFoundExceptionWithBaseName extends ClassNotFoundException {

		private static final long serialVersionUID = 1L;
		private String baseName;
		
		public ClassNotFoundExceptionWithBaseName(String baseName) {
			this.baseName = baseName;
		}
		
		public String getBaseName() {
			return baseName;
		}
	}
	
	@Override
	protected void registerProtocol(ResourceSet resourceSet) {
		super.registerProtocol(resourceSet);
		resourceSet.eAdapters().add(new TypeInResourceSetAdapter());
	}

	/* @Nullable */
	protected JvmType doTryFindInIndex(String name, boolean binaryNestedTypeDelimiter) throws UnknownNestedTypeException {
		IndexedJvmTypeAccess indexAccess = getIndexedJvmTypeAccess();
		if (indexAccess != null) {
			JvmType result = doTryFindInIndex(name, indexAccess);
			if (result == null && !isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter)) {
				ClassNameVariants variants = new ClassNameVariants(name);
				while(result == null && variants.hasNext()) {
					String nextVariant = variants.next();
					result = doTryFindInIndex(nextVariant, indexAccess);
				}
			}
			return result;
		}
		return null;
	}
	
	private JvmType doTryFindInIndex(String name, IndexedJvmTypeAccess indexAccess) throws UnknownNestedTypeException {
		int index = name.indexOf('$');
		if (index < 0)
			index = name.indexOf('[');
		String qualifiedNameString = index < 0 ? name : name.substring(0, index);
		List<String> nameSegments = Strings.split(qualifiedNameString, '.');
		QualifiedName qualifiedName = QualifiedName.create(nameSegments);
		EObject candidate = indexAccess.getIndexedJvmType(qualifiedName, name, getResourceSet());
		if (candidate instanceof JvmType)
			return (JvmType) candidate;
		return null;
	}
	
	protected JvmType tryFindTypeInIndex(String name, boolean binaryNestedTypeDelimiter) {
		try {
			TypeInResourceSetAdapter adapter = (TypeInResourceSetAdapter) EcoreUtil.getAdapter(getResourceSet().eAdapters(), TypeInResourceSetAdapter.class);
			if (adapter != null) {
				return adapter.tryFindTypeInIndex(name, this, binaryNestedTypeDelimiter);
			} else {
				return doTryFindInIndex(name, binaryNestedTypeDelimiter);
			}
		} catch(UnknownNestedTypeException e) {
			return null;
		}
	}
}
