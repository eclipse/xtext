package org.eclipse.xtext.xbase.idea;

import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.idea.filesystem.IdeaWorkspaceConfigProvider;

import com.google.inject.Binder;

public class XbaseIdeaModule extends AbstractXbaseIdeaModule {

	public void configureWorkspaceConfig(Binder binder) {
		binder.bind(WorkspaceConfig.class).toProvider(IdeaWorkspaceConfigProvider.class);
	}
}
