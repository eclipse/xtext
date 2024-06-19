/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.descriptions.EObjectDescriptionBasedStubGenerator;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

public class IndexAwareNameEnvironment implements INameEnvironment {
	private final Resource resource;

	private final ClassLoader classLoader;

	private final IResourceDescriptions resourceDescriptions;

	private final EObjectDescriptionBasedStubGenerator stubGenerator;

	private final ClassFileCache classFileCache;

	private Map<QualifiedName, NameEnvironmentAnswer> nameToAnswerCache = new HashMap<>();

	@Override
	public void cleanup() {
		nameToAnswerCache.clear();
		classFileCache.clear();
	}

	@Override
	public NameEnvironmentAnswer findType(char[][] compoundTypeName) {
		List<String> segments = Arrays.stream(compoundTypeName).map(String::valueOf).collect(Collectors.toList());
		QualifiedName className = QualifiedName.create(segments);
		return findType(className);
	}

	public NameEnvironmentAnswer findType(QualifiedName className) {
		try {
			if (classFileCache.containsKey(className)) {
				IBinaryType t = classFileCache.get(className);
				if (t == null) {
					return null;
				}
				return new NameEnvironmentAnswer(t, null);
			}
			if (nameToAnswerCache.containsKey(className)) {
				return nameToAnswerCache.get(className);
			}
			IEObjectDescription candidate = IterableExtensions.head(
					resourceDescriptions.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, className, false));
			NameEnvironmentAnswer result = null;
			if (candidate != null) {
				IResourceDescription resourceDescription = resourceDescriptions
						.getResourceDescription(candidate.getEObjectURI().trimFragment());
				Resource res = resource.getResourceSet().getResource(resourceDescription.getURI(), false);
				String source = null;
				if (res instanceof JavaResource) {
					source = ((JavaResource) res).getOriginalSource();
				} else {
					source = stubGenerator.getJavaStubSource(candidate, resourceDescription);
				}
				CompilationUnit compilationUnit = new CompilationUnit(source.toCharArray(),
						className.toString("/") + ".java", null);
				result = new NameEnvironmentAnswer(compilationUnit, null);
			} else {
				String fileName = className.toString("/") + ".class";
				URL url = classLoader.getResource(fileName);
				if (url == null) {
					nameToAnswerCache.put(className, null);
					classFileCache.put(className, null);
					return null;
				}
				IBinaryType reader = null;
				try (InputStream stream = url.openStream()) {
					reader = ClassFileReader.read(stream, fileName);
				}
				if (reader == null) {
					return null;
				}
				classFileCache.put(className, reader);
				result = new NameEnvironmentAnswer(reader, null);
			}
			nameToAnswerCache.put(className, result);
			return result;
		} catch (IOException | ClassFormatException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@Override
	public NameEnvironmentAnswer findType(char[] typeName, char[][] packageName) {
		List<String> segments = Arrays.stream(packageName).map(String::valueOf).collect(Collectors.toList());
		segments.add(String.valueOf(typeName));
		QualifiedName className = QualifiedName.create(segments);
		return findType(className);
	}

	@Override
	public boolean isPackage(char[][] parentPackageName, char[] packageName) {
		if (packageName == null || packageName.length == 0) {
			return false;
		}
		return Character.isLowerCase(packageName[0]);
	}

	public IndexAwareNameEnvironment(Resource resource, ClassLoader classLoader,
			IResourceDescriptions resourceDescriptions, EObjectDescriptionBasedStubGenerator stubGenerator,
			ClassFileCache classFileCache) {
		this.resource = resource;
		this.classLoader = classLoader;
		this.resourceDescriptions = resourceDescriptions;
		this.stubGenerator = stubGenerator;
		this.classFileCache = classFileCache;
	}
}
