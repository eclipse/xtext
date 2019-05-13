pipeline {
  agent any

  parameters {
    choice(name: 'TARGET_PLATFORM', choices: ['oxygen', 'latest', 'r201903', 'r201812', 'r201809','r201903', 'photon'], description: 'Which Target Platform should be used?')
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'5'))
    disableConcurrentBuilds()
  }

  tools { 
    maven 'M3'
  }
  
  stages {
    stage('Prepare') {
      steps {
        checkout scm
        
        script {
          if ("latest" == params.TARGET_PLATFORM) {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.12)"
          } else if ("r201903" == params.target_platform) {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.11)"
          } else if ("r201812" == params.TARGET_PLATFORM) {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.10)"
          } else if ("r201809" == params.TARGET_PLATFORM) {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.9)"
          } else if ("photon" == params.TARGET_PLATFORM) {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.8)"
          } else {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.7)"
          }
        }
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
    }

    stage('Build') {
      steps {
        wrap([$class:'Xvnc', useXauthority: true]) {
          sh "./1-maven-build.sh --tp=${params.TARGET_PLATFORM}"
        }
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/*.xml'])
      }
    }
  }

  post {
    success {
      archiveArtifacts artifacts: 'build/**'
    }
    failure {
      archiveArtifacts artifacts: '**/target/work/data/.metadata/.log, **/hs_err_pid*.log'
    }
    changed {
      script {
        def envName = ''
        if (env.JENKINS_URL.contains('ci.eclipse.org/xtext')) {
          envName = ' (JIPP)'
        } else if (env.JENKINS_URL.contains('jenkins.eclipse.org/xtext')) {
          envName = ' (CBI)'
        } else if (env.JENKINS_URL.contains('typefox.io')) {
          envName = ' (TF)'
        }
        
        def curResult = currentBuild.currentResult
        def color = '#00FF00'
        if (curResult == 'SUCCESS' && currentBuild.previousBuild != null) {
          curResult = 'FIXED'
        } else if (curResult == 'UNSTABLE') {
          color = '#FFFF00'
        } else if (curResult == 'FAILURE') {
          color = '#FF0000'
        }
        
        slackSend message: "${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}${envName}>", botUser: true, channel: 'xtext-builds', color: "${color}"
      }
    }
  }
}
