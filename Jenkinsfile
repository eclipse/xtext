node {
	properties([
		[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '15']],
		pipelineTriggers([cron('H 2 * * *')])
	])
	
	stage('Checkout') {
		sh '''
			if [ -d ".git" ]; then
				git reset --hard
			fi
		'''
		
		checkout scm
		dir('build') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtext') { deleteDir() }
		dir('.m2/repository/org/eclipse/xtend') { deleteDir() }
		
		sh '''
			sed_inplace() {
				if [[ "$OSTYPE" == "darwin"* ]]; then
					sed -i '' "$@"
				else
					sed -i "$@" 
				fi	
			}
			
			targetfiles="$(find releng -type f -iname '*.target')"
			for targetfile in $targetfiles
			do
				echo "Redirecting target platforms in $targetfile to $JENKINS_URL"
				sed_inplace "s?<repository location=\\".*/job/\\([^/]*\\)/job/\\([^/]*\\)/?<repository location=\\"$JENKINS_URL/job/\\1/job/\\2/?" $targetfile
			done
		'''
	}
	
	stage('Maven Build') {
		def workspace = pwd()
		def mvnHome = tool 'M3'
		sh "${mvnHome}/bin/mvn -f releng --batch-mode --update-snapshots -fae -Dmaven.repo.local=${workspace}/.m2/repository clean install"
	}
	
	archive 'build/**'
}
