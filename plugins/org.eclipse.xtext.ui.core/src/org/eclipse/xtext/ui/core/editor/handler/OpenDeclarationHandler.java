package org.eclipse.xtext.ui.core.editor.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.core.editor.OpenDeclarationAction;
import org.eclipse.xtext.ui.core.editor.XtextEditor;

/**
 * Represents a declarative handler contributed with the 'org.eclipse.ui.handlers'
 * extension-point which simply delegates to {@link OpenDeclarationAction}.
 * <p/>
 * Note: this handler should only be enabled if the current active editor is an instance of <code>XtextEditor</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class OpenDeclarationHandler extends AbstractHandler {
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		new OpenDeclarationAction((XtextEditor) HandlerUtil.getActiveEditor(event)).run();
		return this;
	}
}
