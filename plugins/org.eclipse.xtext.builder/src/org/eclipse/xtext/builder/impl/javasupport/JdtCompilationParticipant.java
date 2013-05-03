/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.builder.StringSet;
import org.eclipse.xtext.ui.XtextProjectHelper;

import com.google.common.base.Joiner;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JdtCompilationParticipant extends CompilationParticipant {

	private static Logger log = Logger.getLogger(JdtCompilationParticipant.class);

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

	private long previousStructuralBuildTime = -1;

	@Override
	public void buildFinished(IJavaProject project) {
		Object state = JavaModelManager.getJavaModelManager().getLastBuiltState(project.getProject(), null);
		StringSet structurallyChangedTypes = (StringSet) readField(state, "structurallyChangedTypes");
		Long previousStructuralBuildTime = (Long) readField(state, "previousStructuralBuildTime");
		if (previousStructuralBuildTime == null || structurallyChangedTypes == null)
			return;
		if (this.previousStructuralBuildTime == previousStructuralBuildTime) {
			System.out.println("no structural changes in Java files");
		} else {
			this.previousStructuralBuildTime = previousStructuralBuildTime;
			String join = Joiner.on(",").skipNulls().join(structurallyChangedTypes.values);
			System.out.println("Structurally changed Java Types " + join);
		}
	}

	@Override
	public boolean isActive(IJavaProject project) {
		return XtextProjectHelper.hasNature(project.getProject());
	}
}
