package org.eclipse.xtext.idea.resource;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import com.intellij.openapi.project.Project;

public class ProjectAdapter extends AdapterImpl {
	
	private final Project project;

	public ProjectAdapter(Project project) {
		this.project = project;
	}

	public static Project getProject(Notifier ctx) {
		if (ctx == null) {
			return null;
		}
		for (Adapter adapter : ctx.eAdapters()) {
			if (adapter instanceof ProjectAdapter) {
				return ((ProjectAdapter) adapter).project;
			}
		}
		return null;
	}

}