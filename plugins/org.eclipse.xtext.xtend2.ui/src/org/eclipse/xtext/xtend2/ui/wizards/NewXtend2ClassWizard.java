package org.eclipse.xtext.xtend2.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.IImageHelper;

import com.google.inject.Inject;

/**
 * @author Robert von Massow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class NewXtend2ClassWizard extends NewElementWizard {

	public static final String TITLE = "Xtend Class"; //$NON-NLS-1$
	private NewXtend2ClassWizardPage fPage;

	@Inject
	public NewXtend2ClassWizard(IImageHelper imgHelper, NewXtend2ClassWizardPage fPage) {
		this.fPage= fPage;
		Image image = imgHelper.getImage("xtend_wizard_big.png");
		setDefaultPageImageDescriptor(ImageDescriptor.createFromImage(image));
		setDialogSettings(JavaPlugin.getDefault().getDialogSettings());
		setWindowTitle(TITLE);
	}

	@Override
	public void addPages() {
		super.addPages();
		fPage.init(getSelection());
		super.addPage(fPage);
	}

	@Override
	protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
	}

	@Override
	public IJavaElement getCreatedElement() {
		return null;
	}

	@Override
	public boolean performFinish() {
		final int size = this.fPage.createType();
		final IResource resource = fPage.getResource();
		if(resource != null) {
			selectAndReveal(resource);
			final Display display= getShell().getDisplay();
			display.asyncExec(new Runnable() {
				public void run() {
					IEditorPart editor;
					try {
						editor = IDE.openEditor(JavaPlugin.getActivePage(), (IFile) resource);
						if (editor instanceof ITextEditor) {
							final ITextEditor textEditor = (ITextEditor) editor;
							ISelectionProvider selectionProvider = textEditor.getSelectionProvider();
							ISelection selection = new TextSelection(size - 2, 0);
							selectionProvider.setSelection(selection);
						}
					} catch (PartInitException e) {
						throw new RuntimeException(e);
					}
				}
			});
			return true;
		} else {
			return false;
		}
	}
}
