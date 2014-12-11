/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.ng.debug

import java.util.IdentityHashMap
import java.util.Map
import org.eclipse.core.internal.jobs.JobManager
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.jobs.IJobChangeEvent
import org.eclipse.core.runtime.jobs.IJobChangeListener
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.xtend.lib.annotations.Accessors

import static org.eclipse.core.runtime.jobs.Job.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class JobConsoleLogger implements IJobChangeListener {

	val IdentityHashMap<Job, JobInfo> jobs = new IdentityHashMap

	new() {
		Job.getJobManager.addJobChangeListener(this)
	}

	def private boolean isInteresting(Job job) {
		job.belongsTo(ResourcesPlugin.FAMILY_AUTO_BUILD) || job.belongsTo(ResourcesPlugin.FAMILY_MANUAL_BUILD)
	}

	def private void log(String eventName, IJobChangeEvent event) {
		val job = event.job
		if (!job.isInteresting)
			return;
		val current = new JobInfo(job)
		val old = jobs.get(job)
		jobs.put(job, current)
		val msg = if(old != null) old.compareWithNew(current) else current.toString
		XtextCompilerConsole.log("Job: " + msg)
	}

	override aboutToRun(IJobChangeEvent event) {
		log("aboutToRun", event)
	}

	override awake(IJobChangeEvent event) {
		log("awake", event)
	}

	override done(IJobChangeEvent event) {
		log("done", event)
	}

	override running(IJobChangeEvent event) {
		log("running", event)
	}

	override scheduled(IJobChangeEvent event) {
		log("scheduled", event)
	}

	override sleeping(IJobChangeEvent event) {
		log("sleeping", event)
	}
}

@Accessors class JobInfo {
	val String name
	val Map<String, String> properties

	new(Job job) {
		name = job.name
		properties = #{
			"threadName" -> job.thread?.name,
			"state" -> JobManager.printState(job),
			"priority" -> switch p: job.priority {
				case INTERACTIVE: '''INTERACTIVE («p»)'''
				case SHORT: '''SHORT («p»)'''
				case LONG: '''LONG («p»)'''
				case BUILD: '''BUILD («p»)'''
				case DECORATE: '''DECORATE («p»)'''
				default:
					p.toString
			}
		}
	}

	override toString() {
		return name + ": " + properties.entrySet.map['''«key»: «value»'''].join(", ")
	}

	def String compareWithNew(JobInfo current) {
		val changed = properties.filter[k, v|v != current.properties.get(k)]
		val changes = changed.entrySet.map['''«key»: «value» -> «current.properties.get(key)»'''].toSet
		if (current.name != name)
			changes += "renamed to: " + current.name
		return name + ": " + changes.join(", ")
	}

}
