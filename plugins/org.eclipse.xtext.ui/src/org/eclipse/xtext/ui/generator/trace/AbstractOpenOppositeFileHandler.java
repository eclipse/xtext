package org.eclipse.xtext.ui.generator.trace;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public abstract class AbstractOpenOppositeFileHandler extends AbstractHandler {

	private final static Logger LOG = Logger.getLogger(AbstractOpenOppositeFileHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		IWorkbenchPage page = editor.getSite().getPage();
		try {
			if (editor.getEditorInput() instanceof IStorageEditorInput) {
				IStorage storage = ((IStorageEditorInput) editor.getEditorInput()).getStorage();
				ITextRegion region = getSelectedRegion(editor);
				StorageWithRegion origin = new StorageWithRegion(storage, region);
				Collection<StorageWithRegion> dests = findDestinations(origin);
				if (!dests.isEmpty()) {
					Collection<StorageWithRegion> selected = dests.size() > 1 ? selectDestinations(page, dests) : dests;
					for (StorageWithRegion sel : selected)
						openEditorAndSelect(page, sel);
				}
			}
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
	}

	protected abstract Collection<StorageWithRegion> findDestinations(StorageWithRegion orign);

	protected Collection<StorageWithRegion> findDestinationsUsingTrace(ITrace trace, ITextRegion region) {
		Iterable<ILocationInResource> locations = null;
		if (region != null)
			locations = trace.getAllAssociatedLocations(region);
		if (locations == null || Iterables.isEmpty(locations))
			locations = trace.getAllAssociatedLocations();
		Map<IStorage, StorageWithRegion> result = Maps.newHashMap();
		for (ILocationInResource location : locations) {
			IStorage storage = location.getStorage();
			StorageWithRegion old = result.put(storage, new StorageWithRegion(storage, location.getTextRegion()));
			if (old != null && old.getRegion() != null) {
				ITextRegion merged = old.getRegion().merge(location.getTextRegion());
				result.put(storage, new StorageWithRegion(storage, merged));
			}
		}
		return result.values();
	}

	protected ITextRegion getSelectedRegion(IEditorPart editor) {
		if (editor instanceof ITextEditor) {
			ISelection selection = ((ITextEditor) editor).getSelectionProvider().getSelection();
			if (selection instanceof ITextSelection) {
				ITextSelection textSelection = (ITextSelection) selection;
				return new TextRegion(textSelection.getOffset(), textSelection.getLength());
			}
		}
		return null;
	}

	protected void openEditorAndSelect(IWorkbenchPage page, StorageWithRegion destination) {
		try {
			IStorage storage = destination.getStorage();
			IEditorInput input = EditorUtils.createEditorInput(storage);
			IEditorDescriptor editorDescriptor = IDE.getEditorDescriptor(storage.getName());
			IEditorPart opened = IDE.openEditor(page, input, editorDescriptor.getId());
			ITextRegion region = destination.getRegion();
			if (region != null && opened instanceof ITextEditor) {
				ITextEditor openedTextEditor = (ITextEditor) opened;
				openedTextEditor.selectAndReveal(region.getOffset(), region.getLength());
			}
		} catch (PartInitException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	protected List<StorageWithRegion> selectDestinations(IWorkbenchPage page, Collection<StorageWithRegion> destinations) {
		Shell shell = page.getWorkbenchWindow().getShell();
		SelectionDialog dialog =  new StorageWithRegionSelector(shell, destinations);
		if (dialog.open() == Window.OK) {
			List<StorageWithRegion> result = Lists.newArrayList();
			for (Object item : dialog.getResult())
				if (item instanceof StorageWithRegion)
					result.add((StorageWithRegion) item);
			return result;
		}
		return Collections.emptyList();
	}
}
