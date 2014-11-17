package org.eclipse.xtext.idea.build;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import com.intellij.compiler.impl.CompilerUtil;
import com.intellij.compiler.server.CustomBuilderMessageHandler;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;

public class XtextCompilerComponent extends AbstractProjectComponent {

	public XtextCompilerComponent(Project project) {
		super(project);
	}
	
	@Override
	public String getComponentName() {
		return "Xtext Compiler Component";
	}
	

	public void projectOpened() {
		myProject.getMessageBus().connect().subscribe(CustomBuilderMessageHandler.TOPIC, new RefreshFilesCompilationStatusListener());
	}

	private class RefreshFilesCompilationStatusListener implements CustomBuilderMessageHandler {

		private final AtomicReference<List<File>> myAffectedFiles = new AtomicReference<List<File>>(new ArrayList<File>());

		public void messageReceived(String builderId, String messageType, String messageText) {
			if (!"xtext".equals(builderId)) {
				return;
			}

			if (messageType.equals("generated")) {
				myAffectedFiles.get().add(new File(messageText));
			} else if (messageType.equals("refresh")) {
				final List<File> generatedFiles = myAffectedFiles.getAndSet(new ArrayList<File>());
				if (myProject.isDisposed() || generatedFiles.isEmpty()) {
					return;
				}

				// refresh affected files
				CompilerUtil.refreshIOFiles(generatedFiles);
			}
		}
	}

}
