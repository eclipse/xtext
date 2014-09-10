/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking

import org.eclipse.jface.preference.IPreferenceStore
import org.eclipse.jface.text.hyperlink.IHyperlink
import org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.jface.text.Region
import org.eclipse.jface.text.JFaceTextUtil

/**
 * The MultipleHyperLinkPresenter only shows the hyper link text when more then one hyper link exists.
 * This is not always desired as some hyperlinks might have special meaning, and without showing the user what the hyperlink does 
 * only simple go to declaration hyperlinks should be treated like that.
 * 
 * Thus this class introduces a protocol for IHyperLinks to make sure their label is shown even if they are the only one.
 * To do so the property IHyperLink#getTypeLabel needs to be set to the constant SHOW_ALWAYS.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
class SingleHoverShowingHyperlinkPresenter extends MultipleHyperlinkPresenter {
	
	extension ReflectExtensions reflect = new ReflectExtensions
	
	/**
	 * constant text needs to set into IHyperLink#getTypeLabel (which doesn't seem to be used otherwise)
	 * if a hyperlink's label should be shown even if it's the only hyper link.
	 */
	public final static String SHOW_ALWAYS = "SHOW_ALWAYS"; 
	
	new(RGB color) {
		super(color)
	}
	
	new(IPreferenceStore store) {
		super(store)
	}

	override showHyperlinks(IHyperlink[] activeHyperlinks) {
		super.showHyperlinks(activeHyperlinks)
		if (activeHyperlinks.length == 1 && activeHyperlinks.get(0).typeLabel!=null && activeHyperlinks.get(0).typeLabel.contains(SHOW_ALWAYS)) {
			val int start= activeHyperlinks.get(0).getHyperlinkRegion().getOffset();
			val int end= start + activeHyperlinks.get(0).getHyperlinkRegion().getLength();

			this.set('fSubjectRegion', new Region(start, end - start))
			this.set('fCursorOffset' , JFaceTextUtil.getOffsetForCursorLocation(this.get('fTextViewer')))
			this.get('fManager').invoke('showInformation');
		}
	}
	
}