package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import org.eclipse.osgi.util.NLS;

public class TemplateDialogMessages extends NLS {

	private static final String BUNDLE_NAME= "org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplateDialogMessages";//$NON-NLS-1$

	private TemplateDialogMessages() {
		// Do not instantiate
	}
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, TemplateDialogMessages.class);
	}
	
	public static String EditTemplateDialog_error_noname;
	public static String EditTemplateDialog_error_invalidName;
	public static String EditTemplateDialog_title_new;
	public static String EditTemplateDialog_title_edit;
	public static String EditTemplateDialog_name;
	public static String EditTemplateDialog_description;
	public static String EditTemplateDialog_context;
	public static String EditTemplateDialog_pattern;
	public static String EditTemplateDialog_insert_variable;
	public static String EditTemplateDialog_undo;
	public static String EditTemplateDialog_redo;
	public static String EditTemplateDialog_cut;
	public static String EditTemplateDialog_copy;
	public static String EditTemplateDialog_paste;
	public static String EditTemplateDialog_select_all;
	public static String EditTemplateDialog_content_assist;
	public static String EditTemplateDialog_autoinsert;
}
