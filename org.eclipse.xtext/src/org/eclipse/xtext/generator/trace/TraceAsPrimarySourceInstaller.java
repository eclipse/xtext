/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceAsPrimarySourceInstaller implements ITraceToBytecodeInstaller {

	public static class XtextClassAdapter extends ClassVisitor {

		private final boolean hideSyntheticVariables;

		private final String sourceFile;

		private final int[] target2source;

		public XtextClassAdapter(ClassVisitor cv, String sourceFile, int[] target2source, boolean hideSyntheticVariables) {
			super(Opcodes.ASM9, cv);
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

	public static class XtextMethodAdapter extends MethodVisitor {

		private XtextClassAdapter context;

		public XtextMethodAdapter(XtextClassAdapter context, MethodVisitor delegate) {
			super(Opcodes.ASM9, delegate);
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

	private boolean hideSyntheticVariables;

	@Inject
	private LineMappingProvider lineMappingProvider;

	protected AbstractTraceRegion trace;

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

	@Override
	public byte[] installTrace(byte[] javaClassBytecode) throws IOException {
		if (trace == null)
			return null;
		SourceRelativeURI associatedPath = trace.getAssociatedSrcRelativePath();
		if (associatedPath == null)
			return null;
		ClassReader reader = new ClassReader(javaClassBytecode);
		ClassWriter writer = new ClassWriter(0);
		String sourceFileName = associatedPath.getURI().lastSegment();
		int[] target2source = getTargetToSourceLineMapping(trace);
		XtextClassAdapter adapter = new XtextClassAdapter(writer, sourceFileName, target2source, hideSyntheticVariables);
		reader.accept(adapter, 0);
		return writer.toByteArray();
	}

	public boolean isHideSyntheticVariables() {
		return hideSyntheticVariables;
	}

	public void setHideSyntheticVariables(boolean hideSyntheticVariables) {
		this.hideSyntheticVariables = hideSyntheticVariables;
	}

	@Override
	public void setTrace(String javaFileName, AbstractTraceRegion trace) {
		this.trace = trace;
	}

}
