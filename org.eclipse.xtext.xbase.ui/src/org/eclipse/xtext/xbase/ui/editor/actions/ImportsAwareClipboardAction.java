/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor.actions;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.internal.ui.actions.ActionMessages;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IRewriteTarget;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.util.ClipboardUtil;
import org.eclipse.xtext.ui.util.ClipboardUtil.JavaImportData;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.ui.imports.ImportsUtil;
import org.eclipse.xtext.xbase.ui.internal.XbaseActivator;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Hübner (dhubner) - Initial contribution and API
 */
public class ImportsAwareClipboardAction extends TextEditorAction {
	public static class Factory implements IClipboardActionFactory {
		@Inject
		private MembersInjector<ImportsAwareClipboardAction> injector;

		@Override
		public TextEditorAction create(ResourceBundle bundle, String prefix, ITextEditor editor, int operationCode) {
			ImportsAwareClipboardAction action = new ImportsAwareClipboardAction(bundle, prefix, editor, operationCode);
			injector.injectMembers(action);
			return action;
		}

	}

	private static final XbaseClipboardTransfer TRANSFER_INSTANCE = new XbaseClipboardTransfer();
	private final int operationCode;
	private ITextOperationTarget textOperationTarget;
	private @Inject ImportsUtil importsUtil;

	/**
	 * Creates the action.
	 * 
	 * @param bundle
	 *            the resource bundle
	 * @param prefix
	 *            a prefix to be prepended to the various resource keys (described in <code>ResourceAction</code>
	 *            constructor), or <code>null</code> if none
	 * @param editor
	 *            the text editor. May not be <code>null</code>.
	 * @param operationCode
	 *            the operation code
	 */
	public ImportsAwareClipboardAction(ResourceBundle bundle, String prefix, ITextEditor editor,
			final int operationCode) {
		super(bundle, prefix, editor);
		this.operationCode = operationCode;

		if (operationCode == ITextOperationTarget.CUT) {
			setHelpContextId(IAbstractTextEditorHelpContextIds.CUT_ACTION);
			setActionDefinitionId(IWorkbenchCommandConstants.EDIT_CUT);
		} else if (operationCode == ITextOperationTarget.COPY) {
			setHelpContextId(IAbstractTextEditorHelpContextIds.COPY_ACTION);
			setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
		} else if (operationCode == ITextOperationTarget.PASTE) {
			setHelpContextId(IAbstractTextEditorHelpContextIds.PASTE_ACTION);
			setActionDefinitionId(IWorkbenchCommandConstants.EDIT_PASTE);
		} else {
			Assert.isTrue(false, "Invalid operation code"); //$NON-NLS-1$
		}
		update();
	}

	protected void internalDoOperation() {
		if (operationCode == ITextOperationTarget.PASTE) {
			doPasteWithImportsOperation();
		} else {
			doCutCopyWithImportsOperation();
		}
	}

	private void doCutCopyWithImportsOperation() {
		try {
			final XbaseClipboardData cbData = createClipboardData();
			if (cbData != null ) {
				ClipboardUtil.clipboardOperation(new Function<Clipboard, Boolean>() {

					@Override
					public Boolean apply(Clipboard clipboard) {
						Map<Object,Transfer> payload = newLinkedHashMap();
						payload.put(cbData, TRANSFER_INSTANCE);
						
						TextTransfer textTransfer = TextTransfer.getInstance();
						String textData = (String) clipboard.getContents(textTransfer);
						if (textData == null || textData.isEmpty()) {
							// StyledText copied any data to ClipBoard
							return Boolean.FALSE;
						}
						payload.put(textData, textTransfer);
						
						RTFTransfer rtfTransfer = RTFTransfer.getInstance();
						String rtfData = (String) clipboard.getContents(rtfTransfer);
						if (rtfData != null && !rtfData.isEmpty()) {
							payload.put(rtfData, rtfTransfer);
						}
						
						List<Object> datas = newArrayList();
						List<Transfer> dataTypes = newArrayList();
						for (Entry<Object, Transfer> entry : payload.entrySet()) {
							datas.add(entry.getKey());
							dataTypes.add(entry.getValue());
						}
						try {
							clipboard.setContents(datas.toArray(), dataTypes.toArray(new Transfer[] {}));
							return Boolean.TRUE;
						} catch (SWTError e) {
							if (e.code != DND.ERROR_CANNOT_SET_CLIPBOARD) {
								throw e;
							}
							if (MessageDialog.openQuestion(getShell(), ActionMessages.CopyQualifiedNameAction_ErrorTitle, ActionMessages.CopyQualifiedNameAction_ErrorDescription)) {
								clipboard.setContents(datas.toArray(), dataTypes.toArray(new Transfer[] {}));
								return Boolean.TRUE;
							}
							return Boolean.FALSE;
						}
					}
				});
			}
		} finally {
			textOperationTarget.doOperation(operationCode);
		}
	}

	private void doPasteWithImportsOperation() {
		XbaseClipboardData xbaseClipboardData = ClipboardUtil
				.clipboardOperation(new Function<Clipboard, XbaseClipboardData>() {
					@Override
					public XbaseClipboardData apply(Clipboard input) {
						Object content = input.getContents(TRANSFER_INSTANCE);
						if (content instanceof XbaseClipboardData) {
							return (XbaseClipboardData) content;
						}
						return null;
					}
				});
		JavaImportData javaImportsContent = ClipboardUtil.getJavaImportsContent();
		String textFromClipboard = ClipboardUtil.getTextFromClipboard();
		XtextEditor xtextEditor = EditorUtils.getXtextEditor(getTextEditor());
		boolean addImports = shouldAddImports(xtextEditor.getDocument(), caretOffset(xtextEditor));
		if (xbaseClipboardData != null && !sameTarget(xbaseClipboardData)) {
			doPasteXbaseCode(xbaseClipboardData, addImports);
		} else if (javaImportsContent != null) {
			doPasteJavaCode(textFromClipboard, javaImportsContent, addImports);
		} else {
			textOperationTarget.doOperation(operationCode);
		}
	}

	/**
	 * Should not add imports when pasting into a {@link XStringLiteral} or Comments (except of JavaDoc)
	 * 
	 * @param document
	 *            - {@link IDocument} to work with
	 * @param caretOffset
	 *            - current caret offset
	 */
	protected boolean shouldAddImports(IDocument document, int caretOffset) {
		if (caretOffset == 0) {
			return true;
		}
		String typeRight = IDocument.DEFAULT_CONTENT_TYPE;
		String typeLeft = IDocument.DEFAULT_CONTENT_TYPE;
		try {
			typeRight = TextUtilities.getContentType(document, IDocumentExtension3.DEFAULT_PARTITIONING, caretOffset,
					false);
			typeLeft = TextUtilities.getContentType(document, IDocumentExtension3.DEFAULT_PARTITIONING,
					caretOffset > 0 ? caretOffset - 1 : caretOffset, false);
		} catch (BadLocationException exception) {
			// Should not happen
		}
		if (COMMENT_PARTITION.equals(typeRight) || STRING_LITERAL_PARTITION.equals(typeRight)
				|| SL_COMMENT_PARTITION.equals(typeRight) || "__rich_string".equals(typeRight)) {
			if (typeLeft.equals(typeRight))
				return false;
		}
		return true;
	}

	private int caretOffset(final XtextEditor xtextEditor) {
		ISourceViewer sourceViewer = xtextEditor.getInternalSourceViewer();
		int caretOffset = sourceViewer.getTextWidget().getCaretOffset();
		if (sourceViewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension = (ITextViewerExtension5) sourceViewer;
			caretOffset = extension.widgetOffset2ModelOffset(caretOffset);
		}
		return caretOffset;
	}

	private void doPasteXbaseCode(XbaseClipboardData xbaseClipboardData, boolean withImports) {
		IRewriteTarget target = Adapters.adapt(getTextEditor(), IRewriteTarget.class);
		if (target != null) {
			target.beginCompoundChange();
		}
		try {
			textOperationTarget.doOperation(operationCode);
			if (withImports) {
				importsUtil.addImports(xbaseClipboardData.getImports(), xbaseClipboardData.getStaticImports(),
						xbaseClipboardData.getExtensionImports(), getXtextDocument());
			}
		} catch (Exception e) {
			XbaseActivator.getInstance().getLog().log(new Status(IStatus.ERROR,
					XbaseActivator.getInstance().getBundle().getSymbolicName(), "Unexpected internal error: ", e));
		} finally {
			if (target != null) {
				target.endCompoundChange();
			}
		}
	}

	private void doPasteJavaCode(String textFromClipboard, JavaImportData javaImportsContent, boolean withImports) {
		IRewriteTarget target = Adapters.adapt(getTextEditor(), IRewriteTarget.class);
		if (target != null) {
			target.beginCompoundChange();
		}
		try {
			textOperationTarget.doOperation(operationCode);
			if (withImports) {
				importsUtil.addImports(javaImportsContent.getImports(), javaImportsContent.getStaticImports(),
						new String[] {}, getXtextDocument());
			}
		} catch (Exception e) {
			XbaseActivator.getInstance().getLog().log(new Status(IStatus.ERROR,
					XbaseActivator.getInstance().getBundle().getSymbolicName(), "Unexpected internal error: ", e));
		} finally {
			if (target != null) {
				target.endCompoundChange();
			}
		}
	}

	private boolean sameTarget(XbaseClipboardData xbaseClipboardData) {
		IEditorInput editorInput = getTextEditor().getEditorInput();
		if (editorInput == null) {
			return false;
		}
		return xbaseClipboardData.getSourceIndentifier().equals(editorInput.toString());
	}

	private XbaseClipboardData createClipboardData() {
		try {
			IEditorInput editorInput = getTextEditor().getEditorInput();
			final String sourceIdentifier = editorInput != null ? editorInput.toString() : "nullEditorInput";
			IXtextDocument document = getXtextDocument();
			final ISelection selection = getTextEditor().getSelectionProvider().getSelection();
			if (selection instanceof ITextSelection && !selection.isEmpty()) {
				final ITextSelection textSelection = (ITextSelection) selection;
				return document.tryReadOnly(new IUnitOfWork<XbaseClipboardData, XtextResource>() {
					@Override
					public XbaseClipboardData exec(XtextResource state) throws Exception {
						ITextRegion region = new TextRegion(textSelection.getOffset(), textSelection.getLength() - 1);
						Triple<Set<String>, Set<String>, Set<String>> imports = importsUtil.collectImports(state,
								region);
						XbaseClipboardData clipboardData = new XbaseClipboardData(sourceIdentifier,
								Iterables.toArray(imports.getFirst(), String.class),
								Iterables.toArray(imports.getSecond(), String.class),
								Iterables.toArray(imports.getThird(), String.class));
						return clipboardData;
					}
				});
			}
		} catch (Exception e) {
			//TODO Log exception
			return null;
		}
		return null;
	}

	private IXtextDocument getXtextDocument() {
		XtextEditor xtextEditor = EditorUtils.getXtextEditor(getTextEditor());
		IXtextDocument document = xtextEditor.getDocument();
		return document;
	}

	@Override
	public void update() {
		super.update();
		if (isModifyOperation() && !canModifyEditor()) {
			setEnabled(false);
			return;
		}
		if (textOperationTarget == null) {
			textOperationTarget = Adapters.adapt(getTextEditor(), ITextOperationTarget.class);
		}
		boolean isEnabled = (textOperationTarget != null && textOperationTarget.canDoOperation(getOperationCode()));
		setEnabled(isEnabled);
	}

	private int getOperationCode() {
		return operationCode;
	}

	@Override
	public void run() {
		if (textOperationTarget == null)
			return;
		ITextEditor editor = getTextEditor();
		if (editor == null)
			return;
		if (isModifyOperation() && !validateEditorInputState())
			return;
		BusyIndicator.showWhile(getDisplay(), new Runnable() {
			@Override
			public void run() {
				internalDoOperation();
			}
		});
	}

	private boolean isModifyOperation() {
		return operationCode != ITextOperationTarget.COPY;
	}

	private Shell getShell() {
		ITextEditor editor = getTextEditor();
		if (editor != null) {
			IWorkbenchPartSite site = editor.getSite();
			Shell shell = site.getShell();
			if (shell != null && !shell.isDisposed()) {
				return shell;
			}
		}
		return null;
	}

	private Display getDisplay() {
		Shell shell = getShell();
		if (shell != null) {
			return shell.getDisplay();
		}
		return null;
	}

	@Override
	public void setEditor(ITextEditor editor) {
		super.setEditor(editor);
		this.textOperationTarget = null;
	}

	public static final class XbaseClipboardData {
		private String sourceIndentifier;
		private String[] imports;
		private String[] staticImports;
		private String[] extensionImports;

		public XbaseClipboardData(String sourceIndentifier, String[] imports, String[] staticImports,
				String[] extensionImports) {
			this.sourceIndentifier = sourceIndentifier;
			this.imports = imports;
			this.staticImports = staticImports;
			this.extensionImports = extensionImports;
		}

		public XbaseClipboardData(byte[] bytes) throws IOException {
			DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(bytes));
			try {
				sourceIndentifier = dataIn.readUTF();
				imports = readArray(dataIn);
				staticImports = readArray(dataIn);
				extensionImports = readArray(dataIn);
			} finally {
				dataIn.close();
			}
		}

		protected final String[] readArray(DataInputStream dataIn) throws IOException {
			int count = dataIn.readInt();
			String[] array = new String[count];
			for (int i = 0; i < count; i++) {
				array[i] = dataIn.readUTF();
			}
			return array;
		}

		public byte[] serialize() throws IOException {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			DataOutputStream dataOut = new DataOutputStream(out);
			try {
				dataOut.writeUTF(sourceIndentifier);
				writeArray(dataOut, imports);
				writeArray(dataOut, staticImports);
				writeArray(dataOut, extensionImports);
			} finally {
				dataOut.close();
				out.close();
			}
			return out.toByteArray();
		}

		protected final void writeArray(DataOutputStream dataOut, String[] array) throws IOException {
			dataOut.writeInt(array.length);
			for (int i = 0; i < array.length; i++) {
				dataOut.writeUTF(array[i]);
			}
		}

		public String getSourceIndentifier() {
			return sourceIndentifier;
		}

		public String[] getImports() {
			return imports;
		}

		public String[] getStaticImports() {
			return staticImports;
		}

		public String[] getExtensionImports() {
			return extensionImports;
		}
	}

	private static class XbaseClipboardTransfer extends ByteArrayTransfer {

		private static final String TYPE_NAME = "xbase-source-with-imports-transfer-format";

		private static final int TYPEID = registerType(TYPE_NAME);

		@Override
		protected int[] getTypeIds() {
			return new int[] { TYPEID };
		}

		@Override
		protected String[] getTypeNames() {
			return new String[] { TYPE_NAME };
		}

		@Override
		protected void javaToNative(Object data, TransferData transferData) {
			if (data instanceof XbaseClipboardData) {
				try {
					super.javaToNative(((XbaseClipboardData) data).serialize(), transferData);
				} catch (IOException e) {
					//it's best to send nothing if there were problems
				}
			}
		}

		@Override
		protected Object nativeToJava(TransferData transferData) {
			byte[] bytes = (byte[]) super.nativeToJava(transferData);
			if (bytes != null) {
				try {
					return new XbaseClipboardData(bytes);
				} catch (IOException e) {
				}
			}
			return null;
		}
	}

}
