package org.eclipse.xtext.ui.core.editor;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

public interface IXtextResourceChecker {

	static final String CODE_KEY = "code";
	static final String DIAGNOSTIC_KEY = "EmfDiagnostic";
	
	List<Map<String, Object>> check(final Resource resource, Map<?, ?> context, IProgressMonitor monitor);

}
