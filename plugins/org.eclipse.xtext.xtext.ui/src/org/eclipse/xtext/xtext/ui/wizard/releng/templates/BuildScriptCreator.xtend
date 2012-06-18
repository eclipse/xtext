package org.eclipse.xtext.xtext.ui.wizard.releng.templates

import org.eclipse.xtext.xtext.ui.wizard.releng.RelengProjectInfo
/**
 * Creates ant script that starts buckminster headlessbuild.<br>
 *
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class BuildScriptCreator {
	
	
	/**
	 * Creates ant script that starts buckminster headlessbuild.<br>
	 * @param projectInfo Project configuration to use
	 */
	def CharSequence createScript(RelengProjectInfo projectInfo) {
		
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<!--
		     Buckminster Headless - build
		
		     Properties:
		     	WORKSPACE  			Eclipse workspace location, or hudson job workspace
		     	build.root 			Where to build? WARNING: This folder will be cleaned up, so do not point to user.home or something important
									Default: ${WORKSPACE}/buildroot
				buckminster.home	Buckminster headless to use. See http://www.eclipse.org/buckminster/downloads.html
				projects.location	Where to find projects to build?
									Default: ${WORKSPACE}
				commands.file		What to do?
									Default: ${projects.location}/«projectInfo.projectName»/commands.txt
		-->
		<project name="Buckminster Headless" default="buckminster">
			<property name="WORKSPACE" location="${ant.file}/../../" />
			<property name="build.root" location="${WORKSPACE}/buildroot" />
			<property name="buckminster.home" location="«if (!projectInfo.buckyLocation.nullOrEmpty) projectInfo.buckyLocation else "Add_buckminster_headless_location_here"»" />
			<property name="projects.location" location="${WORKSPACE}" />
			<property name="commands.file" location="${projects.location}/«projectInfo.projectName»/commands.txt" />
			<property name="target.platform" value="target.platform" />
			
			<target name="buckminster" depends="cleanup" description="description">
				<echo message="IMPORTANT: Populating an empty target platform may took over 10 minutes."/>
				<condition property="executable.file" value="buckminster.bat" else="buckminster">
					<os family="windows"/>
				</condition>
				<exec executable="${buckminster.home}/${executable.file}">
					<arg value="-Dprojects.location=${projects.location}" />
					<arg value="-Dbuckminster.output.root=${build.root}/buckminster.output" />
					<arg value="-Dbuckminster.temp.root=${build.root}/buckminster.temp" />
					<arg value="-Dtarget.platform=${build.root}/${target.platform}" />
					<arg line="-data '${build.root}/buckminster.workspace'" />
					<arg line="-configuration '${build.root}/configuration'" />
					<arg line="-S '${commands.file}'" />
				</exec>
				<echo message=" "/>
				<echo message="Updatesite output in: ${build.root}/buckminster.output/«projectInfo.siteFeatureProjectName»_*-eclipse.feature/site.p2/"/>
			</target>
		
			<target name="cleanup">
				<delete failonerror="false" includeemptydirs="true">
					<fileset dir="${build.root}" defaultexcludes="false">
						<exclude name="**/.metadata/.plugins/org.eclipse.pde.core/.bundle_pool/" />
						<exclude name="**/${target.platform}/" />
					</fileset>
				</delete>
			</target>
		
			<target name="reset.target-platform">
				<delete includeemptydirs="true">
					<fileset dir="${build.root}" defaultexcludes="false">
						<include name="**/.metadata/.plugins/org.eclipse.pde.core/.bundle_pool/" />
						<include name="**/${target.platform}/" />
					</fileset>
				</delete>
			</target>
		</project>
		'''
	}
}