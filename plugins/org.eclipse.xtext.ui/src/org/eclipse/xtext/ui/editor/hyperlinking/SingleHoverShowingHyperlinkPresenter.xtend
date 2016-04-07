/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import org.eclipse.jface.text.AbstractInformationControlManager
import org.eclipse.jface.text.JFaceTextUtil
import org.eclipse.jface.text.Region
import org.eclipse.jface.text.hyperlink.IHyperlink
import org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.apache.log4j.Logger

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
@FinalFieldsConstructor
class SingleHoverShowingHyperlinkPresenter implements InvocationHandler {

	private static final Logger log = Logger.getLogger(SingleHoverShowingHyperlinkPresenter)
	
	extension ReflectExtensions reflect = new ReflectExtensions
	
	/**
	 * constant text needs to set into IHyperLink#getTypeLabel (which doesn't seem to be used otherwise)
	 * if a hyperlink's label should be shown even if it's the only hyper link.
	 */
	public final static String SHOW_ALWAYS = "SHOW_ALWAYS" 
	
	val MultipleHyperlinkPresenter delegate
	
	override invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.name.startsWith('showHyperlinks') && args.length >= 1 && args.get(0) instanceof IHyperlink[]) {
			val nullsafe = makeNullsafe(args.get(0) as IHyperlink[])
			if (nullsafe.length > 0) {
				args.set(0, nullsafe)
				val result = method.invoke(delegate, args)
				val activeHyperlinks = nullsafe
				if (activeHyperlinks.length == 1) {
					val singleHyperlink = activeHyperlinks.get(0)
					if (SHOW_ALWAYS == singleHyperlink.typeLabel) {
						val int start= singleHyperlink.getHyperlinkRegion().getOffset();
						val int end= start + singleHyperlink.getHyperlinkRegion().getLength();
						delegate.set('fSubjectRegion', new Region(start, end - start))
						delegate.set('fCursorOffset' , JFaceTextUtil.getOffsetForCursorLocation(delegate.get('fTextViewer')))
						(delegate.get('fManager') as AbstractInformationControlManager).showInformation
					}
				}
				return result	
			}
			return null // showHyperlinks returns void 
		}
		return method.invoke(delegate, args)
	}
	
	/**
	 * @since 2.9
	 */
	protected def IHyperlink[] makeNullsafe(IHyperlink[] arr) {
		if (arr.exists[it === null || it.hyperlinkRegion === null]) {
			val list = newArrayList
			for (it : arr) {
				if (it !== null && it.hyperlinkRegion !== null) {
					list.add(it)
				} else {
					log.warn('Filtered invalid hyperlink: '+ it.getClass.name)
				}
			}
			return list.toArray(newArrayOfSize(list.size))
		}
		return arr
	}
	
}