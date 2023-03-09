/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class SyntaxColoringPreferencePage extends AbstractPreferencePage implements IHighlightingConfigurationAcceptor, Comparator<Triple<String, String, TextStyle>> {

	private final List<Triple<String, String, TextStyle>> highlightings;

	@Inject
	private PreferenceStoreAccessor preferenceStoreAccessor;

	public SyntaxColoringPreferencePage() {
		this.highlightings = new ArrayList<Triple<String, String, TextStyle>>();
	}
	
	@Override
	protected String qualifiedName() {
		return PreferenceStoreAccessor.syntaxColorerTag(getLanguageName());
	}

	@Inject
	public void collectHighlightings(IHighlightingConfiguration configuration) {
		configuration.configure(this);
	}
	
	@Override
	public void acceptDefaultHighlighting(String id, String name, TextStyle style) {
		highlightings.add(Tuples.create(id, name, style));
	}
	
	@Override
	protected void createFieldEditors() {
		refreshAttributes();
		addField(new TokenTypeDefMasterDetailFieldEditor(CommonPreferenceConstants.TOKEN_STYLES_PREFERENCE_TAG,
				Messages.SyntaxColoringPreferencePage_tokenStyles, getFieldEditorParent(), getPreferenceStore(), highlightings));
	}

	protected void refreshAttributes() {
		Collections.sort(highlightings, this);
		for (Triple<String, String, TextStyle> highlighting : highlightings) {
			preferenceStoreAccessor.populateTextStyle(highlighting.getFirst(), new TextStyle(), highlighting.getThird());
		}
	}

	@Override
	public int compare(Triple<String, String, TextStyle> left, Triple<String, String, TextStyle> right) {
		return left.getSecond().compareTo(right.getSecond());
	}
	
	/**
	 * TODO: better use unqualified names in preference store. Left this workaround not to break API.
	 */
	@Override
	protected void addField(FieldEditor editor) {
		editor.setPreferenceName(qualifiedName() + "." + editor.getPreferenceName());
		super.addField(editor);
	}

}
