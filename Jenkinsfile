node {
	properties([
		[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '15']],
		parameters([
			choice(choices: 'luna\noxygen\nphoton\nlatest', description: 'Which Target Platform should be used?', name: 'target_platform')
		])
	])
	
	stage('Checkout') {
		checkout scm
		if ("latest" == params.target_platform) {
			currentBuild.displayName = "#${BUILD_NUMBER}(x)"
		} else if ("oxygen" == params.target_platform) {
			currentBuild.displayName = "#${BUILD_NUMBER}(o)"
		} else if ("photon" == params.target_platform) {
			currentBuild.displayName = "#${BUILD_NUMBER}(p)"
		} else {
			currentBuild.displayName = "#${BUILD_NUMBER}(l)"
		}
	}
	
	stage('Gradle Build') {
		sh "./gradlew clean cleanGenerateXtext build createLocalMavenRepo -PuseJenkinsSnapshots=true -PcompileXtend=true -PignoreTestFailures=true --refresh-dependencies --continue"
		step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/test/*.xml'])
	}
	
	def workspace = pwd()
	def mvnHome = tool 'M3'
	env.M2_HOME = "${mvnHome}"
	dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
	dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
	
	stage('Maven Plugin Build') {
		sh "${mvnHome}/bin/mvn -f maven-pom.xml --batch-mode --update-snapshots -fae -PuseJenkinsSnapshots -Dmaven.test.failure.ignore=true -Dmaven.repo.local=${workspace}/.m2/repository -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn clean deploy"
	}
	
	stage('Maven Tycho Build') {
		def targetProfile = "-Pluna"
		if ("latest" == params.target_platform) {
			targetProfile = "-Platest"
		} else if ("oxygen" == params.target_platform) {
			targetProfile = "-Poxygen"
		} else if ("photon" == params.target_platform) {
			targetProfile = "-Pphoton"
		}
		wrap([$class:'Xvnc', useXauthority: true]) {
			sh "${mvnHome}/bin/mvn -f tycho-pom.xml --batch-mode -fae -Dmaven.test.failure.ignore=true -Dmaven.repo.local=${workspace}/.m2/repository -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn ${targetProfile} clean install"
		}
		step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/*.xml'])
	}
	
	stage('Gradle Longrunning Tests') {
		sh "./gradlew longrunningTest -PuseJenkinsSnapshots=true -PignoreTestFailures=true --continue"
		step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/longrunningTest/*.xml'])
	}
	
	archive 'build/**'
}
