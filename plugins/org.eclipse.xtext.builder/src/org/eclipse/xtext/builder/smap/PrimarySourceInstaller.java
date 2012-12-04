/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.smap;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.LineMappingProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PrimarySourceInstaller {

	public static class XtextClassAdapter extends ClassAdapter {

		private final boolean hideSyntheticVariables;

		private final String sourceFile;

		private final int[] target2source;

		public XtextClassAdapter(ClassVisitor cv, String sourceFile, int[] target2source, boolean hideSyntheticVariables) {
			super(cv);
			this.sourceFile = sourceFile;
			this.target2source = target2source;
			this.hideSyntheticVariables = hideSyntheticVariables;
		}

		public String getSourceFile() {
			return sourceFile;
		}

		public int[] getTarget2source() {
			return target2source;
		}

		public boolean isHideSyntheticVariables() {
			return hideSyntheticVariables;
		}

		@Override
		public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
			return new XtextMethodAdapter(this, super.visitMethod(access, name, desc, signature, exceptions));
		}

		@Override
		public void visitSource(String source, String debug) {
			super.visitSource(sourceFile, debug);
		}
	}

	public static class XtextMethodAdapter extends MethodAdapter {

		private XtextClassAdapter context;

		public XtextMethodAdapter(XtextClassAdapter context, MethodVisitor delegate) {
			super(delegate);
			this.context = context;
		}

		public XtextClassAdapter getContext() {
			return context;
		}

		@Override
		public void visitLineNumber(int line, Label start) {
			int[] target2source = context.getTarget2source();
			if (target2source == null || line < 0 || line >= target2source.length)
				return;
			int sourceLine = target2source[line];
			if (sourceLine >= 0)
				super.visitLineNumber(sourceLine, start);
		}

		@Override
		public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
			if (context.isHideSyntheticVariables()) {
				boolean isMethodParameter = start.getOffset() == 0;
				boolean isSynthetic = name.startsWith("_");
				if (isMethodParameter || !isSynthetic)
					super.visitLocalVariable(name, desc, signature, start, end, index);
			} else {
				super.visitLocalVariable(name, desc, signature, start, end, index);
			}
		}
	}

	private static final Logger log = Logger.getLogger(PrimarySourceInstaller.class);

	@Inject
	private LineMappingProvider lineMappingProvider;

	protected int[] getTargetToSourceLineMapping(AbstractTraceRegion rootTraceRegion) {
		List<LineMapping> lineInfo = lineMappingProvider.getLineMapping(rootTraceRegion);
		if (lineInfo == null)
			return null;
		int maxLineEnd = 0;
		for (LineMapping lineMapping : lineInfo)
			if (maxLineEnd < lineMapping.targetEndLine)
				maxLineEnd = lineMapping.targetEndLine;
		int[] target2source = new int[maxLineEnd + 2];
		Arrays.fill(target2source, -1);
		for (LineMapping lineMapping : lineInfo)
			for (int targetLine = lineMapping.targetStartLine + 1; targetLine <= lineMapping.targetEndLine + 1; targetLine++) {
				int startLine = lineMapping.sourceStartLine;
				if (target2source[targetLine] == -1 || startLine < target2source[targetLine])
					target2source[targetLine] = startLine;
			}
		return target2source;
	}

	@SuppressWarnings("null")
	public void install(IFile classFile, AbstractTraceRegion rootTraceRegion, boolean hideSyntheticVariables) {
		try {
			InputStream inputStream = classFile.getContents();
			try {
				ClassReader reader = new ClassReader(inputStream);
				ClassWriter writer = new ClassWriter(0);
				String sourceFile = rootTraceRegion.getAssociatedPath().lastSegment();
				int[] target2source = getTargetToSourceLineMapping(rootTraceRegion);
				XtextClassAdapter adapter = new XtextClassAdapter(writer, sourceFile, target2source,
						hideSyntheticVariables);
				reader.accept(adapter, 0);
				classFile.setContents(new ByteArrayInputStream(writer.toByteArray()), 0, new NullProgressMonitor());
			} finally {
				if (inputStream != null)
					inputStream.close();
			}
		} catch (Exception e) {
			log.error("Error while installing debug source information to " + classFile.getFullPath().toFile(), e);
		}
	}

}
