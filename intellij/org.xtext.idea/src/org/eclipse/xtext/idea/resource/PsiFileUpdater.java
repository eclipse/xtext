package org.eclipse.xtext.idea.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

import com.google.common.collect.Lists;
import com.intellij.lang.Language;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.PsiFileEx;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import com.intellij.util.messages.MessageBusConnection;

public class PsiFileUpdater extends AbstractProjectComponent implements ProjectComponent, BulkFileListener {

	private final PsiManager psiManager;

	public PsiFileUpdater(Project project) {
		super(project);
		psiManager = PsiManager.getInstance(myProject);
		Application application = ApplicationManager.getApplication();
		MessageBusConnection conn = application.getMessageBus().connect();
		conn.subscribe(VirtualFileManager.VFS_CHANGES, this);
	}

	public void after(List<? extends VFileEvent> events) {
		List<LanguageFileType> fileTypes = getFileTypes();
		if (fileTypes.isEmpty()) {
			return;
		}
		List<VirtualFile> updatedFiles = collectUpdatedFiles(events, fileTypes);
		if (updatedFiles.isEmpty()) {
			return;
		}
		List<VirtualFile> filesToReparse = new ArrayList<VirtualFile>();
		FileBasedIndex fileBasedIndex = FileBasedIndex.getInstance();
		GlobalSearchScope projectScope = GlobalSearchScope.projectScope(myProject);
		for (LanguageFileType fileType : fileTypes) {
			Collection<VirtualFile> files = fileBasedIndex.getContainingFiles(FileTypeIndex.NAME, fileType, projectScope);
			for (VirtualFile virtualFile : files) {
				if (needReparse(virtualFile, updatedFiles)) {
					filesToReparse.add(virtualFile);
				}
			}
		}
		if (filesToReparse.isEmpty()) {
			return;
		}
		PsiDocumentManager.getInstance(myProject).reparseFiles(filesToReparse, false);
	}

	protected boolean needReparse(VirtualFile virtualFile, List<VirtualFile> updatedFiles) {
		PsiFile psiFile = psiManager.findFile(virtualFile);
		if (!(psiFile instanceof BaseXtextFile)) {
			return false;
		}
		PsiFileEx psiFileEx = (PsiFileEx) psiFile;
		if (!psiFileEx.isContentsLoaded()) {
			return false;
		}
		if (updatedFiles.contains(virtualFile)) {
			return !isNodeModelUpdated(psiFile);
		}
		return true;
	}

	protected boolean isNodeModelUpdated(PsiFile psiFile) {
		PsiElement firstChild = psiFile.getFirstChild();
		if (firstChild instanceof PsiEObject) {
			PsiEObject psiEObject = (PsiEObject) firstChild;
			String nodeText = psiEObject.getINode().getRootNode().getText();
			String psiFileText = psiFile.getText();
			return nodeText.equals(psiFileText);
		}
		return true;
	}

	protected List<LanguageFileType> getFileTypes() {
		List<LanguageFileType> fileTypes = Lists.newArrayList();
		for (Language language : Language.getRegisteredLanguages()) {
			if (language instanceof IXtextLanguage) {
				fileTypes.add(language.getAssociatedFileType());
			}
		}
		return fileTypes;
	}

	protected List<VirtualFile> collectUpdatedFiles(List<? extends VFileEvent> events, List<LanguageFileType> fileTypes) {
		List<VirtualFile> updatedFiles = new ArrayList<VirtualFile>();
		for (VFileEvent event : events) {
			VirtualFile file = event.getFile();
			if (fileTypes.contains(file.getFileType())) {
				updatedFiles.add(file);
			}
		}
		return updatedFiles;
	}

	public void before(List<? extends VFileEvent> events) { }

}
