package org.eclipse.xtext.ui.core.editor;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

public interface IXtextResourceChecker {

	List<Map<String, Object>> check(final Resource resource, Map<?, ?> context, IProgressMonitor monitor);

}
