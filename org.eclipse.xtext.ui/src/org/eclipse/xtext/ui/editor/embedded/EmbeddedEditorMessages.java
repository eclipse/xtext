/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmbeddedEditorMessages extends NLS {

	private static final String BUNDLE_FOR_CONSTRUCTED_KEYS= "org.eclipse.xtext.ui.editor.embedded.ConstructedEmbeddedEditorMessages";//$NON-NLS-1$
	private static ResourceBundle fgBundleForConstructedKeys= ResourceBundle.getBundle(BUNDLE_FOR_CONSTRUCTED_KEYS);

	/**
	 * Returns the message bundle which contains constructed keys.
	 *
	 * @since 3.1
	 * @return the message bundle
	 */
	public static ResourceBundle getBundleForConstructedKeys() {
		return fgBundleForConstructedKeys;
	}

	private static final String BUNDLE_NAME= EmbeddedEditorMessages.class.getName();

	private EmbeddedEditorMessages() {
		// Do not instantiate
	}

	public static String Editor_error_no_provider;
	public static String Editor_error_save_title;
	public static String Editor_error_save_message;
	public static String Editor_error_save_deleted_title;
	public static String Editor_error_save_deleted_message;
	public static String Editor_error_init;
	public static String Editor_error_save_outofsync_title;
	public static String Editor_error_save_outofsync_message;
	public static String Editor_error_activated_outofsync_title;
	public static String Editor_error_activated_outofsync_message;
	public static String Editor_error_activated_deleted_save_title;
	public static String Editor_error_activated_deleted_save_message;
	public static String Editor_error_activated_deleted_save_button_save;
	public static String Editor_error_activated_deleted_save_button_close;
	public static String Editor_error_activated_deleted_close_title;
	public static String Editor_error_activated_deleted_close_message;
	public static String Editor_error_refresh_outofsync_title;
	public static String Editor_error_refresh_outofsync_message;
	public static String Editor_error_revert_title;
	public static String Editor_error_revert_message;
	public static String Editor_error_setinput_title;
	public static String Editor_error_setinput_message;
	public static String Editor_error_validateEdit_title;
	public static String Editor_error_validateEdit_message;
	public static String Editor_error_HyperlinkDetector_couldNotCreate_message;
	public static String Editor_error_HyperlinkDetector_invalidElementName_message;
	public static String Editor_error_HyperlinkDetector_invalidExtension_message;
	public static String Editor_error_HyperlinkDetectorTarget_invalidElementName_message;
	public static String Editor_error_HyperlinkDetectorTarget_invalidExtension_message;
	public static String AbstractDocumentProvider_error_save_inuse;
	public static String Editor_mark_status_message_mark_set;
	public static String Editor_mark_status_message_mark_cleared;
	public static String Editor_mark_status_message_mark_swapped;
	public static String MarkRegionTarget_markNotSet;
	public static String MarkRegionTarget_markNotVisible;
	public static String Editor_FindIncremental_name;
	public static String Editor_FindIncremental_reverse_name;
	public static String Editor_FindIncremental_not_found_pattern;
	public static String Editor_FindIncremental_found_pattern;
	public static String Editor_FindIncremental_render_tab;
	public static String Editor_FindIncremental_wrapped;
	public static String Editor_FindIncremental_reverse;
	public static String Editor_ConvertLineDelimiter_title;
	public static String Editor_statusline_state_readonly_label;
	public static String Editor_statusline_state_writable_label;
	public static String Editor_statusline_mode_insert_label;
	public static String Editor_statusline_mode_overwrite_label;
	public static String Editor_statusline_mode_smartinsert_label;
	public static String Editor_statusline_position_pattern;
	public static String Editor_statusline_error_label;
	public static String WorkbenchChainedTextFontFieldEditor_defaultWorkbenchTextFont;
	public static String FindReplace_title;
	public static String FindReplace_Find_label;
	public static String FindReplace_Replace_label;
	public static String FindReplace_Direction;
	public static String FindReplace_ForwardRadioButton_label;
	public static String FindReplace_BackwardRadioButton_label;
	public static String FindReplace_Scope;
	public static String FindReplace_GlobalRadioButton_label;
	public static String FindReplace_SelectedRangeRadioButton_label;
	public static String FindReplace_Options;
	public static String FindReplace_CaseCheckBox_label;
	public static String FindReplace_WrapCheckBox_label;
	public static String FindReplace_WholeWordCheckBox_label;
	public static String FindReplace_IncrementalCheckBox_label;
	public static String FindReplace_RegExCheckbox_label;
	public static String FindReplace_FindNextButton_label;
	public static String FindReplace_ReplaceFindButton_label;
	public static String FindReplace_ReplaceSelectionButton_label;
	public static String FindReplace_ReplaceAllButton_label;
	public static String FindReplace_CloseButton_label;
	public static String FindReplace_Status_noMatch_label;
	public static String FindReplace_Status_replacement_label;
	public static String FindReplace_Status_replacements_label;
	public static String FindNext_Status_noMatch_label;
	public static String AbstractDocumentProvider_ok;
	public static String AbstractDocumentProvider_error;
	public static String FindReplaceDialog_read_only;
	public static String Editor_MoveLines_IllegalMove_status;
	public static String Editor_error_clipboard_copy_failed_message;

	static {
		NLS.initializeMessages(BUNDLE_NAME, EmbeddedEditorMessages.class);
	}

}
