package org.eclipse.xtext.idea.resource;

import static org.eclipse.emf.ecore.util.EcoreUtil.getAdapter;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import com.intellij.openapi.project.Project;

public class ProjectAdapter extends AdapterImpl {

	private final Project project;

	public ProjectAdapter(Project project) {
		this.project = project;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return getClass() == type;
	}

	public static Project getProject(Notifier ctx) {
		if (ctx == null) {
			return null;
		}
		ProjectAdapter adapter = (ProjectAdapter) getAdapter(ctx.eAdapters(), ProjectAdapter.class);
		if (adapter != null) {
			return adapter.project;
		}
		return null;
	}

}