node {
	properties([
		[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '15']],
		pipelineTriggers([cron('H 2 * * *')])
	])
	
	stage('Checkout') {
		checkout scm
		
		dir('build') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
	}
	
	stage('Maven Build') {
		def workspace = pwd()
		def mvnHome = tool 'M3'
		sh "${mvnHome}/bin/mvn -f releng --batch-mode --update-snapshots -fae -Dmaven.repo.local=${workspace}/.m2/repository clean install"
	}
	
	archive 'build/**'
}
