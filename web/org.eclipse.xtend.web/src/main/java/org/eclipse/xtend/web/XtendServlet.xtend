/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.web

import com.google.inject.Provider
import java.io.IOException
import java.util.List
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.xtext.web.servlet.XtextServlet

/**
 * Deploy this class into a servlet container to enable DSL-specific services.
 */
@WebServlet(name = 'XtextServices', urlPatterns = '/xtext-service/*')
class XtendServlet extends XtextServlet {
	
	val List<ExecutorService> executorServices = newArrayList
	
	override init() {
		super.init()
		val Provider<ExecutorService> executorServiceProvider = [Executors.newCachedThreadPool => [executorServices += it]]
		new XtendWebSetup(executorServiceProvider).createInjectorAndDoEMFRegistration()
	}
	
	override destroy() {
		executorServices.forEach[shutdown()]
		executorServices.clear()
		super.destroy()
	}
	
	override protected doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		val service = getService(req)
		doService(service, resp)
	}
	
}
