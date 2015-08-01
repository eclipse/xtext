package org.eclipse.xtend.maven;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Strings;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;

public class ClassFileDebugInfoExtractor {

	protected static class SmapInfo {
		private Map<Integer, Integer> target2source = Maps.newHashMap();
		private String fileName;
		private static Pattern LINE = Pattern.compile("(\\d+):(\\d+)(,(\\d+))?");

		public SmapInfo(String smap) {
			if (Strings.isEmpty(smap))
				return;
			String[] lines = smap.split("\n");
			if (lines.length < 2)
				return;
			if (!"SMAP".equals(lines[0]))
				return;
			for (String line : lines) {
				Matcher matcher = LINE.matcher(line);
				if (matcher.matches()) {
					int source = Integer.parseInt(matcher.group(1));
					int target = Integer.parseInt(matcher.group(2));
					int targetIncrement = Integer.parseInt(Strings.isEmpty(matcher.group(4)) ? "1" : matcher.group(4));
					for (int i = 0; i < targetIncrement; i++)
						target2source.put(target + i, source);
				} else if (line.startsWith("+")) {
					int i = line.lastIndexOf(' ');
					fileName = line.substring(i + 1);
				}
			}

		}

		public String getFileName() {
			return fileName;
		}

		public boolean isValid() {
			return fileName != null;
		}
	}

	protected static class ClassVisitor extends org.objectweb.asm.ClassVisitor {
		private List<MethodVisitor> methods = Lists.newArrayList();
		private String name;
		private String fileName;
		private String source;
		private String pkg;
		private SmapInfo smap;

		/**
		 * @param fileName
		 */
		public ClassVisitor(String fileName) {
			super(Opcodes.ASM5);
			this.fileName = fileName;
		}

		@Override
		public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("package " + pkg + "; // " + fileName + "\n");
			buf.append("class " + name + " {\n");
			buf.append("  " + Joiner.on("\n").join(methods).replace("\n", "\n  ") + "\n");
			buf.append("}");
			return buf.toString();
		}

		@Override
		public void visit(int arg0, int arg1, String arg2, String arg3, String arg4, String[] arg5) {
			name = Strings.lastToken(arg2, "/");
			pkg = Strings.skipLastToken(arg2, "/");
		}

		@Override
		public MethodVisitor visitMethod(int arg0, String arg1, String arg2, String arg3, String[] arg4) {
			MethodVisitor visitor = new MethodVisitor(this, arg1);
			if ((arg0 & Opcodes.ACC_BRIDGE) == 0)
				methods.add(visitor);
			return visitor;
		}

		@Override
		public void visitSource(String arg0, String arg1) {
			this.source = arg0;
			this.smap = new SmapInfo(arg1);
		}
	}

	protected static class MethodVisitor extends org.objectweb.asm.MethodVisitor {
		private List<String> localVariables = Lists.newArrayList();
		private String name;
		private int startline = -1;
		private int endLine = -1;
		private ClassVisitor cls;

		public MethodVisitor(ClassVisitor cls, String name) {
			super(Opcodes.ASM5);
			this.cls = cls;
			this.name = name;
		}

		@Override
		public String toString() {
			List<String> vars = Lists.newArrayList();
			for (String v : localVariables)
				vars.add("void " + v + ";");
			List<String> lines = Lists.newArrayList();
			if (cls.smap.isValid()) {
				Map<Integer, int[]> sourceToLines = Maps.newLinkedHashMap();
				for(int line = startline; line <= endLine; line++) {
					Integer sourceLine = cls.smap.target2source.get(line);
					if (sourceLine != null) {
						int[] interval = sourceToLines.get(sourceLine);
						if (interval == null) {
							interval = new int[] {line, line};
							sourceToLines.put(sourceLine, interval);
						} else {
							interval[1] = line;
						}
					}
				}
				for(Map.Entry<Integer, int[]> entry: sourceToLines.entrySet()) {
					int[] interval = entry.getValue();
					String lineToAdd = cls.source + ":" + interval[0];
					if (interval[0] != interval[1]) {
						lineToAdd += ":" + interval[1];
					}
					lineToAdd += " -> " + cls.smap.fileName + ":" + entry.getKey();
					lines.add(lineToAdd);	
				}
			}
			StringBuilder buf = new StringBuilder();
			buf.append("void " + name + "() {");
			if (!Strings.isEmpty(cls.source))
				buf.append(" // ").append(cls.source).append(":").append(startline);
			if (!lines.isEmpty()) {
				buf.append("\n  // ");
				Joiner.on("\n  // ").appendTo(buf, lines);
			}
			buf.append("\n  " + Joiner.on("\n  ").join(vars) + "\n");
			buf.append("}");
			return buf.toString();
		}

		@Override
		public void visitLineNumber(int arg0, Label arg1) {
			if (startline < 0)
				startline = arg0;
			endLine = arg0;
		}

		@Override
		public void visitLocalVariable(String arg0, String arg1, String arg2, Label arg3, Label arg4, int arg5) {
			if (arg0.indexOf("$") < 0)
				localVariables.add(arg0);
		}
	}

	public String getDebugInfo(File file) {
		if (file.isFile() && file.getName().endsWith(".class")) {
			try {
				ClassReader cr = new ClassReader(Files.toByteArray(file));
				ClassVisitor visitor = new ClassVisitor(file.getName());
				cr.accept(visitor, 0);
				return visitor.toString();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else if (file.isDirectory()) {
			List<String> children = Lists.newArrayList();
			for (File child : file.listFiles()) {
				String info = getDebugInfo(child);
				if (!Strings.isEmpty(info))
					children.add(info);
			}
			Collections.sort(children);
			StringBuffer buf = new StringBuffer();
			buf.append("// " + file.getName() + " {\n");
			buf.append("  " + Joiner.on("\n\n").join(children).replace("\n", "\n  ") + "\n");
			buf.append("}");
			return buf.toString();
		}
		return null;
	}

	public String getDebugInfo(String classFile) {
		return getDebugInfo(new File(classFile));
	}
	
	public static void main(String[] args) {
		System.out.println(args[0]);
		String debugInfo = new ClassFileDebugInfoExtractor().getDebugInfo(args[0]);
		System.out.println(debugInfo);
	}
}
