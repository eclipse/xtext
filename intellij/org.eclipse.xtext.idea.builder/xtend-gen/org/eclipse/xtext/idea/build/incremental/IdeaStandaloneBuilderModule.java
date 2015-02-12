package org.eclipse.xtext.idea.build.incremental;

import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderModule;
import org.eclipse.xtext.idea.build.incremental.IdeaIssueHandler;

@SuppressWarnings("all")
public class IdeaStandaloneBuilderModule extends StandaloneBuilderModule {
  @Override
  protected Class<? extends IIssueHandler> bindIIssueHandler() {
    return IdeaIssueHandler.class;
  }
}
