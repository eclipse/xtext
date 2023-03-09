/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import java.io.IOException;

import org.eclipse.jdt.internal.ui.javaeditor.ClipboardOperationAction.ClipboardData;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Function;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.8
 */
public class ClipboardUtil {

	/**
	 * Puts a string into the clipboard {@link DND#CLIPBOARD} using {@link TextTransfer}
	 *
	 * @param data
	 *            String to put into {@link Clipboard} using {@link TextTransfer}
	 */
	public static Object copy(final String data) {
		if (data == null) {
			return null;
		}
		return clipboardOperation(new Function<Clipboard, Object>() {
			@Override
			public Object apply(Clipboard clipboard) {
				clipboard.setContents(new Object[] { data }, new Transfer[] { TextTransfer.getInstance() });
				return null;
			}
		});
	}

	/**
	 * Retrieves a string from the clipboard {@link DND#CLIPBOARD} using {@link TextTransfer}
	 *
	 * @return Text from the {@link Clipboard} using {@link TextTransfer}
	 */
	public static String getTextFromClipboard() {
		return clipboardOperation(new Function<Clipboard, String>() {
			@Override
			public String apply(Clipboard input) {
				return (String) input.getContents(TextTransfer.getInstance());
			}
		});
	}

	/**
	 * Applies the passed function to the default {@link Clipboard}
	 * 
	 * @param function
	 *            operation to perform
	 */
	public static <T> T clipboardOperation(Function<Clipboard, T> function) {
		Clipboard clipboard = null;
		T contents;
		try {
			Display display = SWTUtil.getStandardDisplay();
			clipboard = new Clipboard(display);
			contents = function.apply(clipboard);
		} finally {
			if (clipboard != null) {
				clipboard.dispose();
			}
		}
		return contents;
	}

	/**
	 * Retrieves Java import information from the clipboard.
	 *
	 * @return {@link JavaImportData} containing imports information
	 */
	public static JavaImportData getJavaImportsContent() {
		return clipboardOperation(new Function<Clipboard, JavaImportData>() {

			@Override
			public JavaImportData apply(Clipboard clipboard) {
				for (int i = 0; i < clipboard.getAvailableTypeNames().length; i++) {
					final String formatName = clipboard.getAvailableTypeNames()[i];
					if (formatName.startsWith("source-with-imports-transfer-format")) {
						final TransferData transferData = clipboard.getAvailableTypes()[i];
						Object content = clipboard.getContents(new DynamicByteArrayTransfer(formatName, transferData));
						if (content instanceof JavaImportData) {
							return (JavaImportData) content;
						}
						return null;
					}
				}
				return null;
			}
		});
	}

	private static final class DynamicByteArrayTransfer extends ByteArrayTransfer {
		private final String formatName;
		private final TransferData transferData;

		private DynamicByteArrayTransfer(String formatName, TransferData transferData) {
			this.formatName = formatName;
			this.transferData = transferData;
		}

		@Override
		protected String[] getTypeNames() {
			return new String[] { formatName };
		}

		@Override
		protected int[] getTypeIds() {
			return new int[] {};
		}

		@Override
		public TransferData[] getSupportedTypes() {
			return new TransferData[] { transferData };
		}

		@Override
		public boolean isSupportedType(TransferData transferData) {
			if (transferData == null)
				return false;
			return true;
		}

		@Override
		public Object nativeToJava(TransferData transferData) {
			byte[] bytes = (byte[]) super.nativeToJava(transferData);
			if (bytes != null) {
				try {
					return new JavaImportData(new ClipboardData(bytes));
				} catch (IOException e) {
				}
			}
			return null;
		}
	}

	/**
	 * Holds JDT Informations about imports
	 * 
	 * @author dhuebner - Initial contribution and API
	 * @noextend This class is not intended to be subclassed by clients.
	 */
	public static class JavaImportData {
		private String[] imports;
		private String[] staticImports;

		public JavaImportData(String[] imports, String[] staticImports) {
			this.imports = imports;
			this.staticImports = staticImports;
		}

		JavaImportData(ClipboardData jdtClipboardData) {
			this.imports = jdtClipboardData.getTypeImports();
			this.staticImports = jdtClipboardData.getStaticImports();
		}

		public String[] getImports() {
			return imports;
		}

		public String[] getStaticImports() {
			return staticImports;
		}

	}
}
