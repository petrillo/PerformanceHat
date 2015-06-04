'use strict';

/**
 * Created by Emanuel Stoeckli on 02.06.15.
 */

angular.module('FeedbackApp')
  .config(function($stateProvider, VIEWS_DIR) {

    $stateProvider
      .state('environment', {
        url: '/environment',
        controller: 'EnvironmentCtrl',
        templateUrl: VIEWS_DIR + 'environment/template.html'
      });

  });
