node {
	try {
		properties([
			[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '15']]
		])
		
		stage 'Checkout'
		checkout scm
		
		dir('build') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
		
		stage 'Maven Build'
		def workspace = pwd()
        def mvnHome = tool 'M3'
		sh "${mvnHome}/bin/mvn -f releng --batch-mode --update-snapshots -fae -Dmaven.repo.local=${workspace}/.m2/repository clean install"
		archive 'build/**'
		
		slackSend "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	}
}
