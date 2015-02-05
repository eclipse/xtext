package org.eclipse.xtext.idea.build.incremental

import org.eclipse.xtext.builder.standalone.StandaloneBuilderModule

class IdeaStandaloneBuilderModule extends StandaloneBuilderModule {
	
	override protected bindIIssueHandler() {
		IdeaIssueHandler
	}
}