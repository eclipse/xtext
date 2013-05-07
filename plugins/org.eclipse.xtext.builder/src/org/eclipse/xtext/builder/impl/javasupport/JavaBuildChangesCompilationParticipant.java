/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.builder.StringSet;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.ui.XtextProjectHelper;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class JavaBuildChangesCompilationParticipant extends CompilationParticipant {

	private static Logger log = Logger.getLogger(JavaBuildChangesCompilationParticipant.class);

	private Map<String, Long> lastStructuralBuildTime = Maps.newHashMap();

	@Inject
	private QueuedBuildData queuedBuildData;

	protected QualifiedName convertName(String name) {
		return QualifiedName.create(name.split("/"));
	}

	protected Set<QualifiedName> convertNames(StringSet types) {
		Set<QualifiedName> result = Sets.newHashSet();
		for (String name : types.values)
			if (name != null)
				result.add(convertName(name));
		return result;
	}

	@Override
	public void buildFinished(IJavaProject javaProject) {
		IProject project = javaProject.getProject();
		Object jdtState = JavaModelManager.getJavaModelManager().getLastBuiltState(project, null);
		StringSet types = (StringSet) readField(jdtState, "structurallyChangedTypes");
		Long thisTime = (Long) readField(jdtState, "lastStructuralBuildTime");
		Long lastTime = lastStructuralBuildTime.get(project.getName());
		if (lastTime == null || (thisTime != null && types != null && !lastTime.equals(thisTime))) {
			Set<QualifiedName> names = convertNames(types);
			queuedBuildData.confirmChanges(project, names);
		}
		lastStructuralBuildTime.put(project.getName(), thisTime);
	}

	@Override
	public boolean isActive(IJavaProject project) {
		return XtextProjectHelper.hasNature(project.getProject());
	}

	private Object readField(Object obj, String field) {
		try {
			Field f = obj.getClass().getDeclaredField(field);
			f.setAccessible(true);
			return f.get(obj);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}
}
