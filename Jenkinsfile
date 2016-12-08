// tell Jenkins how to build projects from this repository
node {
	try {
		stage 'Checkout'
		checkout scm
			
		stage 'Maven Build'
		dir('build') {
    		deleteDir()
		}
		def mvnHome = tool 'M3'
		wrap([$class:'Xvnc', useXauthority: true]) {
			sh "${mvnHome}/bin/mvn --batch-mode -fae -Dmaven.test.failure.ignore=true -Dmaven.repo.local=.m2/repository clean install"
		}
		archive 'build/**/*.*'
				

        if('UNSTABLE' == currentBuild.result) {
            slackSend color: 'warning', message: "Build Unstable - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        } else {
            slackSend color: 'good', message: "Build Succeeded - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
	} catch (e) {
		slackSend color: 'danger', message: "Build Failed - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
		throw e
	} finally {
		step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/*.xml'])
	}
}
