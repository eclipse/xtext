// Tell Jenkins how to build projects from this repository
node {
	try {
		properties([
			[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '15']]
		])
		
		stage 'Checkout'
		checkout scm
		
		dir('build') {
			deleteDir()
		}
		
		stage 'Gradle Build'
		try {
			sh "./gradlew clean cleanGenerateXtext build createLocalMavenRepo -PuseJenkinsSnapshots=true -PcompileXtend=true --refresh-dependencies --continue"
			archive 'build/maven-repository/**/*.*'
		} finally {
			step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/test/*.xml'])
		}
		
		def workspace = pwd()
		def mvnHome = tool 'M3'
		env.M2_HOME = "${mvnHome}"
		dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
		try {
			stage 'Maven Plugin Build'
			sh "${mvnHome}/bin/mvn -f maven-pom.xml --batch-mode --update-snapshots -fae -PuseJenkinsSnapshots -Dmaven.test.failure.ignore=true -Dmaven.repo.local=${workspace}/.m2/repository clean deploy"
			
			stage 'Maven Tycho Build'
			wrap([$class:'Xvnc', useXauthority: true]) {
				sh "${mvnHome}/bin/mvn -f tycho-pom.xml --batch-mode -fae -Dmaven.test.failure.ignore=true -Dmaven.repo.local=${workspace}/.m2/repository clean install"
			}
			
			archive 'build/**'
		} finally {
			step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/*.xml'])
		}
		
		stage 'Gradle Longrunning Tests'
		try {
			sh "./gradlew longrunningTest -PuseJenkinsSnapshots=true --continue"
		} finally {
			step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/longrunningTest/*.xml'])
		}
		
		if ('UNSTABLE' == currentBuild.result) {
			slackSend color: 'warning', message: "Build Unstable - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		} else {
			slackSend color: 'good', message: "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		}
		
	} catch (e) {
		// TODO catch interrupt error instead
		if ('ABORTED' == currentBuild.result) { 
			slackSend message: "Build Aborted - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		} else {
			slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		}
		throw e
	}
}
