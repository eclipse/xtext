package org.eclipse.xtext.example.ui.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;

public class JavaImportsTool implements PostProcessor {
	
	public final static String VAR_NAME = "__javaImportTool";

	public void beforeWriteAndClose(FileHandle impl) {
		if (lastInsertMarker!=null) {
			String string = impl.getBuffer().toString();
			impl.setBuffer(new StringBuilder(string.replace(lastInsertMarker, getImportSection())));
		}
		lastInsertMarker = null;
		imports.clear();
	}

	protected CharSequence getImportSection() {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<String>(imports);
		Collections.sort(list);
		for (String name : list) {
			sb.append("import ").append(name).append(";\n");
		}
		return sb;
	}

	public void afterClose(FileHandle impl) {
	}
	
	private String lastInsertMarker = null;
	
	public String addImportsHere() {
		if (lastInsertMarker!=null)
			throw new IllegalStateException("Multiple import sections? Did you forget to register the JavaImportsTool as postprocessor?");
		lastInsertMarker = "_Placeholder_for_a_lazy_import_section_"+System.currentTimeMillis()+"___";
		return lastInsertMarker;
	}
	
	private Set<String> imports = new HashSet<String>();
	
	public String registerImport(String qualifiedName) {
		if (qualifiedName != null)
			imports.add(qualifiedName);
		return qualifiedName;
	}

}
