package org.eclipse.xtext.ui.core.editor;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

public interface IXtextResourceChecker {

	void addMarkers(final IFile file, final List<Map<String, Object>> issues, boolean deleteOldMarkers,
			IProgressMonitor monitor);

	List<Map<String, Object>> check(final Resource resource, Map<?, ?> context, IProgressMonitor monitor);

}
