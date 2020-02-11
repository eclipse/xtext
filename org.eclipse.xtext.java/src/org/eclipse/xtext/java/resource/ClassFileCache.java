/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.resource;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * A cache for parsed class or java source file content. It is bound to the lifecycle of a resource set.
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.15
 */
public class ClassFileCache {
	public static class ClassFileCacheAdapter extends AdapterImpl {
		private ClassFileCache element;

		public ClassFileCacheAdapter(ClassFileCache element) {
			this.element = element;
		}

		public ClassFileCache get() {
			return this.element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == ClassFileCache.class;
		}
	}

	private static final Object NULL = new Object();

	private final Map<QualifiedName, Object> cache = new ConcurrentHashMap<>();

	private final Set<Resource> resourcesToCompile = Collections
			.newSetFromMap(new ConcurrentHashMap<>());

	private final Map<char[], List<String>> allTopLevelTypes = new ConcurrentHashMap<>();

	private final Map<char[], Map<String, byte[]>> allClassMaps = new ConcurrentHashMap<>();

	public boolean containsKey(QualifiedName qualifiedName) {
		return cache.containsKey(qualifiedName);
	}

	public IBinaryType get(QualifiedName qualifiedName) {
		Object result = cache.get(qualifiedName);
		if (result == ClassFileCache.NULL) {
			return null;
		}
		return (IBinaryType) result;
	}

	public void put(QualifiedName qualifiedName, IBinaryType answer) {
		if (answer == null) {
			cache.put(qualifiedName, ClassFileCache.NULL);
		} else {
			cache.put(qualifiedName, answer);
		}
	}

	public IBinaryType computeIfAbsent(QualifiedName qualifiedName,
			Function<? super QualifiedName, ? extends IBinaryType> fun) {
		Object result = this.cache.computeIfAbsent(qualifiedName, (QualifiedName fqn) -> {
			IBinaryType binaryType = fun.apply(fqn);
			if (binaryType != null) {
				return binaryType;
			} else {
				return ClassFileCache.NULL;
			}
		});
		if (result instanceof IBinaryType) {
			return (IBinaryType) result;
		}
		return null;
	}

	public void clear() {
		cache.clear();
		resourcesToCompile.clear();
		allTopLevelTypes.clear();
		allClassMaps.clear();
	}

	public void addResourceToCompile(Resource resource) {
		resourcesToCompile.add(resource);
	}

	public Set<Resource> drainResourcesToCompile() {
		HashSet<Resource> result = new HashSet<Resource>(resourcesToCompile);
		resourcesToCompile.clear();
		return result;
	}

	public boolean popCompileResult(char[] fileName,
			Procedure2<? super List<String>, ? super Map<String, byte[]>> consumer) {
		if (allTopLevelTypes.containsKey(fileName)) {
			consumer.apply(allTopLevelTypes.remove(fileName), allClassMaps.remove(fileName));
			return true;
		}
		return false;
	}

	public void addCompileResult(char[] fileName, List<String> topLevelTypes, Map<String, byte[]> classMap) {
		allTopLevelTypes.put(fileName, topLevelTypes);
		allClassMaps.put(fileName, classMap);
	}

	public static ClassFileCache findInEmfObject(Notifier emfObject) {
		ClassFileCacheAdapter adapter = ((ClassFileCacheAdapter) EcoreUtil.getExistingAdapter(emfObject, ClassFileCache.class));
		if (adapter != null) {
			return adapter.get();
		}
		return null;
	}

	public static ClassFileCache removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof ClassFileCache.ClassFileCacheAdapter) {
				emfObject.eAdapters().remove(i);
				return ((ClassFileCache.ClassFileCacheAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		ClassFileCache result = findInEmfObject(emfObject);
		if (result != null)
			throw new IllegalStateException("The given EMF object already contains an adapter for ClassFileCache");
		ClassFileCache.ClassFileCacheAdapter adapter = new ClassFileCache.ClassFileCacheAdapter(this);
		emfObject.eAdapters().add(adapter);
	}
}
