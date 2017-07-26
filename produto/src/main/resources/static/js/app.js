angular.module('appProduct', ['ngAnimate', 'ngRoute','ngResource']) 
	.config(function($routeProvider, $locationProvider) {
		
		$routeProvider.when('/product', {
			templateUrl: 'partials/products.html',
			controller: 'ProductController'
		})
		.when('/products/new', {
			templateUrl: 'partials/productsform.html',
			controller: 'ProductController'
		})
		.when('/products/list', {
			templateUrl: 'partials/productslist.html',
			controller: 'PreferencialController'
		});
		
		$routeProvider.otherwise({redirectTo: '/product'});
		
		$locationProvider.html5Mode(false);
});