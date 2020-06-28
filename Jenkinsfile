pipeline {
  agent {
    kubernetes {
      label 'centos-7'
    }
  }
  
  environment {
    DOWNSTREAM_JOBS = 'xtext-xtend'
  }

  parameters {
    choice(name: 'target_platform', choices: ['oxygen', 'photon', 'r201809', 'r201812', 'r201903', 'r201906', 'r201909', 'r201912', 'r202003', 'r202006', 'latest' ], description: 'Which Target Platform should be used?')
    // see https://wiki.eclipse.org/Jenkins#JDK
    choice(name: 'JDK_VERSION', description: 'Which JDK should be used?', choices: [
       'adoptopenjdk-hotspot-jdk8-latest', 'adoptopenjdk-hotspot-jdk11-latest', 'adoptopenjdk-hotspot-latest'
    ])
    booleanParam(
      name: 'TRIGGER_DOWNSTREAM_BUILD', 
      defaultValue: (env.BRANCH_NAME.startsWith('milestone')||env.BRANCH_NAME.startsWith('release')), 
      description: 'Should downstream jobs for the same branch be triggered on successful build?'
    )
  }

  triggers {
    parameterizedCron(env.BRANCH_NAME == 'master' ? 'H H(0-1) * * * %target_platform=latest;JDK_VERSION=adoptopenjdk-hotspot-jdk11-latest' : '')
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'5'))
    disableConcurrentBuilds()
    timeout(time: 240, unit: 'MINUTES')
  }

  tools {
     maven "apache-maven-latest"
     jdk "${params.JDK_VERSION}"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        
        script {
          if (params.target_platform == 'latest') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.17)"
          } else if (params.target_platform == 'r202006') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.16)"
          } else if (params.target_platform == 'r202003') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.15)"
          } else if (params.target_platform == 'r201912') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.14)"
          } else if (params.target_platform == 'r201909') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.13)"
          }  else if (params.target_platform == 'r201906') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.12)"
          } else if (params.target_platform == 'r201903') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.11)"
          }  else if (params.target_platform == 'r201812') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.10)"
          } else if (params.target_platform == 'r201809') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.9)"
          } else if (params.target_platform == 'photon') {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.8)"
          } else {
            currentBuild.displayName = "#${BUILD_NUMBER}(4.7)"
          }
        }

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
          wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
          sh """
            ./1-maven-build.sh -s /home/jenkins/.m2/settings.xml --tp=${params.target_platform} --local-repository=/home/jenkins/.m2/repository
          """
          }
      }
    }
  }

  post {
    always {
      junit testResults: '**/target/surefire-reports/*.xml'
    }
    success {
      archiveArtifacts artifacts: 'build/**'
      script {
        if (params.TRIGGER_DOWNSTREAM_BUILD==true) {
          DOWNSTREAM_JOBS.split(',').each {
            def downstreamUrl = new URL("${env.JENKINS_URL}/job/$it/job/${env.BRANCH_NAME}")
            def boolean downstreamJobExists = sh(script: "curl -L -s -o /dev/null -I -w '%{http_code}' ${downstreamUrl}", returnStdout: true) == "200"
            if (downstreamJobExists) {
              build job: "$it/${env.BRANCH_NAME}", wait: false, parameters: [booleanParam(name: 'TRIGGER_DOWNSTREAM_BUILD', value: "${params.TRIGGER_DOWNSTREAM_BUILD}")]
            }
          }
        }
      }
    }
    failure {
      archiveArtifacts artifacts: '**/target/work/data/.metadata/.log, **/hs_err_pid*.log'
    }
    cleanup {
      script {
        def curResult = currentBuild.currentResult
        def lastResult = 'NEW'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }

        if (curResult != 'SUCCESS' || lastResult != 'SUCCESS') {
          def color = ''
          switch (curResult) {
            case 'SUCCESS':
              color = '#00FF00'
              break
            case 'UNSTABLE':
              color = '#FFFF00'
              break
            case 'FAILURE':
              color = '#FF0000'
              break
            default: // e.g. ABORTED
              color = '#666666'
          }

          slackSend (
            message: "${lastResult} => ${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>",
            botUser: true,
            channel: 'xtext-builds',
            color: "${color}"
          )
        }
      }
    }
  }
}