package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage;
import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage.IModificationListener;

import com.google.inject.Inject;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class TabFactory {

	@Inject
	Injector injector;

	public IModifyDialogTabPage createIndentationTab(IModificationListener modifyListener,
			Map<String, String> workingValues) {
		return injectMembers(new IndentationTab(modifyListener, workingValues));
	}

	public IModifyDialogTabPage createBracesTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		return injectMembers(new BracesTab(modifyListener, workingValues));
	}

	public IModifyDialogTabPage createWhiteSpaceTab(IModificationListener modifyListener,
			Map<String, String> workingValues) {
		return injectMembers(new WhiteSpaceTab(modifyListener, workingValues));
	}

	public IModifyDialogTabPage createBlankLinesTab(IModificationListener modifyListener,
			Map<String, String> workingValues) {
		return injectMembers(new BlankLinesTab(modifyListener, workingValues));
	}

	public IModifyDialogTabPage createNewLineTab(IModificationListener modifyListener, Map<String, String> workingValues) {
		return injectMembers(new NewLineTab(modifyListener, workingValues));
	}

	public IModifyDialogTabPage createLineWrapTab(IModificationListener modifyListener,
			Map<String, String> workingValues) {
		LineWrapTab lineWrapTab = injectMembers(new LineWrapTab(modifyListener, workingValues));
		lineWrapTab.initPrefs();
		return lineWrapTab;
	}

	private <T extends AbstractModifyDialogTab> T injectMembers(T tab) {
		injector.injectMembers(tab);
		return tab;
	}
}